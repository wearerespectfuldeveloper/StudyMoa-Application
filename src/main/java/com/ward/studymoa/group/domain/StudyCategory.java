/**
 * StudyFreeBoard.class
 * <p>
 * Copyright (c) 2019 WARD.
 */
package com.ward.studymoa.group.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 스터디 카테고리에 대한 Entity
 *
 * @since 2019. 06. 25
 * @version 1.00
 */
@Entity
@NoArgsConstructor
@Getter
public class StudyCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false, length = 30)
    private String title;
}
