package com.sparta.board12.dto.board.request;

import lombok.Getter;

@Getter
public class BoardSaveRequestDto {

    private String title;
    private String contents;
    private String username;
}
