package com.jeongyeon.boardback.service;

import org.springframework.http.ResponseEntity;

import com.jeongyeon.boardback.dto.response.user.GetSignInUserResponseDto;

public interface UserService {
    
    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String emailString);
    
}
