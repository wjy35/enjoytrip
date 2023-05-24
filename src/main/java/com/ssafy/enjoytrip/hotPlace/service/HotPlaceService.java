package com.ssafy.enjoytrip.hotPlace.service;

import com.ssafy.enjoytrip.hotPlace.model.dto.HotPlace;
import com.ssafy.enjoytrip.hotPlace.model.dto.HotPlaceArticle;
import com.ssafy.enjoytrip.hotPlace.model.dto.HotPlaceTag;
import com.ssafy.enjoytrip.hotPlace.model.dto.TagType;

import java.util.List;

public interface HotPlaceService {

    // select
    public List<HotPlace> selectAllHotPlace();
    public List<HotPlaceArticle> selectAllHotPlaceArticle(String hotPlaceId);

    public HotPlace selectHotPlaceByHotPlaceId(String hotPlaceId) ;

    public HotPlaceArticle selectHotPlaceArticleByArticleId(int hotPlaceId);

    int updateHotPlaceArticleImage(int hotPlaceArticleId, String imageUrl);


    /////
    public List<HotPlaceTag> selectAllHotPlaceTag(String hotPlaceId);
    // update
    public int updateTag(String hotPlaceId, List<TagType> tagType);
    // insert
    public int insertHotPlace(HotPlace hotPlace);
    public int insertHotPlaceArticle(HotPlaceArticle hotPlaceArticle);

}
