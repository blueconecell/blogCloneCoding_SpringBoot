package com.jeongyeon.boardback.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.OverridesAttribute;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jeongyeon.boardback.filter.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configurable
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    protected SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            //cors정책 : 리소스 쉐어링이다. 다른 도메인에서 실행하는 script를 차단하는게 보통인데 우리는 3000번 port에서 돌아가는 script도 받아써야하기 때문에 정책을 만들어줘야함
            .cors().and()

            //공격자가 사용자의 의지와 상관없이 공격하는 해킹
            .csrf().disable()
            //켜놓은 채로 들어가면 로그인창이 뜰 것이다.
            .httpBasic().disable()
            //세션기반의 인증 하지 않을 것이다.
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            //request에 대한 인증. 
            .authorizeRequests()
            //어떤 매칭에 따라 적용되는 것. 인증을 거치지 않아도 되는 요청에 대한정책 -> 허용한다.
            .antMatchers("/", "/api/v1/auth/**","/api/v1/search/**","/file/**").permitAll()
            .antMatchers(HttpMethod.GET, "/api/v1/board/**","/api/v1/user/*").permitAll()
            //아무 요청에서 대해서 인증을 거치게 한다. 그리고 아래에서 만든 인증 실패 만들어준 것을 and()뒤에 적용시켜준다.
            .anyRequest().authenticated().and()
            .exceptionHandling().authenticationEntryPoint(new FailedAuthenticationEntryPoint());
        httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }
}

//"인증 실패 했을 때" 만들어주기
class FailedAuthenticationEntryPoint implements AuthenticationEntryPoint{

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {
        
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("{\"code\":\"AF\",\"message\":\"Authorization Failed\"}");

    }

}