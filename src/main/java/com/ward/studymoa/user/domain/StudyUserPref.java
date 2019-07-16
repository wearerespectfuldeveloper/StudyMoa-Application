/**
 * StudyUser.class
 *
 * Copyright (c) 2019 WARD.
 */
package com.ward.studymoa.user.domain;

import com.ward.studymoa.common.audit.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 스터디모아 회원의 관심사 Entity
 *
 * @since 2019. 06. 22
 * @version 1.00
 */
@Entity
@NoArgsConstructor
@Getter
public class StudyUserPref extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "user_idx", nullable = false, updatable = false)
    private StudyUser studyUser;

    @Column(length = 100, nullable = false)
    private String topic;
}
