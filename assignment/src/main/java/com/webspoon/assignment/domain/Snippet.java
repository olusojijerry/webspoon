package com.webspoon.assignment.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Snippet {
    public String id;
    public String name;
    public Date expiresIn;
    public String snippet;
    public Date createdDt;
}
