package com.huazhao.mapper;

import com.huazhao.base.BaseMapper;
import com.huazhao.model.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//dao层
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    List<Article> selectAll();

    List<Article> selectByUser(Integer id);
}