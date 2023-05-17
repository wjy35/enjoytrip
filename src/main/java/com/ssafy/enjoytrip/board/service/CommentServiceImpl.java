package com.ssafy.enjoytrip.board.service;

import com.ssafy.enjoytrip.board.model.dto.Comment;
import com.ssafy.enjoytrip.board.model.dto.CommentRequestDto;
import com.ssafy.enjoytrip.board.model.dto.CommentResponseDto;
import com.ssafy.enjoytrip.board.model.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;

    @Override
    public Comment detail(int commentId) {
        return null;
    }

    @Override
    public int regist(CommentRequestDto commentRequestDto, String userId, int boardId) {
        return 0;
    }

    @Override
    public int modify(int commentId, CommentRequestDto commentRequestDto) {
        return 0;
    }

    @Override
    public int delete(int commentId) {
        return 0;
    }

    @Override
    public List<CommentResponseDto> getCommentList(int boardId) {
        return null;
    }
}
