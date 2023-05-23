package com.ssafy.enjoytrip.hotPlace.service;
import com.ssafy.enjoytrip.hotPlace.model.dto.HotPlace;
import com.ssafy.enjoytrip.hotPlace.model.dto.HotPlaceArticle;
import com.ssafy.enjoytrip.hotPlace.model.dto.HotPlaceTag;
import com.ssafy.enjoytrip.hotPlace.model.dto.TagType;
import com.ssafy.enjoytrip.hotPlace.model.mapper.HotPlaceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class HotPlaceServiceImpl implements HotPlaceService{
    private final HotPlaceMapper hotPlaceMapper;

    @Override
    public HotPlace selectHotPlaceById(String hotPlaceId) {
        return hotPlaceMapper.selectHotPlaceById(hotPlaceId);
    }

    @Override
    public List<HotPlace> selectAllHotPlace() {
        return hotPlaceMapper.selectAllHotPlace();
    }

    @Override
    public List<HotPlaceArticle> selectAllHotPlaceArticle(String hotPlaceId) {
        return hotPlaceMapper.selectAllHotPlaceArticle(hotPlaceId);
    }

    @Override
    public HotPlaceArticle selectHotPlaceArticleByUserIdAndHotPlaceId(String userId, String hotPlaceId) {
        return hotPlaceMapper.selectHotPlaceArticleByUserIdAndHotPlaceId(userId, hotPlaceId);
    }

    @Override
    public List<HotPlaceTag> selectAllHotPlaceTag(String hotPlaceId) {
        return hotPlaceMapper.selectAllHotPlaceTag(hotPlaceId);
    }

    @Override
    public int updateTag(String hotPlaceId, List<TagType> tagType) {
        for (int i = 0 ; i< tagType.size(); i++) {
            hotPlaceMapper.updateHotPlaceTag(hotPlaceId, tagType.get(i).getId());
        }
        return 0;
    }


    // insert
    @Override
    public int insertHotPlace(HotPlace hotPlace) {
        return hotPlaceMapper.insertHotPlace(hotPlace);
    }

    @Override
    public int insertHotPlaceArticle(HotPlaceArticle hotPlaceArticle) {
        return hotPlaceMapper.insertHotPlaceArticle(hotPlaceArticle);
    }


}
