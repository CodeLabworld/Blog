package com.cong.blog.service.impl;

import com.cong.blog.pojo.User;
import com.cong.blog.mapper.UserMapper;
import com.cong.blog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qiu
 * @since 2021-05-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
