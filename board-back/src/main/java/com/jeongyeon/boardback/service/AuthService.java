package com.jeongyeon.boardback.service;

import org.springframework.http.ResponseEntity;

import com.jeongyeon.boardback.dto.request.auth.SignInRequestDto;
import com.jeongyeon.boardback.dto.request.auth.SignUpRequestDto;
import com.jeongyeon.boardback.dto.response.auth.SignInResponseDto;
import com.jeongyeon.boardback.dto.response.auth.SignUpResponseDto;

public interface AuthService {
    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);
    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
}
