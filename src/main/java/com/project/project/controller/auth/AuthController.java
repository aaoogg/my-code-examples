package com.project.project.controller.auth;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.project.constants.MessageConstants;
import com.project.project.constants.ResourcePathAndActionsConstants;
import com.project.project.constants.StringConstants;
import com.project.project.dto.auth.ForgotPasswordDTO;
import com.project.project.dto.auth.LoginDTO;
import com.project.project.dto.auth.RegisterUserDTO;
import com.project.project.dto.auth.ResetPasswordDTO;
import com.project.project.dto.auth.VerifyOtpDTO;
import com.project.project.exception.BadRequestException;
import com.project.project.exception.NotFoundException;
import com.project.project.model.user.User;
import com.project.project.service.auth.AuthService;
import com.project.project.service.system.CaptchaService;
import com.project.project.service.system.JwtService;
import com.project.project.service.system.RateLimiterBlacklistService;
import com.project.project.service.system.TwilioService;
import com.project.project.service.user.UserService;
import com.project.project.util.RateLimiter;
import com.project.project.util.ResponseUtil;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(ResourcePathAndActionsConstants.AUTH)
@CrossOrigin(origins = ResourcePathAndActionsConstants.ORIGIN)
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private CaptchaService captchaService;

    @Autowired
    private UserService userService;

    @Autowired
    private TwilioService twilioService;

    @Autowired
    private JwtService jwtService;

    private final RateLimiter rateLimiter;

    @Autowired
    public AuthController(RateLimiterBlacklistService rateLimiterBlacklistService) {
	this.rateLimiter = new RateLimiter(3, 60000, rateLimiterBlacklistService);
    }

    @PostMapping(ResourcePathAndActionsConstants.LOGIN)
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginDTO body, HttpServletRequest request) {
	ResponseEntity<Map<String, Object>> rateLimitResponse = rateLimiter.checkRateLimit(request);
	if (rateLimitResponse.getStatusCode() != HttpStatus.OK) {
	    return rateLimitResponse;
	}
	captchaService.validateCaptcha(body.captchaToken());
	Map<String, Object> loginResponse = authService.login(body);
	return ResponseUtil.buildSuccessResponse(HttpStatus.OK, loginResponse);
    }

    @PostMapping(ResourcePathAndActionsConstants.REGISTER)
    public ResponseEntity<Map<String, Object>> register(@RequestBody RegisterUserDTO body, HttpServletRequest request) {
	rateLimiter.checkRateLimit(request);
	if (!captchaService.validateCaptcha(body.captchaToken())) {
	    throw new BadRequestException(MessageConstants.INVALID_CAPTCHA);
	}
	Map<String, Object> registerResponse = authService.register(body);
	return ResponseUtil.buildSuccessResponse(HttpStatus.CREATED, registerResponse);
    }

    @PostMapping(ResourcePathAndActionsConstants.VERIFY_OTP)
    public ResponseEntity<Map<String, Object>> verifyOtp(@RequestBody VerifyOtpDTO verifyOtpDTO,
	    HttpServletRequest request) {
	rateLimiter.checkRateLimit(request);
	String token = authService.recoverToken(request);
	String otpCode = verifyOtpDTO.otpCode();
	String cellPhone = jwtService.getCellPhoneFromToken(token);
	User user = userService.findByCellPhone(cellPhone);
	if (user == null) {
	    throw new NotFoundException(MessageConstants.USER_NOT_FOUND);
	}
	boolean isVerified = twilioService.verifyOtp(user.getCellPhone(), otpCode);
	if (isVerified) {
	    userService.activeUser(user.getId());
	    return ResponseUtil.buildSuccessResponse(HttpStatus.OK,
		    Map.of(StringConstants.MESSAGE, MessageConstants.OTP_SUCCESS));
	} else {
	    throw new BadRequestException(MessageConstants.INVALID_OTP);
	}
    }

    @PostMapping(ResourcePathAndActionsConstants.FORGOT_PASSWORD)
    public ResponseEntity<Map<String, Object>> forgotPassword(@RequestBody ForgotPasswordDTO body,
	    HttpServletRequest request) {
	rateLimiter.checkRateLimit(request);
	Map<String, Object> response = authService.forgotPassword(body);
	return ResponseUtil.buildSuccessResponse(HttpStatus.OK, response);
    }

    @PostMapping(ResourcePathAndActionsConstants.RESET_PASSWORD)
    public ResponseEntity<Map<String, Object>> resetPassword(@RequestBody ResetPasswordDTO resetPasswordDTO,
	    HttpServletRequest request) {
	rateLimiter.checkRateLimit(request);
	String cellPhone = resetPasswordDTO.cellPhone();
	String newPassword = resetPasswordDTO.newPassword();
	String otpCode = resetPasswordDTO.otpCode();
	User user = userService.findByCellPhone(cellPhone);
	if (user == null) {
	    throw new NotFoundException(MessageConstants.USER_NOT_FOUND);
	}
	boolean isOtpValid = twilioService.verifyOtp(user.getCellPhone(), otpCode);
	if (!isOtpValid) {
	    throw new BadRequestException(MessageConstants.INVALID_OTP);
	}
	authService.updatePassword(user.getId(), newPassword);
	return ResponseUtil.buildSuccessResponse(HttpStatus.OK,
		Map.of(StringConstants.MESSAGE, MessageConstants.PASSWORD_UPDATE_SUCCESS));
    }
}
