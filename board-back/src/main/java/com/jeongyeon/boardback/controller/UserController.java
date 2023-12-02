package com.jeongyeon.boardback.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jeongyeon.boardback.service.UserService;

import lombok.RequiredArgsConstructor;

import com.jeongyeon.boardback.dto.response.user.GetSignInUserResponseDto;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService UserService;

    @GetMapping("")
    public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(
        // JWT 인증 필터에서 유저정보에 이메일을 담아놨었는데
        // 여기에서 이메일을 꺼내올 수 있는 어노테이션이다
        @AuthenticationPrincipal String email
    ){
        ResponseEntity<? super GetSignInUserResponseDto> response = UserService.getSignInUser(email);
        return response;
    }
}
