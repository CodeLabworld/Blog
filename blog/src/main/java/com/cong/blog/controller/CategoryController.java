package com.cong.blog.controller;


import com.cong.Utils.JsonUtil;
import com.cong.blog.pojo.Category;
import com.cong.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author qiu
 * @since 2021-06-01
 */

@CrossOrigin
@RestController

public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 返回分类列表
     *
     * @return
     */
    @RequestMapping("/api/category")
    @CrossOrigin
    public String getCategoryList() {
        List<Category> list = categoryService.list(null);
        return JsonUtil.getJson(list);
    }
}

