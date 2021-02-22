package com.huazhao.controller;

import com.huazhao.exception.AppException;
import com.huazhao.model.User;
import com.huazhao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2021-01-14
 * Time : 9:40
 */
@RestController

@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Object login(User user, HttpServletRequest req){
        //user是浏览器页面属于的账号密码，现根据账号从数据库差用户；
        //数据库密码校验
        //exist是根据数据库查询的user的对象
        User exist = userService.query(user.getUsername());
        if(exist != null){
            if(exist.getPassword().equals(user.getPassword())){ //校验密码
                //校验成功:设置session
                HttpSession session = req.getSession(true);//获取session，获取不到就创建一个
                session.setAttribute("user",exist);
                return null;
            }else{
                throw new AppException("userLog001","用户名或者密码错误");
            }
        }else {
            throw new AppException("userLog002","用户不存在");
        }

    }
    @GetMapping("/logout")
    public Object logout(HttpSession session){
        session.removeAttribute("user");
        return null;
    }
}
