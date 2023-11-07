package com.jeongyeon.boardback.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jeongyeon.boardback.dto.request.auth.SignUpRequestDto;
import com.jeongyeon.boardback.dto.request.auth.SignUpResponseDto;
import com.jeongyeon.boardback.dto.response.ResponseDto;
import com.jeongyeon.boardback.entity.UserEntity;
import com.jeongyeon.boardback.repository.UserRepository;
import com.jeongyeon.boardback.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService{

    // 원래 아래 코드에서 final을 빼고 만들면 생성자들을 만들어줘야하는데
    // @RequiredArgsConstructor 어노테이션을 사용하고 final을 적용해주면 필요한 생성자를 알아서 만들어준다.
    private final UserRepository userRepository; 

    // 이번엔 final 안쓰고 직접 의존성 주입해줄 것이다.
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto) {
        // 유저 테이블에 데이터를 넣는 작업
        // 리포지토리를 통해 작업해야함
        // 리포지토리를 통해 email 값이 존재하는지 안하는지 확인을 할 것이다.
        // JPA의 장점인 쿼리메소드를 사용할 것이다.

        try{

            String email = dto.getEmail();
            // 만들어둔 쿼리메소드로 이메일이 중복되는지 확인하는 작업
            boolean existedEmail = userRepository.existsByEmail(email);
            if (existedEmail) return SignUpResponseDto.duplicateEmail();

            String nickname = dto.getNickname();
            boolean existedNickname = userRepository.existsByNickname(nickname);
            if (existedNickname) return SignUpResponseDto.duplicatedNickname();

            String telNumber = dto.getTelNumber();
            boolean existedTelNumber = userRepository.existsByTelNumber(telNumber);
            if (existedTelNumber) return SignUpResponseDto.duplicatedTelNumber();

            // 비밀번호 보안작업
            // JPA security
            String password = dto.getPassword();
            String encodedPassword = passwordEncoder.encode(password);
            dto.setPassword(encodedPassword);

            UserEntity userEntity = new UserEntity(dto);
            userRepository.save(userEntity);

        } catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return SignUpResponseDto.success();
    }
    
}
