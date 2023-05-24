package com.ssafy.enjoytrip.hotPlace.controller;

import com.ssafy.enjoytrip.board.service.FileService;
import com.ssafy.enjoytrip.hotPlace.model.dto.HotPlace;
import com.ssafy.enjoytrip.hotPlace.model.dto.HotPlaceArticle;
import com.ssafy.enjoytrip.hotPlace.service.HotPlaceService;
import static com.ssafy.enjoytrip.util.ApiUtil.ApiResult;
import static com.ssafy.enjoytrip.util.ApiUtil.success;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@CrossOrigin(origins = {"http://127.0.0.1:8080", "http://192.168.0.1:8080", "http://localhost:8080"})
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/hotplace")
public class HotPlaceController {
    private final HotPlaceService hotPlaceService;
    private final FileService fileService;

    @GetMapping
    public ResponseEntity<List<HotPlace>> getHotPlaceList() {
        List<HotPlace> hotPlaces = hotPlaceService.selectAllHotPlace();
        return ResponseEntity.ok().body(hotPlaces);
    }

    // hot place id 로 article 여러개 가져오기
    @GetMapping("/articleAll/{hotPlaceId}")
    public ResponseEntity<List<HotPlaceArticle>> getHotPlaceArticleList(@PathVariable String hotPlaceId) {
        List<HotPlaceArticle> hotPlaceArticles = hotPlaceService.selectAllHotPlaceArticle(hotPlaceId);
        return ResponseEntity.ok().body(hotPlaceArticles);
    }

    // hot place id 로 하나 가져오기 이거는hotplace 가져오는 것임
    @GetMapping("/{hotPlaceId}")
    public ApiResult<HotPlace> getHotPlaceDetail(@PathVariable String hotPlaceId) {
        HotPlace hotPlace = hotPlaceService.selectHotPlaceByHotPlaceId(hotPlaceId);
        return success(hotPlace);
    }

    // article 하나만
    @GetMapping("/article/{hotPlaceArticleId}")
    public ResponseEntity<?> getHotPlaceArticleList(@PathVariable int hotPlaceArticleId) {
        HotPlaceArticle hotPlaceArticle = hotPlaceService.selectHotPlaceArticleByArticleId(hotPlaceArticleId);
        return ResponseEntity.ok().body(hotPlaceArticle);
    }





    ///////////
    @GetMapping("/{hotPlaceId}/tag")
    public void getHotPlaceTagList() {

    }

    @PostMapping("/{hotPlaceId}/vote")
    public void voteHotPlace() {

    }

    @PostMapping("/{hotPlaceId}/unvote")
    public void unvoteHotPlace() {

    }



    @PostMapping("/{hotPlaceId}/tag")
    public void addHotPlaceTag() {

    }


    ///////////////////////////////
    @PostMapping
    public ApiResult<Integer> addHotPlace(@RequestBody HotPlace hotPlace) {
        log.info("addHotPlace Controller");
        int pk = hotPlaceService.insertHotPlace(hotPlace);
        return success(pk);
    }

    @PostMapping("/article")
    public ApiResult<Integer> addHotPlaceArticle(@RequestBody HotPlaceArticle hotPlaceArticle) {
        int pk = hotPlaceService.insertHotPlaceArticle(hotPlaceArticle);
        return success(pk);
    }

    @PostMapping("/article/{articleId}/flleUpload")
    public ApiResult<Boolean> uploadImagetoArticle(@PathVariable int articleId,@ModelAttribute List<MultipartFile> files) {
        log.info("uploadImagetoArticle Controller",articleId, files);
        fileService.insertFile(articleId,files, "hotplace/");
        return success(true);
    }


}
