package com.gemini.geminiblog.controllers.backstage;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gemini.geminiblog.controllers.BaseController;
import com.gemini.geminiblog.model.json.LayuiTable;
import com.gemini.geminiblog.model.json.ResultBeanObj;
import com.gemini.geminiblog.model.pojo.Category;
import com.gemini.geminiblog.service.DictCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 字典管理
 * @author zhangwj
 * @date 2022/10/10 21:01
 */
@Controller
@RequestMapping("/backstage/dict")
public class DictController extends BaseController {

    private final DictCategoryService dictCategoryService;

    public DictController(DictCategoryService dictCategoryService) {
        this.dictCategoryService = dictCategoryService;
    }

    /**
     * 分类管理列表页面
     * @Author zhangWj
     * @Date 2022/10/13 7:34
     **/
    @GetMapping("/category")
    public String cateGoryIndex() {
        return "/backstage/dict/category";
    }

    /**
     * 分类管理列表
     * @Author zhangWj
     * @Date 2022/10/13 7:34
     **/
    @GetMapping("/categoryList")
    @ResponseBody
    public LayuiTable<Category> categoryList(Page<Category> page, String sort, String order, String name) {
        addPageOrder(page, sort, order);

        /* 可能需要
        QueryWrapper<Category> queryWrapper = new QueryWrapper<Category>();
        queryWrapper.eq("is_del", 0);
        queryWrapper.like(StrUtil.isNotEmpty(name), "name", name);
        queryWrapper.orderByAsc("update_time");
        IPage<Category> categoryPage = new Page<>(page.getCurrent(), page.getSize());
        categoryPage = dictCategoryService.page(categoryPage, queryWrapper);*/

        IPage<Category> categoryPage = dictCategoryService.page(page, Wrappers.<Category>query()
                .eq("is_del", 0)
                .like(StrUtil.isNotEmpty(name), "name", name));

        return new LayuiTable<>(categoryPage.getTotal(), categoryPage.getRecords());
    }

    /**
     * 分类管理表单页面
     * @Author zhangWj
     * @Date 2022/10/13 7:34
     **/
    @GetMapping("/categoryForm")
    public String categoryForm(Model model, String id) {
        Category category = new Category();
        if(StrUtil.isNotEmpty(id)) {
            category = dictCategoryService.getById(id);
        }
        model.addAttribute("category", category);
        return "/backstage/dict/categoryForm";
    }

    /**
     * 分类管理表单页面
     * @Author zhangWj
     * @Date 2022/10/13 7:34
     **/
    @PostMapping("/categoryFormSub")
    @ResponseBody
    public ResultBeanObj categoryFormSub(String id, String name) {
        Boolean bool = false;
        Date date = new Date();

        if (StrUtil.isNotEmpty(name)) {
            if (StrUtil.isNotEmpty(id)) {
                // 修改
                UpdateWrapper<Category> updateWrapper = new UpdateWrapper<>();
                updateWrapper.eq("id",id).set("name", name).set("update_time", date).set("update_name","admin2");
                bool = dictCategoryService.update(null, updateWrapper);
            } else {
                // 新增
                Category category = new Category();
                category.setName(name);
                category.setCreateName("admin");
                category.setCreateTime(date);
                category.setUpdateName("admin");
                category.setUpdateTime(date);
                bool = dictCategoryService.save(category);
            }
        }
        if(bool) {
            return ResultBeanObj.ok();
        } else {
            return ResultBeanObj.error("错误!");
        }
    }

    /**
     * 分类管理数据批量删除
     * @Author zhangWj
     * @Date 2022/10/13 7:35
     **/
    @PostMapping("/categoryFormDel")
    @ResponseBody
    public ResultBeanObj categoryFormDel(@RequestBody List<Category> categories) {
        Boolean bool = false;

        if(categories != null && categories.size() > 0) {
            UpdateWrapper<Category> updateWrapper = null;
            for (Category category : categories) {
                updateWrapper = new UpdateWrapper<>();
                updateWrapper.eq("id",category.getId()).set("is_del", 1);
                bool = dictCategoryService.update(null, updateWrapper);
            }
        }
        if(bool) {
            return ResultBeanObj.ok();
        } else {
            return ResultBeanObj.error("错误!");
        }
    }

    /**
     * 分类管理数据删除
     * @Author zhangWj
     * @Date 2022/10/13 7:35
     **/
    @PostMapping("/categoryFormDelById")
    @ResponseBody
    public ResultBeanObj categoryFormDelById(String id) {
        int num = 0;

        if(StrUtil.isNotEmpty(id)) {
            num = dictCategoryService.delById(id);
        }
        if(num > 0) {
            return ResultBeanObj.ok();
        } else {
            return ResultBeanObj.error("错误!");
        }
    }
}
