package com.ssafy.enjoytrip.hotPlace.model.mapper;

import com.ssafy.enjoytrip.hotPlace.model.dto.HotPlace;
import com.ssafy.enjoytrip.hotPlace.model.dto.HotPlaceArticle;
import com.ssafy.enjoytrip.hotPlace.model.dto.HotPlaceTag;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface HotPlaceMapper {
    // select
    List<HotPlace> selectAllHotPlace();
    List<HotPlaceArticle> selectAllHotPlaceArticle(String hotPlaceId);
    HotPlace selectHotPlaceByHotPlaceId(String hotPlaceId);
    HotPlaceArticle selectHotPlaceArticleByArticleId(int articleId);
    /////

    List<HotPlaceTag> selectAllHotPlaceTag(String hotPlaceId);

    // Update
    int updateHotPlace(HotPlace hotPlace);
    int updateHotPlaceArticle(HotPlaceArticle hotPlaceArticle);
    // Insert
    int insertHotPlace(HotPlace hotPlace);
    int insertHotPlaceArticle(HotPlaceArticle hotPlaceArticle);
    int updateHotPlaceTag(String hotPlaceId, int tagId);
}
