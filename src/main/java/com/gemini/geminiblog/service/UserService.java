package com.gemini.geminiblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gemini.geminiblog.annotation.MybatisMapper;
import com.gemini.geminiblog.model.pojo.Category;
import com.gemini.geminiblog.model.pojo.User;

/**
 * 用户管理业务层接口
 * @Author zhangWj
 * @Date 2022/10/19 16:51
 **/
@MybatisMapper
public interface UserService extends IService<User> {


}
