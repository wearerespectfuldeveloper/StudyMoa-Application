/**
 * StudyMinutes.class
 *
 * Copyright (c) 2019 WARD.
 */
package com.ward.studymoa.group.domain;

import com.ward.studymoa.common.audit.AuthorBaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 스터디 그룹의 스터디 진행 기록 Entity
 *
 * @since 2019. 06. 23
 * @version 1.00
 */
@Entity
@NoArgsConstructor
@Getter
public class StudyMinutes extends AuthorBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_idx", nullable = false, updatable = false)
    private StudyMember studyMember;

    @Column(length = 300, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
}
