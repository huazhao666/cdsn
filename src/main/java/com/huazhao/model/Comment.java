package com.huazhao.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2021-01-09
 * Time : 10:50
 */
@Setter
@Getter
@ToString
public class Comment {

    private Integer id;
    private String content;
    private Integer commenter;//评论者
    private Integer articleId;//文章id；
    private Date createTime;//评论时间
}
