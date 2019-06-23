/**
 * StudyGroupBoardReply.class
 * <p>
 * Copyright (c) 2019 WARD.
 */
package com.ward.studymoa.domain;


import com.ward.studymoa.domain.audit.AuthorBaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 스터디 그룹 게시판의 댓글에 대한 Entity
 *
 * @author Chul Yun
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

    @ManyToOne
    @JoinColumn(name = "board_idx", nullable = false, updatable = false)
    private StudyGroupBoard studyGroupBoard;

    @ManyToOne
    @JoinColumn(name = "member_idx", nullable = false, updatable = false)
    private StudyMember studyMember;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Override
    public void setCreatedBy() {
        this.createdBy = studyMember.getStudyUser().getId();
    }
}
