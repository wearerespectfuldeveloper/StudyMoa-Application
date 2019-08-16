package com.ward.studymoa.user.service.impl;

import com.ward.studymoa.user.domain.StudyUser;
import com.ward.studymoa.user.repository.StudyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final StudyUserRepository studyUserRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        StudyUser studyUser = studyUserRepository.findByUserId(userId);

        if (studyUser == null) {
            throw new UsernameNotFoundException("StudyUser '" + userId + "' not found");
        }

        return studyUser;
    }
}
