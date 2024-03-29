/**
 * StudyMember.class
 *
 * Copyright (c) 2019 WARD.
 */
package com.ward.studymoa.group.domain;

import com.ward.studymoa.common.audit.BaseEntity;
import com.ward.studymoa.user.domain.StudyUser;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 스터디 그룹에 속한 멤버 Entity
 *
 * @since 2019. 06. 23
 * @version 1.00
 */
@Entity
@NoArgsConstructor
@Getter
public class StudyMember extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx", updatable = false, nullable = false)
    private StudyUser studyUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_idx", updatable = false, nullable = false)
    private StudyGroup studyGroup;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private StudyMemberRoleType studyMemberRoleType = StudyMemberRoleType.MEMBER;
}
