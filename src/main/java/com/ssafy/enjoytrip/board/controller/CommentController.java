package com.ssafy.enjoytrip.board.controller;

import com.ssafy.enjoytrip.board.model.dto.Comment;
import com.ssafy.enjoytrip.board.model.dto.CommentRequestDto;
import com.ssafy.enjoytrip.board.model.dto.CommentResponseDto;
import com.ssafy.enjoytrip.board.service.CommentService;
import com.ssafy.enjoytrip.util.ApiUtil;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ssafy.enjoytrip.util.ApiUtil.success;
import static com.ssafy.enjoytrip.util.ApiUtil.ApiResult;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/{boardId}")
    public ApiResult<List<CommentResponseDto>> getCommentList(@PathVariable int boardId)
    {
        List<CommentResponseDto> commentList = commentService.getCommentList(boardId);
        return success(commentList);
    }

    @PostMapping("/{boardId}")
    public  ApiResult<Boolean>  registerComment(@PathVariable int boardId, @RequestBody CommentRequestDto commentRequestDto, String userId )
    {
        // default
        String userId2= "ssafy";
        commentService.regist(commentRequestDto, userId2, boardId);
        return success(true);
    }

    @PutMapping("/{commentId}")
    public ApiResult<Boolean> modifyComment(@PathVariable int commentId, @RequestBody CommentRequestDto commentRequestDto)
    {
        commentService.modify(commentId, commentRequestDto);
        return success(true);
    }

    @DeleteMapping("/{boardId}/{commentId}")
    public ApiResult<Boolean> deleteComment(@PathVariable int commentId)
    {
        commentService.delete(commentId);
        return success(true);
    }
}
