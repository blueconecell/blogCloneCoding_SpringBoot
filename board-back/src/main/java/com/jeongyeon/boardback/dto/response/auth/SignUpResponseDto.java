package com.jeongyeon.boardback.dto.response.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jeongyeon.boardback.common.ResponseCode;
import com.jeongyeon.boardback.common.ResponseMessage;
import com.jeongyeon.boardback.dto.response.ResponseDto;

import lombok.Getter;

@Getter
public class SignUpResponseDto extends ResponseDto{

    private SignUpResponseDto(){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }

    // 이렇게 만들어주는 이유는 DTO만 보고 무엇을 반환하는지 알기 위해서이다.
    public static ResponseEntity<SignUpResponseDto> success(){
        SignUpResponseDto result = new SignUpResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // 반환형태 만들어줄 것이다. 
    // 1. 중복된 이메일의 경우
    public static ResponseEntity<ResponseDto> duplicateEmail(){
        ResponseDto result = new ResponseDto(ResponseCode.DUPLICATED_EMAIL, ResponseMessage.DUPLICATED_EMAIL);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    // 2. 중복된 닉네임의 경우
    public static ResponseEntity<ResponseDto> duplicatedNickname(){
        ResponseDto result = new ResponseDto(ResponseCode.DUPLICATED_NICKNAME, ResponseMessage.DUPLICATED_NICKNAME);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    // 3. 중복된 전화번호의 경우
    public static ResponseEntity<ResponseDto> duplicatedTelNumber(){
        ResponseDto result = new ResponseDto(ResponseCode.DUPLICATED_TEL_NUMBER, ResponseMessage.DUPLICATED_TEL_NUMBER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
    // 이렇게 만들게 되면 백엔드에서 DTO를 만들어주게 된 것이다. 이제 프론트를 만들어야한다.
    // 프론트 apis에 만들기시작
}
