package com.gemini.geminiblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gemini.geminiblog.Dao.DictCategoryDao;
import com.gemini.geminiblog.model.pojo.Category;
import com.gemini.geminiblog.service.DictCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 字典管理-分类管理业务实现曾
 * @author zhangwj
 * @date 2022/10/10 21:10
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DictCategoryServiceImpl extends ServiceImpl<DictCategoryDao, Category> implements DictCategoryService {

    private final DictCategoryDao dictCategoryDao;

    public DictCategoryServiceImpl(DictCategoryDao dictCategoryDao) {
        this.dictCategoryDao = dictCategoryDao;
    }

    /**
     * 通过id删除
     * @Author zhangWj
     * @Date 2022/10/13 10:40
     **/
    @Override
    public int delById(String id) {
        int num = dictCategoryDao.delById(id);
        return num;
    }
}
