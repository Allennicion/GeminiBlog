package com.gemini.geminiblog.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gemini.geminiblog.annotation.MybatisMapper;
import com.gemini.geminiblog.model.pojo.User;

/**
 * 用户管理DAO层接口
 * @Author zhangWj
 * @Date 2022/10/19 16:51
 **/
@MybatisMapper
public interface UserDao extends BaseMapper<User> {


}
