package com.xwc.teach.commons;

import com.xwc.teach.index.entity.User;
import lombok.Data;

@Data
public class Result {
    // 成功：1，失败：0
    private Integer code;
    private Object msg;
}
