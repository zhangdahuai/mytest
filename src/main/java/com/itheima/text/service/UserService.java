package com.itheima.text.service;

import com.itheima.text.dao.UserDao;
import com.itheima.text.domain.User;
import com.itheima.text.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    public User login(User loginUser) throws IOException {
        SqlSession session = SqlSessionFactoryUtils.openSqlSession();
        UserDao userDao = session.getMapper(UserDao.class);
        User user = userDao.login(loginUser);

        //加登录效果权限

        SqlSessionFactoryUtils.commitAndClose(session);
        return user;
    }
}
