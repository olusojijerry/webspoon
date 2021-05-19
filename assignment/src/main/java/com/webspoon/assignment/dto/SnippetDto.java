package com.webspoon.assignment.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SnippetDto {
    public String name;
    public Date expiresIn;
    public String snippet;
}
