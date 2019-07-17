/**
 * StudyUser.class
 *
 * Copyright (c) 2019 WARD.
 */
package com.ward.studymoa.user.domain;

import com.ward.studymoa.common.audit.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.persistence.*;

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
    private String id;

    @Column(length = 40, nullable = false, updatable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 10, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String phoneNumber;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean authStatus;

    @Column(length = 300)
    private String introTitle;

    @Column(columnDefinition = "TEXT")
    private String introDesc;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private StudyUserRoleType studyUserRoleType;
}
