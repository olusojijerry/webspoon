package com.example.restservice.dto;

import lombok.Data;

@Data
public class LikesDto {
    public String Id;
    public String snippet;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }
}
