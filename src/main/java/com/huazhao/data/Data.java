package com.huazhao.data;

import com.huazhao.model.Article;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2021-01-09
 * Time : 11:58
 */
public class Data {
    public static List<Article> allArticles(){
        List<Article> list = new ArrayList<>();
        Article a1 = new Article();
        a1.setId(1);
        a1.setTitle("文章一");
        a1.setContent("内容一");
        Article a2 = new Article();
        a2.setId(2);
        a2.setTitle("文章二");
        a2.setContent("内容二");
        Article a3 = new Article();
        a3.setId(3);
        a3.setTitle("文章三");
        a3.setContent("内容三");
        list.add(a1);
        list.add(a2);
        list.add(a3);
        return list;
    }
    public static List<Article> userArticles(){
        List<Article> list = new ArrayList<>();
        Article a1 = new Article();
        a1.setId(1);
        a1.setTitle("文章一");
        a1.setContent("内容一");
        Article a2 = new Article();
        a2.setId(2);
        a2.setTitle("文章二");
        a2.setContent("内容二");
        Article a3 = new Article();
        a3.setId(3);
        a3.setTitle("文章三");
        a3.setContent("内容三");
        list.add(a1);
        list.add(a2);
        list.add(a3);
        return list;
    }
}
