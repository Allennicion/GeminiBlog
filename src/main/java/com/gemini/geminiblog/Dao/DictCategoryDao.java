package com.gemini.geminiblog.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gemini.geminiblog.annotation.MybatisMapper;
import com.gemini.geminiblog.model.pojo.Category;

/**
 * 字典管理-分类管理DAO层接口
 * @Author zhangWj
 * @Date 2022/10/10 21:13
 **/
@MybatisMapper
public interface DictCategoryDao extends BaseMapper<Category> {

    // 通过id删除
    public int delById(String id);
}
