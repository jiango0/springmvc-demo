package com.test;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

public class TestMain17 {

    public static void main(String[] args) {
        String comment = "   ";
        System.out.println(StringUtils.isNotEmpty(comment));
        Assert.hasText(comment, "评论内容不能为空");
    }

}
