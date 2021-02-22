package com.huazhao.controller;

import com.huazhao.model.Article;
import com.huazhao.model.User;
import com.huazhao.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    //显示所有文章格式，还需要用户信息
    @GetMapping("/query")
    public Object query(HttpServletRequest req){
        User user = null;
        //获取session对象,未登录返回null；
        HttpSession session = req.getSession(false);
        if(session != null){
            User get = (User) session.getAttribute("user");
            if(get != null){
                user = get;
            }
        }
        List<Article> list = articleService.queryAll();
        //返回的数据是map保存，用户信息如果登录就存user=用户信息；
        Map<String,Object> map = new HashMap<>();
        map.put("user",user);
        map.put("articles", list);
        return map;

    }
    @GetMapping("/queryByUser")
    public Object queryByUser(HttpSession session){
        //数据库通过登录用户id查询对应的文章
        User user = (User) session.getAttribute("user");
        List<Article> list = articleService.queryByUser(user.getId());
        return list;
    }
    @GetMapping("/query/{id}")
    public Object queryById(@PathVariable Integer id){ // 绑定变量id；
        //数据库根据文章id查询文章信息
        Article article = articleService.queryById(id);
        return article;

    }
    @GetMapping("/update")
    public Object updateById(@PathVariable Integer id){
        int i  = articleService.updateById(id);
        return i;
    }
    @GetMapping("/delete")
    public Object deleteById(@PathVariable Integer id){
        int i = articleService.deleteById(id);
        return i;
    }
}
