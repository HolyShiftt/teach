package com.xwc.teach.index.entity;

import lombok.Data;

@Data
public class Notice {
    private Integer id;
    private String title;
    private String content;
    private String createTime;
}
