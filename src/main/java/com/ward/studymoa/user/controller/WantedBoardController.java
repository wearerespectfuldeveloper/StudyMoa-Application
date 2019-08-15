/**
 * WantedBoardDto.class
 * <p>
 * Copyright (c) 2019 WARD.
 */
package com.ward.studymoa.user.controller;

import com.ward.studymoa.user.dto.request.WantedBoardRequestDto;
import com.ward.studymoa.user.dto.response.WantedBoardDetailDto;
import com.ward.studymoa.user.service.WantedBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 스터디 구해요 게시판 api
 *
 * @since 2019. 08. 15
 * @version 1.0.0
 */
@RestController
@RequestMapping("/wanted")
@RequiredArgsConstructor
public class WantedBoardController {

    private final WantedBoardService wantedBoardService;

    @GetMapping("/{idx}")
    public ResponseEntity<WantedBoardDetailDto> readWantedBoard(@PathVariable Long idx) {
        WantedBoardDetailDto responseDto = wantedBoardService.getBoard(idx);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WantedBoardDetailDto> writeWantedBoard(
            @RequestBody WantedBoardRequestDto requestDto) {
        WantedBoardDetailDto responseDto = wantedBoardService.boardWrite(requestDto);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
