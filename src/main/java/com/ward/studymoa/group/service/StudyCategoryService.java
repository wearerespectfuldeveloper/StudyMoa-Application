/**
 * StudyWantedReply.class
 *
 * Copyright (c) 2019 WARD.
 */
package com.ward.studymoa.group.service;

import com.ward.studymoa.group.domain.StudyCategory;
import com.ward.studymoa.group.repository.StudyCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 스터디 그룹 카테고리 서비스
 *
 * @since 2019. 06. 26
 * @version 1.00
 */
@Service
@RequiredArgsConstructor
public class StudyCategoryService {

    private final StudyCategoryRepository studyCategoryRepository;

    @Transactional
    public List<StudyCategory> findAllOrderByCreatedDate() {
        return studyCategoryRepository.findAll(Sort.by(Sort.Direction.ASC, "createdDate"));
    }
}
