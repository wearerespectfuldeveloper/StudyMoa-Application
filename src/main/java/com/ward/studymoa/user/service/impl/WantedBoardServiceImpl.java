/**
 * WantedBoardInsertService.class
 * <p>
 * Copyright (c) 2019 WARD.
 */

package com.ward.studymoa.user.service.impl;

import com.ward.studymoa.user.domain.StudyUser;
import com.ward.studymoa.user.domain.StudyWanted;
import com.ward.studymoa.user.dto.request.WantedBoardRequestDto;
import com.ward.studymoa.user.dto.response.WantedBoardDetailDto;
import com.ward.studymoa.user.repository.StudyWantedRepository;
import com.ward.studymoa.user.service.WantedBoardService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 스터디 구해요 서비스의 insert 서비스
 *
 * @version 1.00
 * @since 2019. 08. 12
 */
@Service
@RequiredArgsConstructor
public class WantedBoardServiceImpl implements WantedBoardService {

    private final StudyWantedRepository studyWantedRepository;
    private final ModelMapper modelMapper;

    @Override
    public WantedBoardDetailDto getBoard(Long idx) {
        StudyWanted resultModel = studyWantedRepository.findById(idx)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물 번호입니다."));

        return modelMapper.map(resultModel, WantedBoardDetailDto.class);
    }

    @Override
    public WantedBoardDetailDto boardWrite(WantedBoardRequestDto requestDto) {
        StudyUser studyUser = StudyUser.builder()
                .idx(requestDto.getStudyUserIdx()).build();

        StudyWanted studyWanted = StudyWanted.builder()
                .idx(requestDto.getIdx())
                .studyUser(studyUser)
                .wantedTitle(requestDto.getWantedTitle())
                .wantedDesc(requestDto.getWantedDesc())
                .build();

        studyWantedRepository.save(studyWanted);
        return modelMapper.map(studyWanted, WantedBoardDetailDto.class);
    }

    @Override
    public WantedBoardDetailDto boardUpdate(WantedBoardRequestDto requestDto) {
        //TODO updateBoard..
        return null;
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
