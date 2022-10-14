package com.gemini.geminiblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gemini.geminiblog.annotation.MybatisMapper;
import com.gemini.geminiblog.model.pojo.Category;

/**
 * 字典管理-分类管理业务层接口
 * @Author zhangWj
 * @Date 2022/10/10 21:05
 **/
@MybatisMapper
public interface DictCategoryService extends IService<Category> {

    // 通过id删除
    public int delById(String id);
}
