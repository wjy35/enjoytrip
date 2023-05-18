package com.ssafy.enjoytrip.board.controller;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssafy.enjoytrip.board.model.dto.Board;
import com.ssafy.enjoytrip.board.model.dto.BoardRequestDto;
import com.ssafy.enjoytrip.board.model.dto.BoardResponseDto;
import com.ssafy.enjoytrip.board.model.dto.PageInfoDto;
import com.ssafy.enjoytrip.board.service.BoardService;
import com.ssafy.enjoytrip.util.PageNavigationForPageHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

import static com.ssafy.enjoytrip.util.ApiUtil.ApiResult;
import static com.ssafy.enjoytrip.util.ApiUtil.success;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardRestController {

    private final BoardService boardService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getList(PageInfoDto pageInfoDto, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        if (pageInfoDto.getPage() == 0) {
            pageInfoDto = new PageInfoDto(1,10);
        }
        log.info("pageInfoDto : {}", pageInfoDto);
        PageHelper.startPage(pageInfoDto.getPage(), pageInfoDto.getPageSize());
        Page<Board> boards = boardService.getBoardList();
        String path = request.getContextPath() + "/board/list?page";
        PageNavigationForPageHelper helper = new PageNavigationForPageHelper(boards, path);
        map.put("boards", helper);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }


    @GetMapping("/{boardId}")
    public ApiResult<BoardResponseDto> getBoard(@PathVariable("boardId") int boardId) {

        System.out.println("getBoard");
        log.info("boardId : {}",boardId );
        return success(new BoardResponseDto(boardService.detail(boardId)));
    }

    @PostMapping
    public ApiResult<Boolean> registerBoard(@RequestBody @Valid BoardRequestDto boardRequestDto, HttpSession session) {
        log.info("boardRequestDto : {}", boardRequestDto);
       // User userInfo = Optional.of((User) session.getAttribute("userInfo")).orElseThrow(() -> new UserNotFoundException("로그인이 필요합니다."));

       // boardService.regist(boardRequestDto, userInfo.getUserId());
        boardService.regist(boardRequestDto, "ssafy");
        return success(true);
    }

    @PutMapping("/{boardId}")
    public ApiResult<Boolean> modifyBoard(@PathVariable int boardId, @RequestBody @Valid BoardRequestDto boardRequestDto) {
        log.info("boardId : {}", boardId);
        log.info("boardRequestDto : {}", boardRequestDto);
        log.info("update board");
        boardService.modify(boardId, boardRequestDto);
        return success(true);
    }

    @DeleteMapping("/{boardId}")
    public ApiResult<Boolean> deleteBoard(@PathVariable int boardId) {
        Map<String, Object> map = new HashMap<>();
        boardService.delete(boardId);
        return success(true);
    }

    @PostMapping("/hit/{boardId}")
    public ApiResult<Boolean> updateHit(@PathVariable int boardId) {
        boardService.updateHit(boardId);
        return success(true);
    }


}
