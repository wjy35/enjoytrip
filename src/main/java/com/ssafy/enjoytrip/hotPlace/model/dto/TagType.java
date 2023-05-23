package com.ssafy.enjoytrip.hotPlace.model.dto;

public enum TagType {
    ATMOSPHERE("분위기좋은", 1), DELICIOUS("맛있는",2);
    String type;
    int id;

    TagType(String type, int id) {
        this.type = type;
        this.id = id;
    }

    public String getType() {
        return type;
    }
    public int getId() {
        return id;
    }
}
