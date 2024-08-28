package com.project.project.service.auth;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.project.config.security.TokenService;
import com.project.project.constants.MessageConstants;
import com.project.project.constants.StringConstants;
import com.project.project.dto.address.AddressDTO;
import com.project.project.dto.auth.ForgotPasswordDTO;
import com.project.project.dto.auth.LoginDTO;
import com.project.project.dto.auth.RegisterUserDTO;
import com.project.project.dto.user.UserDTO;
import com.project.project.exception.BadRequestException;
import com.project.project.exception.CustomForbiddenException;
import com.project.project.exception.NotFoundException;
import com.project.project.exception.UnauthorizedException;
import com.project.project.model.user.User;
import com.project.project.repository.user.UserRepository;
import com.project.project.service.system.TwilioService;
import com.project.project.service.user.AddressService;
import com.project.project.service.user.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private TwilioService twilioService;

    public Map<String, Object> login(LoginDTO body) {
	Map<String, Object> response = new HashMap<>();
	User user = userRepository.findByCellPhone(body.cellPhone())
		.orElseThrow(() -> new NotFoundException(MessageConstants.INVALID_USER));
	if (passwordEncoder.matches(body.password(), user.getPassword())) {
	    if (!user.getActiveUser()) {
		String otpSid = twilioService.sendVerificationSms(user.getCellPhone());
		String token = tokenService.generateToken(user);
		response.put(StringConstants.TOKEN, token);
		response.put(StringConstants.OTPSID, otpSid);
		response.put(StringConstants.MESSAGE, MessageConstants.FORBIDDEN_ERROR);
		throw new CustomForbiddenException(response);
	    }
	    String token = tokenService.generateToken(user);
	    response.put(StringConstants.NAME, user.getName());
	    response.put(StringConstants.TOKEN, token);
	    response.put(StringConstants.ACTIVE_USER, user.getActiveUser());
	    return response;
	}
	throw new UnauthorizedException(MessageConstants.UNAUTHORIZED_ERROR);
    }

    @Transactional
    public Map<String, Object> register(RegisterUserDTO body) {
	Map<String, Object> response = new HashMap<>();
	UserDTO userDTO = body.user();
	AddressDTO addressDTO = body.address();
	Optional<User> existingUser = userRepository.findByCellPhone(userDTO.cellPhone());
	if (existingUser.isPresent()) {
	    throw new BadRequestException(MessageConstants.USER_ALREADY_EXISTS);
	}
	User newUser = userService.userRegister(userDTO);
	addressService.createAddress(newUser.getId(), addressDTO);
	String token = tokenService.generateToken(newUser);
	twilioService.sendVerificationSms(userDTO.cellPhone());
	response.put(StringConstants.NAME, newUser.getName());
	response.put(StringConstants.TOKEN, token);
	return response;
    }

    public Map<String, Object> forgotPassword(ForgotPasswordDTO body) {
	Optional<User> userOpt = userRepository.findByCellPhone(body.cellPhone());
	if (!userOpt.isPresent()) {
	    throw new NotFoundException(MessageConstants.INVALID_USER);
	}
	User user = userOpt.get();
	if (!user.getActiveUser()) {
	    throw new BadRequestException(MessageConstants.FORBIDDEN_ERROR);
	}
	String otp = twilioService.sendVerificationSms(user.getCellPhone());
	Map<String, Object> response = new HashMap<>();
	response.put(StringConstants.MESSAGE, MessageConstants.SEND_OTP);
	response.put(StringConstants.OTP, otp);
	return response;
    }

    public void updatePassword(UUID id, String newPassword) {
	User user = userRepository.findById(id).orElse(null);
	if (user != null) {
	    user.setPassword(passwordEncoder.encode(newPassword));
	    userRepository.save(user);
	}
    }

    public String recoverToken(HttpServletRequest request) {
	var authHeader = request.getHeader(StringConstants.AUTHORIZATION);
	if (authHeader == null || !authHeader.startsWith(StringConstants.BEARER)) {
	    return null;
	}
	return authHeader.substring(7);
    }
}
