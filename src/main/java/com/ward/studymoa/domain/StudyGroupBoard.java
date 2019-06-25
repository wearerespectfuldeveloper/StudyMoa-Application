/**
 * StudyGroupBoard.class
 *
 * Copyright (c) 2019 WARD.
 */
package com.ward.studymoa.domain;

import com.ward.studymoa.domain.audit.AuthorBaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 스터디 그룹 게시판 Entity
 *
 * @since 2019. 06. 23
 * @version 1.00
 */
@Entity
@NoArgsConstructor
@Getter
public class StudyGroupBoard extends AuthorBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "group_idx", nullable = false, updatable = false)
    private StudyGroup studyGroup;

    @ManyToOne
    @JoinColumn(name = "member_idx", nullable = false, updatable = false)
    private StudyMember studyMember;

    @Column(length = 300, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Override
    public void setCreatedBy() {
        this.createdBy = studyMember.getStudyUser().getId();
    }
}
