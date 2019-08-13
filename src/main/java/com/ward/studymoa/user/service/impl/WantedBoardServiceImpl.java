/**
 * WantedBoardInsertService.class
 *
 * Copyright (c) 2019 WARD.
 */

package com.ward.studymoa.user.service.impl;

import com.ward.studymoa.user.domain.StudyWanted;
import com.ward.studymoa.user.repository.StudyWantedRepository;
import com.ward.studymoa.user.service.WantedBoardService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 스터디 구해요 서비스의 insert 서비스
 *
 * @since 2019. 08. 12
 * @version 1.00
 */
@Service
public class WantedBoardServiceImpl implements WantedBoardService {

    private StudyWantedRepository studyWantedRepository;

    @Override
    public Optional<StudyWanted> getBoard(Long idx) {
        return studyWantedRepository.findById(idx);
    }

    @Override
    public StudyWanted boardWrite(StudyWanted studyWanted) {
        return studyWantedRepository.save(studyWanted);
    }

    @Override
    public StudyWanted boardUpdate(StudyWanted studyWanted) {
        return studyWantedRepository.save(studyWanted);
    }

    @Override
    public void boardDelete(Long idx) {
        studyWantedRepository.deleteById(idx);
    }

    @Override
    public List<StudyWanted> getDownScrollBoardList(Long idx, Sort sort) {
        //TODO Infinity scroll function...
        return null;
    }
}
