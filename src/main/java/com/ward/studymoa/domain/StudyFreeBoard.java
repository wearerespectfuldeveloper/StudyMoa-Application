/**
 * StudyFreeBoard.class
 * <p>
 * Copyright (c) 2019 WARD.
 */
package com.ward.studymoa.domain;

import com.ward.studymoa.domain.audit.BoardBaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * StudyUser가 작성한 잡담 글에 대한 Entity
 *
 * @author Chul Yun
 * @since 2019. 06. 23
 * @version 1.00
 */
@Entity
@NoArgsConstructor
@Getter
public class StudyFreeBoard extends BoardBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "user_idx", nullable = false, updatable = false)
    private StudyUser studyUser;

    @Column(length = 300, nullable = false)
    private String freeBoardTitle;

    @Column(columnDefinition = "TEXT")
    private String freeBoardDesc;

    @Override
    public void setCreatedBy() {
        this.createdBy = studyUser.getId();
    }
}
