package com.ssafy.enjoytrip.board.service;

import com.ssafy.enjoytrip.board.model.dto.Comment;
import com.ssafy.enjoytrip.board.model.dto.CommentRequestDto;
import com.ssafy.enjoytrip.board.model.dto.CommentResponseDto;
import com.ssafy.enjoytrip.board.model.mapper.BoardMapper;
import com.ssafy.enjoytrip.board.model.mapper.CommentMapper;
import com.ssafy.enjoytrip.error.BoardNotFoundException;
import com.ssafy.enjoytrip.error.CommentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;
    private final BoardMapper boardMapper;
    // userMapper 도 추가하여야 함
    @Override
    public Comment detail(int commentId) {
        Comment comment = commentMapper.selectComment(commentId).orElseThrow(()->new CommentNotFoundException("해당 commentId에 해당하는 comment가 없습니다."));
        return comment;
    }

    @Override
    public int regist(CommentRequestDto commentRequestDto, String userId, int boardId) {
        boardMapper.selectBoard(boardId).orElseThrow(()->new BoardNotFoundException("해당 boardId에 해당하는 board가 없습니다."));
        return commentMapper.insertComment(new Comment(commentRequestDto, userId, boardId));
    }

    @Override
    public int modify(int commentId, CommentRequestDto commentRequestDto) {
        boardMapper.selectBoard(commentId).orElseThrow(()->new BoardNotFoundException("해당 boardId에 해당하는 board가 없습니다."));
        return commentMapper.updateComment(commentRequestDto.toEntity());
    }

    @Override
    public int delete(int commentId) {
        return commentMapper.deleteComment(commentId);
    }

    @Override
    public List<CommentResponseDto> getCommentList(int boardId) {
        boardMapper.selectBoard(boardId).orElseThrow(()->new BoardNotFoundException("해당 boardId에 해당하는 board가 없습니다."));
        // comment list 를 commentResponseDto 로 변경 stream
        return commentMapper.selectAll(boardId).stream().map(CommentResponseDto::new).collect(Collectors.toList());
    }
}
