package com.ssafy.enjoytrip.board.model.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Comment {
    private int commentId;
    private int boardId;
    private String userId;
    private String content;
    private String currentUpdate;
}
