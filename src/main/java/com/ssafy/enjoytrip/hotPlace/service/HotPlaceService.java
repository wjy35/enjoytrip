package com.ssafy.enjoytrip.hotPlace.service;

import com.ssafy.enjoytrip.hotPlace.model.dto.HotPlace;
import com.ssafy.enjoytrip.hotPlace.model.dto.HotPlaceArticle;
import com.ssafy.enjoytrip.hotPlace.model.dto.HotPlaceTag;
import com.ssafy.enjoytrip.hotPlace.model.dto.TagType;

import java.util.List;

public interface HotPlaceService {

    // select implmentation
    public HotPlace selectHotPlaceById(String hotPlaceId) ;
    public List<HotPlace> selectAllHotPlace();
    public List<HotPlaceArticle> selectHotPlaceArticleById(String hotPlaceId);

    public List<HotPlaceArticle> selectAllHotPlaceArticle(String hotPlaceId);
    public HotPlaceArticle selectHotPlaceArticleByUserIdAndHotPlaceId(String userId, String hotPlaceId);
    public List<HotPlaceTag> selectAllHotPlaceTag(String hotPlaceId);

    // update
    public int updateTag(String hotPlaceId, List<TagType> tagType);


    // insert
    public int insertHotPlace(HotPlace hotPlace);
    public int insertHotPlaceArticle(HotPlaceArticle hotPlaceArticle);

}
