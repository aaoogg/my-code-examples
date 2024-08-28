package com.project.project.dto.auth;

public record ForgotPasswordDTO(String cellPhone, String captchaToken) {
}