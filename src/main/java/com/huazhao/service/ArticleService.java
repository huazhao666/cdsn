package com.huazhao.service;

import com.huazhao.mapper.ArticleMapper;
import com.huazhao.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2021-01-28
 * Time : 10:13
 */

//为啥可以调用接口的方法？
// 因为Mybatis集成在SpringBoot项目中，引入依赖包，可以加载配置类并执行 代理类
//org.springframework.boot.autoconfigure.EnableAutoConfiguration=\ 这里自动加载配置类；
@Service
public class ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    public List<Article> queryAll() {
        return articleMapper.selectAll();
    }

    public List<Article> queryByUser(Integer id) {

        return articleMapper.selectByUser(id);
    }

    public Article queryById(Integer id) {

        return articleMapper.selectByPrimaryKey(id);
    }

    public int updateById(Integer id) {
        return articleMapper.updateByPrimaryKey(id);
    }

    public int deleteById(Integer id) {
        return articleMapper.deleteByPrimaryKey(id);
    }
}
