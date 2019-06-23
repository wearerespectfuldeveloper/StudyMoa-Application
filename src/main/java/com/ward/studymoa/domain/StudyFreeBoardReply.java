/**
 * StudyFreeBoardReply.class
 *
 * Copyright (c) 2019 WARD.
 */
package com.ward.studymoa.domain;

import com.ward.studymoa.domain.audit.BoardBaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * StudyUser가 작성한 잡담 글에 대한 댓글 Entity
 *
 * @author Chul Yun
 * @since 2019. 06. 23
 * @version 1.00
 */
@Entity
@NoArgsConstructor
@Getter
public class StudyFreeBoardReply extends BoardBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "board_idx", updatable = false, nullable = false)
    private StudyFreeBoard studyFreeBoard;

    @ManyToOne
    @JoinColumn(name = "user_idx", updatable = false, nullable = false)
    private StudyUser studyUser;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Override
    public void setCreatedBy() {
        this.createdBy = studyUser.getId();
    }
}
