/**
 * StudyMember.class
 *
 * Copyright (c) 2019 WARD.
 */
package com.ward.studymoa.domain;

import com.ward.studymoa.domain.audit.BaseEntity;
import com.ward.studymoa.domain.state.StudyMemberRoleType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 스터디 그룹에 속한 멤버 Entity
 *
 * @author Chul Yun
 * @since 2019. 06. 23
 * @version 1.00
 */
@Entity
@NoArgsConstructor
@Getter
public class StudyMember extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_idx", updatable = false, nullable = false)
    private StudyUser studyUser;

    @ManyToOne
    @JoinColumn(name = "group_idx", updatable = false, nullable = false)
    private StudyGroup studyGroup;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, columnDefinition = "CHAR(10)")
    private StudyMemberRoleType studyMemberRoleType;
}
