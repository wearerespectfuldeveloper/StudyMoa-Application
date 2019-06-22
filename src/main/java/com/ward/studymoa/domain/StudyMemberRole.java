/**
 * StudyMemberRole.class
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
 * 스터디 그룹의 멤버가 부여받은 Role Entity
 *
 * @author Chul Yun
 * @since 2019. 06. 22
 * @version 1.00
 */
@Entity
@NoArgsConstructor
@Getter
public class StudyMemberRole extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "member_idx", nullable = false, updatable = false)
    private StudyMember studyMember;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, columnDefinition = "CHAR(10)")
    private StudyMemberRoleType studyMemberRoleType;
}
