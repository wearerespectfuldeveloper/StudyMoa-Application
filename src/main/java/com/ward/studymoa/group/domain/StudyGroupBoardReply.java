/**
 * StudyGroupBoardReply.class
 * <p>
 * Copyright (c) 2019 WARD.
 */
package com.ward.studymoa.group.domain;


import com.ward.studymoa.common.audit.AuthorBaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 스터디 그룹 게시판의 댓글에 대한 Entity
 *
 * @since 2019. 06. 23
 * @version 1.00
 */
@Entity
@NoArgsConstructor
@Getter
public class StudyGroupBoardReply extends AuthorBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_idx", nullable = false, updatable = false)
    private StudyGroupBoard studyGroupBoard;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_idx", nullable = false, updatable = false)
    private StudyMember studyMember;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Override
    public void setCreatedBy() {
        this.createdBy = studyMember.getStudyUser().getUserId();
    }
}
