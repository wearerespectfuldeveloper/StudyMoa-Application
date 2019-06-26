/**
 * StudyGroup.class
 *
 * Copyright (c) 2019 WARD.
 */
package com.ward.studymoa.domain;

import com.ward.studymoa.common.audit.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 스터디 그룹 Entity
 *
 * @since 2019. 06. 23
 * @version 1.00
 */
@Entity
@NoArgsConstructor
@Getter
public class StudyGroup extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "category_idx", nullable = false, updatable = false)
    private StudyCategory studyCategory;

    @Column(length = 300)
    private String studyTitle;

    @Column(columnDefinition = "TEXT")
    private String studyDesc;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean visibility;

    @Column(nullable = false)
    private Integer capacity;
}
