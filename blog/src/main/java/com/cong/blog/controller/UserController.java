package com.cong.blog.controller;


import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cong.Utils.JsonUtil;
import com.cong.Utils.JwtUtil;
import com.cong.Utils.Result;
import com.cong.blog.pojo.User;
import com.cong.blog.service.UserService;
import com.cong.blog.vo.voUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author qiu
 * @since 2021-05-24
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/api/login")
    public String login(@RequestBody voUser vouser) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", vouser.getUsername());
        User user = userService.getOne(wrapper);
        if (user.getPassword().equals(vouser.getPassword())) {
            HashMap<String, Object> map = new HashMap<>();
            HashMap<String, Object> map_ = new HashMap<>();
            map.put("nickname", vouser.getUsername());
            String token = JwtUtil.creatToken(map);
            map_.put("Authorization", token);
            return JsonUtil.getJson(Result.create(200, "登录成功", map_));
        } else {
            return JsonUtil.getJson(Result.create(404, "用户名或密码错误"));
        }
    }

    @GetMapping("/user/info")
    public String getUserInfo(@Param("token") String token) {
        String username = null;
        try {
            DecodedJWT decodedJWT = JwtUtil.verify(token);
            username = decodedJWT.getClaim("username").asString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        User user = userService.getOne(wrapper);

        HashMap<String, Object> map = new HashMap<>();
        map.put("name", user.getNickname());
        String[] roles = user.getRole().split(",");
        map.put("roles", roles);
        map.put("avatar", user.getAcatar());
        map.put("introduction", "i an iron man");
        Result res = Result.create(20000, "success", map);
        return JsonUtil.getJson(res);
    }

}

