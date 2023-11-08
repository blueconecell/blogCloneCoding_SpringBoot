package com.jeongyeon.boardback.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeongyeon.boardback.dto.request.auth.SignInRequestDto;
import com.jeongyeon.boardback.dto.request.auth.SignUpRequestDto;
import com.jeongyeon.boardback.dto.response.auth.SignInResponseDto;
import com.jeongyeon.boardback.dto.response.auth.SignUpResponseDto;
import com.jeongyeon.boardback.service.AuthService;

import lombok.RequiredArgsConstructor;

// controller에 비즈니스 로직이 적혀있으면 안됨
// 검증처리를 위한 공간
// 비즈니스로직은 서비스 로직 공간에 적음
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<? super SignUpResponseDto> signUp(
        @RequestBody @Valid SignUpRequestDto requestBody
    ){
        ResponseEntity<? super SignUpResponseDto> response = authService.signUp(requestBody);
        return response;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<? super SignInResponseDto> signIn(
        @RequestBody @Valid SignInRequestDto requestBody
    ){
        ResponseEntity<? super SignInResponseDto> response = authService.signIn(requestBody);
        return response;
    }
    
}
