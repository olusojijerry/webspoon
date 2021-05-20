package com.example.restservice.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SnippetResponseDto {
    public String url;
    public String name;
    public Date expiresat;
    public Integer likes;
    public String snippet;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpiresat() {
        return expiresat;
    }

    public void setExpiresat(Date expiresat) {
        this.expiresat = expiresat;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }
}
