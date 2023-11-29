package com.gemini.geminiblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gemini.geminiblog.Dao.DictCategoryDao;
import com.gemini.geminiblog.Dao.UserDao;
import com.gemini.geminiblog.model.pojo.Category;
import com.gemini.geminiblog.model.pojo.User;
import com.gemini.geminiblog.service.DictCategoryService;
import com.gemini.geminiblog.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户管理业务实现曾
 * @author zhangwj
 * @Date 2022/10/19 16:51
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

}
