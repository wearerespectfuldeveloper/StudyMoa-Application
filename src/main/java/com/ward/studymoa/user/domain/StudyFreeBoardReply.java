/**
 * StudyFreeBoardReply.class
 *
 * Copyright (c) 2019 WARD.
 */
package com.ward.studymoa.user.domain;

import com.ward.studymoa.common.audit.AuthorBaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * StudyUser가 작성한 잡담 글에 대한 댓글 Entity
 *
 * @since 2019. 06. 23
 * @version 1.00
 */
@Entity
@NoArgsConstructor
@Getter
public class StudyFreeBoardReply extends AuthorBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_idx", updatable = false, nullable = false)
    private StudyFreeBoard studyFreeBoard;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx", updatable = false, nullable = false)
    private StudyUser studyUser;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;
}
