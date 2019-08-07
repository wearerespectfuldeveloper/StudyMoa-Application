/**
 * StudyUser.class
 *
 * Copyright (c) 2019 WARD.
 */
package com.ward.studymoa.user.domain;

import com.ward.studymoa.common.audit.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 스터디모아 서비스에 가입한 회원 Entity
 *
 * @since 2019. 06. 22
 * @version 1.00
 */
@Entity
@NoArgsConstructor
@Getter
public class StudyUser extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(length = 20, nullable = false, updatable = false)
    private String userId;

    @Column(length = 40, nullable = false, updatable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 10, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String phoneNumber;

    @Column(length = 300)
    private String introTitle;

    @Column(columnDefinition = "TEXT")
    private String introDesc;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private StudyUserRoleType studyUserRoleType = StudyUserRoleType.ROLE_NON_AUTH_USER;

    @Builder
    public StudyUser(String userId, String email, String password, String name, String phoneNumber, String introTitle, String introDesc) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.introTitle = introTitle;
        this.introDesc = introDesc;
    }

    public void setEncodingPassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
    }
}
