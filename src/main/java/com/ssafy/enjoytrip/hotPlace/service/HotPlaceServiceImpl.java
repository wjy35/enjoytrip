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
public class HotPlaceServiceImpl implements HotPlaceService {
    private final HotPlaceMapper hotPlaceMapper;

    @Override
    public List<HotPlace> selectAllHotPlace() {
        return hotPlaceMapper.selectAllHotPlace();
    }

    @Override
    public List<HotPlaceArticle> selectAllHotPlaceArticle(String hotPlaceId) {
        return hotPlaceMapper.selectAllHotPlaceArticle(hotPlaceId);
    }

    @Override
    public HotPlace selectHotPlaceByHotPlaceId(String hotPlaceId) {
        return hotPlaceMapper.selectHotPlaceByHotPlaceId(hotPlaceId);
    }

    @Override
    public HotPlaceArticle selectHotPlaceArticleByArticleId(int hotPlaceArticleId) {
        return hotPlaceMapper.selectHotPlaceArticleByArticleId(hotPlaceArticleId);
    }

    @Override
    public int updateHotPlaceArticleImage(int hotPlaceArticleId, String imageUrl) {
        return hotPlaceMapper.updateHotPlaceArticleImage(hotPlaceArticleId, imageUrl);
    }


    //////
    @Override
    public List<HotPlaceTag> selectAllHotPlaceTag(String hotPlaceId) {
        return hotPlaceMapper.selectAllHotPlaceTag(hotPlaceId);
    }

    @Override
    public int updateTag(String hotPlaceId, List<TagType> tagType) {
        for (int i = 0; i < tagType.size(); i++) {
            hotPlaceMapper.updateHotPlaceTag(hotPlaceId, tagType.get(i).getId());
        }
        return 0;
    }

    @Override
    public int insertHotPlace(HotPlace hotPlace) {
        return hotPlaceMapper.insertHotPlace(hotPlace);
    }

    @Override
    public int insertHotPlaceArticle(HotPlaceArticle hotPlaceArticle) {
        hotPlaceMapper.insertHotPlaceArticle(hotPlaceArticle);
        return hotPlaceArticle.getHotPlaceArticleId();
    }


}
