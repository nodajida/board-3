package com.sparta.board12.controller;

import com.sparta.board12.dto.board.request.BoardSaveRequestDto;
import com.sparta.board12.dto.board.request.BoardUpdateRequestDto;
import com.sparta.board12.dto.board.response.BoardSaveResponseDto;
import com.sparta.board12.dto.board.response.BoardSimpleResponseDto;
import com.sparta.board12.dto.board.response.BoardUpdateResponseDto;
import com.sparta.board12.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/boards")
    public ResponseEntity<BoardSaveResponseDto> saveBoard(@RequestBody BoardSaveRequestDto boardSaveRequestDto) {
        return ResponseEntity.ok(boardService.saveBoard(boardSaveRequestDto));
    }

    @GetMapping("/boards")
    public ResponseEntity<Page<BoardSimpleResponseDto>> getBoards(
            @RequestParam(defaultValue = "1", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int size
    ) {
        return ResponseEntity.ok(boardService.getBoards(page, size));
    }

    @PutMapping("/boards/{boardId}")
    public ResponseEntity<BoardUpdateResponseDto> updateBoard(@PathVariable Long boardId, @RequestBody BoardUpdateRequestDto boardUpdateRequestDto) {
        return ResponseEntity.ok(boardService.updateBoard(boardId, boardUpdateRequestDto));
    }

    @DeleteMapping("/boards/{boardId}")
    public void deleteBoard(@PathVariable Long boardId) {
        boardService.deleteBoard(boardId);
    }
}
