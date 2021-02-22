package com.huazhao.service;

import com.huazhao.mapper.UserMapper;
import com.huazhao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2021-01-28
 * Time : 10:13
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User query(String username) {
        return userMapper.query(username);
    }
}
