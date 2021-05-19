package com.webspoon.assignment.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SnippetDto {
    public String name;
    public Date expiresIn;
    public String snippet;

    public Date getExpiresIn() {
        return expiresIn;
    }

    public String getSnippet() {
        return snippet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExpiresIn(Date expiresIn) {
        this.expiresIn = expiresIn;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }


}
