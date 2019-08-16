/**
 * StudyWanted.class
 *
 * Copyright (c) 2019 WARD.
 */
package com.ward.studymoa.wantedboard.domain;

import com.ward.studymoa.common.audit.AuthorBaseEntity;
import com.ward.studymoa.user.domain.StudyUser;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * StudyUser가 스터디를 구하는 글에 대한 Entity
 *
 * @since 2019. 06. 23
 * @version 1.00
 */
@Entity
@NoArgsConstructor
@Getter
public class StudyWanted extends AuthorBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx", updatable = false, nullable = false)
    private StudyUser studyUser;

    @Column(nullable = false, length = 300)
    private String wantedTitle;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String wantedDesc;

    @Builder
    public StudyWanted(Long idx, StudyUser studyUser, String wantedTitle, String wantedDesc) {
        this.idx = idx;
        this.studyUser = studyUser;
        this.wantedTitle = wantedTitle;
        this.wantedDesc = wantedDesc;
    }
}
