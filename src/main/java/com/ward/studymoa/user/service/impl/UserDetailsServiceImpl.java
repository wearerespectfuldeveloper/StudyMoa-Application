package com.ward.studymoa.user.service.impl;

import com.ward.studymoa.user.domain.StudyUser;
import com.ward.studymoa.user.repository.StudyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private StudyUserRepository studyUserRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        final StudyUser studyUser = studyUserRepository.findByUserId(userId)
                .orElseThrow(() -> new UsernameNotFoundException("StudyUser '" + userId + "' not found"));

        return User.withUsername(userId)
                .password(studyUser.getPassword())
                .authorities(studyUser.getStudyUserRoleType().toString())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
