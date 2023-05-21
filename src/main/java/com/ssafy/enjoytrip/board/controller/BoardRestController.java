package com.ssafy.enjoytrip.board.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssafy.enjoytrip.board.model.dto.*;
import com.ssafy.enjoytrip.board.service.BoardService;
import com.ssafy.enjoytrip.board.service.FileService;
import com.ssafy.enjoytrip.util.FileUtil;
import com.ssafy.enjoytrip.util.PageNavigationForPageHelper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ssafy.enjoytrip.util.ApiUtil.ApiResult;
import static com.ssafy.enjoytrip.util.ApiUtil.success;

@Slf4j
@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = {"http://127.0.0.1:8080","http://192.168.0.1:8080","http://localhost:8080"})
@RequestMapping("/board")
public class BoardRestController {

    private final BoardService boardService;
    private final FileService fileService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getList(PageInfoDto pageInfoDto, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        if (pageInfoDto.getPage() == 0) {
            pageInfoDto = new PageInfoDto(1, 10);
        }
        log.info("pageInfoDto : {}", pageInfoDto);
        PageHelper.startPage(pageInfoDto.getPage(), pageInfoDto.getPageSize());
        Page<Board> boards = boardService.getBoardList();
        String path = request.getContextPath() + "/board/list?page";
        PageNavigationForPageHelper helper = new PageNavigationForPageHelper(boards, path);
        map.put("boards", helper);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }


    @GetMapping("/list/{currentPage}")
    public ResponseEntity<Map<String, Object>> getListByPage(@PathVariable int currentPage, @RequestParam(required = false) Integer pageSize, HttpServletRequest request) {
        log.info("page By currentPage : {}", currentPage);
        Map<String, Object> map = new HashMap<>();
        if (pageSize == null) {
            pageSize = 10;
        }
        PageHelper.startPage(currentPage, pageSize);
        Page<Board> boards = boardService.getBoardList();
        String path = request.getContextPath() + "/board/list?page";
        PageNavigationForPageHelper helper = new PageNavigationForPageHelper(boards, path);
        map.put("boards", helper);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/{boardId}")
    public ApiResult<BoardResponseDto> getBoard(@PathVariable("boardId") int boardId) {

        System.out.println("getBoard");
        log.info("boardId : {}", boardId);

        return success(new BoardResponseDto(boardService.detail(boardId)));
    }

    public ApiResult<Boolean> registerBoard(@RequestParam @Valid BoardRequestDto boardRequestDto, List<MultipartFile> files) throws IOException {
        log.info("boardRequestDto : {}", boardRequestDto);
        boardService.regist(boardRequestDto, boardRequestDto.getUserId());
        log.info(boardRequestDto.getBoardId() + "번 게시글에 파일 업로드");
        List<FileInfo> list = FileUtil.storeFiles(files);
        fileService.insertFile(boardRequestDto.getBoardId(), list);
        return success(true);
    }

    @PostMapping("/test")
    public ApiResult<Boolean> registerBoard2(@RequestParam @Valid String json, List<MultipartFile> files) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        log.info("json : {}", json);
        BoardRequestDto boardRequestDto = objectMapper.readValue(json, BoardRequestDto.class);
        log.info("boardRequestDto : {}", boardRequestDto);
        int pk = boardService.regist(boardRequestDto, boardRequestDto.getUserId());
        log.info(pk + "번 게시글에 파일 업로드");
        List<FileInfo> list = FileUtil.storeFiles(files);
        fileService.insertFile(pk, list);
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
        boardService.delete(boardId);
        return success(true);
    }

    @PostMapping("/hit/{boardId}")
    public ApiResult<Boolean> updateHit(@PathVariable int boardId) {
        boardService.updateHit(boardId);
        return success(true);
    }

    @PostMapping("/fileUploadTest")
    public void fileUploadTest(MultipartFile file) throws IOException {
        log.info("file : {}", file);
        FileInfo fileInfo = FileUtil.storeFile(file);
        log.info("uploadFile : {}", fileInfo);
    }


    @PostMapping(value = "/multiFileUploadTest", consumes = {"multipart/form-data"})
    public ResponseEntity<?> fileUploadTest(List<MultipartFile> files) throws IOException {
        log.info("files : {}", files);
        List<FileInfo> list = FileUtil.storeFiles(files);
        log.info("uploadFile : {}", list);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/file/{boardId}")
    public ResponseEntity<List<FileInfo>> getFileList(@PathVariable int boardId) {
        List<FileInfo> list = fileService.selectFile(boardId);
        return ResponseEntity.ok(list);
    }
}
