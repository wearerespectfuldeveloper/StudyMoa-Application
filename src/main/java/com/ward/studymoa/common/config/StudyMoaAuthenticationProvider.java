package com.ward.studymoa.common.config;

import com.ward.studymoa.user.service.impl.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudyMoaAuthenticationProvider implements AuthenticationProvider {

    private final UserDetailsServiceImpl userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userId = authentication.getName();
        String password = (String) authentication.getCredentials();

        UserDetails userDetails = null;

        try {
            userDetails = userDetailsService.loadUserByUsername(userId);

            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("비밀 번호가 일치하지 않습니다.");
            }

        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            throw new UsernameNotFoundException(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        return new UsernamePasswordAuthenticationToken(userId, password, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
