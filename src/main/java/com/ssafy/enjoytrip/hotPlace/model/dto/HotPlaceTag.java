package com.ssafy.enjoytrip.hotPlace.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HotPlaceTag {
    private int hotPlaceTagId;
    private String hotPlaceId;
    private String tagName;
    private int count;
}
