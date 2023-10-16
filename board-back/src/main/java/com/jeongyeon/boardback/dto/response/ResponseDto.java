package com.jeongyeon.boardback.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jeongyeon.boardback.common.ResponseCode;
import com.jeongyeon.boardback.common.ResponseMessage;

import lombok.AllArgsConstructor;
import lombok.Getter;

//dto 만들때마다 이거 상속받아서 사용할 것이다. db에러는 어디에서나 발생하기 때문이다.
@Getter
@AllArgsConstructor
public class ResponseDto {
    private String code;
    private String message;

    public static ResponseEntity<ResponseDto> databaseError(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.DATABASE_ERROR, ResponseMessage.DATABASE_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }
}
