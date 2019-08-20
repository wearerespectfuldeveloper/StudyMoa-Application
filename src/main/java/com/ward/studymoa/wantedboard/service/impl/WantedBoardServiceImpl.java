/**
 * WantedBoardInsertService.class
 * <p>
 * Copyright (c) 2019 WARD.
 */

package com.ward.studymoa.wantedboard.service.impl;

import com.ward.studymoa.user.domain.StudyUser;
import com.ward.studymoa.wantedboard.domain.StudyWanted;
import com.ward.studymoa.wantedboard.dto.request.WantedBoardRequestDto;
import com.ward.studymoa.wantedboard.dto.response.WantedBoardDetailDto;
import com.ward.studymoa.wantedboard.repository.StudyWantedRepository;
import com.ward.studymoa.wantedboard.service.WantedBoardService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(readOnly = true)
    public WantedBoardDetailDto getBoard(Long idx) {
        StudyWanted resultModel = studyWantedRepository.findById(idx)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물 번호입니다."));

        return modelMapper.map(resultModel, WantedBoardDetailDto.class);
    }

    @Override
    @Transactional
    public WantedBoardDetailDto boardWrite(WantedBoardRequestDto requestDto) {
        StudyUser studyUser = (StudyUser) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();

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
    @Transactional
    public WantedBoardDetailDto boardUpdate(WantedBoardRequestDto requestDto) {
        StudyWanted studyWanted = studyWantedRepository.findById(requestDto.getIdx())
                .orElseThrow(() -> new IllegalArgumentException("board id is invalid."));

        studyWanted.modifyContent(requestDto.getWantedTitle(), requestDto.getWantedDesc());
        studyWantedRepository.save(studyWanted);
        return modelMapper.map(studyWanted, WantedBoardDetailDto.class);
    }

    @Override
    @Transactional
    public void boardDelete(Long idx) {
        studyWantedRepository.deleteById(idx);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudyWanted> getDownScrollBoardList(Long idx, Sort sort) {
        //TODO Infinity scroll function...
        return null;
    }
}
