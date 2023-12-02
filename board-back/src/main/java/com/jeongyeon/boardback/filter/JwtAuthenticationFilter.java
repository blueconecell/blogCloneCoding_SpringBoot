package com.jeongyeon.boardback.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.jeongyeon.boardback.provider.JwtProvider;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor //Lombok에서 받아온 필수 생성자 만들어주기 (final 도움)
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    
    private final JwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String token = parseBearerToken(request);

        // 인증실패
        if(token==null){
            filterChain.doFilter(request, response);
            return;
        }

        String email = jwtProvider.validate(token);
        // 인증실패
        if(email==null){
            filterChain.doFilter(request, response);
            return;
        }

        AbstractAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, null, AuthorityUtils.NO_AUTHORITIES);
        //웹인증 세부정보 소스를 통해 detail을 만들어줌
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        // context에 등록하기
        SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
        securityContext.setAuthentication(authenticationToken);

        SecurityContextHolder.setContext(securityContext);
            
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        filterChain.doFilter(request, response);

    }

    private String parseBearerToken(HttpServletRequest request){
        String authorizaion = request.getHeader("Authorization");

        // org.springframework 것을 import
        // hastext null이거나 비어있으면 false를 반환하도록함
        boolean hasAuthorization = StringUtils.hasText(authorizaion);
        if (!hasAuthorization) return null;

        boolean isBearer = authorizaion.startsWith("Bearer");
        if(!isBearer) return null;

        // idx 7부터 토큰이다.(8번째)
        String token = authorizaion.substring(7);
        return token;


    }

}
