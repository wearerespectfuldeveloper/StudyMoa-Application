/**
 * WantedBoardWriteService.class
 *
 * Copyright (c) 2019 WARD.
 */

package com.ward.studymoa.user.service;

import com.ward.studymoa.user.domain.StudyWanted;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * 스터디 구해요 서비스의 Write 인터페이스
 *
 * @since 2019. 08. 12
 * @version 1.00
 */
public interface WantedBoardService {

    Optional<StudyWanted> getBoard(Long idx);

    StudyWanted boardWrite(StudyWanted studyWanted);

    StudyWanted boardUpdate(StudyWanted studyWanted);

    void boardDelete(Long idx);

    List<StudyWanted> getDownScrollBoardList(Long idx, Sort sort);
}
