package com.cong.blog.service.impl;

import com.cong.blog.pojo.Category;
import com.cong.blog.mapper.CategoryMapper;
import com.cong.blog.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qiu
 * @since 2021-06-01
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
