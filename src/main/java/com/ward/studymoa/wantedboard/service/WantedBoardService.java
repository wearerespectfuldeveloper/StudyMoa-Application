/**
 * WantedBoardWriteService.class
 *
 * Copyright (c) 2019 WARD.
 */

package com.ward.studymoa.wantedboard.service;

import com.ward.studymoa.wantedboard.domain.StudyWanted;
import com.ward.studymoa.wantedboard.dto.request.WantedBoardRequestDto;
import com.ward.studymoa.wantedboard.dto.response.WantedBoardDetailDto;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * 스터디 구해요 서비스의 Write 인터페이스
 *
 * @since 2019. 08. 12
 * @version 1.00
 */
public interface WantedBoardService {

    WantedBoardDetailDto getBoard(Long idx);

    WantedBoardDetailDto boardWrite(WantedBoardRequestDto requestDto);

    WantedBoardDetailDto boardUpdate(Long idx, WantedBoardRequestDto requestDto);

    void boardDelete(Long idx);

    List<StudyWanted> getDownScrollBoardList(Long idx, Sort sort);
}
