package com.webspoon.assignment.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SnippetResponseDto {
    public String url;
    public String name;
    public Date expires_at;
    public String snippet;
}

