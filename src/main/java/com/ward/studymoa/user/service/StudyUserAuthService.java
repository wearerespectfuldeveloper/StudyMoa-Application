package com.ward.studymoa.user.service;

import com.ward.studymoa.common.config.JwtProvider;
import com.ward.studymoa.common.config.StudyMoaAuthenticationProvider;
import com.ward.studymoa.common.exception.AuthenticationException;
import com.ward.studymoa.user.domain.StudyUser;
import com.ward.studymoa.user.repository.StudyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StudyUserAuthService {

    private final StudyUserRepository studyUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final StudyMoaAuthenticationProvider studyMoaAuthenticationProvider;

    @Transactional
    public String signUp(StudyUser studyUser) throws RuntimeException {
        if (studyUserRepository.existsByUserId(studyUser.getUserId())) {
            throw new RuntimeException("중복된 아이디입니다.");
        }

        if (studyUserRepository.existsByEmail(studyUser.getEmail())) {
            throw new RuntimeException("중복된 이메일입니다.");
        }

        studyUser.setEncodingPassword(passwordEncoder);
        studyUserRepository.save(studyUser);
        return jwtProvider.generateJwtToken(studyUser.getUserId(), studyUser.getStudyUserRoleType());
    }

    @Transactional
    public String signIn(String userId, String password) {
        try {
            studyMoaAuthenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(userId, password));
            return jwtProvider.generateJwtToken(userId, studyUserRepository.findByUserId(userId).getStudyUserRoleType());
        } catch (org.springframework.security.core.AuthenticationException e) {
            throw new AuthenticationException("UserId or password is wrong.", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
