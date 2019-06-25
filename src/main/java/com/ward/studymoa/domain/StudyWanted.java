/**
 * StudyWanted.class
 *
 * Copyright (c) 2019 WARD.
 */
package com.ward.studymoa.domain;

import com.ward.studymoa.domain.audit.AuthorBaseEntity;
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

    @ManyToOne
    @JoinColumn(name = "user_idx", updatable = false, nullable = false)
    private StudyUser studyUser;

    @Column(nullable = false, length = 300)
    private String wandtedTitle;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String wandtedDesc;

    @Override
    public void setCreatedBy() {
        this.createdBy = studyUser.getId();
    }
}
