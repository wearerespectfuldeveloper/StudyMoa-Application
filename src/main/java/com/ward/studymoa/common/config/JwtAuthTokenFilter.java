package com.ward.studymoa.common.config;

import com.ward.studymoa.common.exception.JwtTokenFilteringException;
import com.ward.studymoa.user.domain.StudyUser;
import com.ward.studymoa.user.service.StudyUserAuthService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthTokenFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthTokenFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = jwtProvider.resolveToken(httpServletRequest);
            if (jwt != null && jwtProvider.validateJwtToken(jwt)) {
                String userId = jwtProvider.getUserIdFromJwtToken(jwt);

                Authentication auth = jwtProvider.getAuthentication(jwt);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (JwtTokenFilteringException e) {
            SecurityContextHolder.clearContext();
            httpServletResponse.sendError(e.getHttpStatus().value(), e.getMessage());
            return;
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
