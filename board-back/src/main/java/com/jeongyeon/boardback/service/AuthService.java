package com.jeongyeon.boardback.service;

import org.springframework.http.ResponseEntity;

import com.jeongyeon.boardback.dto.request.auth.SignUpRequestDto;
import com.jeongyeon.boardback.dto.request.auth.SignUpResponseDto;

public interface AuthService {
    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);    
}
