package com.ssafy.enjoytrip.hotPlace.controller;

import com.ssafy.enjoytrip.hotPlace.model.dto.HotPlace;
import com.ssafy.enjoytrip.hotPlace.model.dto.HotPlaceArticle;
import com.ssafy.enjoytrip.hotPlace.service.HotPlaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://127.0.0.1:8080", "http://192.168.0.1:8080", "http://localhost:8080"})
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/hotplace")
public class HotPlaceController {
    private final HotPlaceService hotPlaceService;
    @PostMapping
    public ResponseEntity<?> addHotPlace(@RequestBody HotPlace hotPlace) {
        log.info("addHotPlace Controller");
        hotPlaceService.insertHotPlace(hotPlace);
        return ResponseEntity.ok().body("success");
    }

    @PostMapping("/article")
    public ResponseEntity<?> addHotPlaceArticle(@RequestBody HotPlaceArticle hotPlaceArticle) {
        hotPlaceService.insertHotPlaceArticle(hotPlaceArticle);
        return ResponseEntity.ok().body("success");
    }



    @GetMapping
    public void getHotPlaceList() {
    }


    @GetMapping("/{hotPlaceId}")
    public void getHotPlaceDetail(@PathVariable String hotPlaceId) {
        return;
    }

    @PostMapping("/{hotPlaceId}/vote")
    public void voteHotPlace() {

    }

    @PostMapping("/{hotPlaceId}/unvote")
    public void unvoteHotPlace() {

    }

    @GetMapping("/{hotPlaceId}/{userId}")
    public void getHotPlaceArticleList() {

    }

    @GetMapping("/{hotPlaceId}/tag")
    public void getHotPlaceTagList() {

    }

    @PostMapping("/{hotPlaceId}/tag")
    public void addHotPlaceTag() {

    }

}
