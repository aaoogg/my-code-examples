package com.project.project.dto.auth;

import com.project.project.dto.address.AddressDTO;
import com.project.project.dto.user.UserDTO;

public record RegisterUserDTO(UserDTO user, AddressDTO address, String captchaToken) {
    
}