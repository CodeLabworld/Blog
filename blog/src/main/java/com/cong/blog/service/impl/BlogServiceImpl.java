package com.cong.blog.service.impl;

import com.cong.blog.pojo.Blog;
import com.cong.blog.mapper.BlogMapper;
import com.cong.blog.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qiu
 * @since 2021-06-02
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
