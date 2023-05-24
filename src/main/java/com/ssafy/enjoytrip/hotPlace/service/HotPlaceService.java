package com.ssafy.enjoytrip.hotPlace.service;

import com.ssafy.enjoytrip.hotPlace.model.dto.HotPlace;
import com.ssafy.enjoytrip.hotPlace.model.dto.HotPlaceArticle;
import com.ssafy.enjoytrip.hotPlace.model.dto.HotPlaceTag;

import java.util.List;

public interface HotPlaceService {

    // select
    public List<HotPlace> selectAllHotPlace();
    public List<HotPlaceArticle> selectAllHotPlaceArticle(String hotPlaceId);

    public HotPlace selectHotPlaceByHotPlaceId(String hotPlaceId) ;

    public HotPlaceArticle selectHotPlaceArticleByArticleId(int hotPlaceId);

    int updateHotPlaceArticleImage(int hotPlaceArticleId, String imageUrl);

    int increaseHitHotPlaceCount(String hotPlaceId);
    int decreaseHitHotPlaceCount(String hotPlaceId);

    public int insertHotPlace(HotPlace hotPlace);
    public int insertHotPlaceArticle(HotPlaceArticle hotPlaceArticle);

    public int updateHotPlaceTag(String hotPlaceId, String tagId);

    public void updateHotPlaceTagList(String hotPlaceId, List<String> tagIdList);
    public int insertHotPlaceTag(String hotPlaceId, String tagName);
    public void insertHotPlaceTagList(String hotPlaceId, List<String> tagIdList);
    /////
    public List<HotPlaceTag> selectAllHotPlaceTag(String hotPlaceId);


    List<HotPlaceTag> selectHotPlaceTagList(String hotPlaceId);
}
