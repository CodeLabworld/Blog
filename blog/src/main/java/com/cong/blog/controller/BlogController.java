package com.cong.blog.controller;


import com.cong.Utils.JsonUtil;
import com.cong.Utils.Result;
import com.cong.blog.pojo.Blog;
import com.cong.blog.service.BlogService;
import com.cong.blog.vo.voArtical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author qiu
 * @since 2021-06-02
 */
@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;

    @PostMapping("/api/writeArtical")
    public String writeArtical(@RequestBody voArtical voartical) throws ParseException {
        Blog blog = new Blog();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        blog.setTitle(voartical.getTitle())
                .setFirstPicture(voartical.getImgurl())
                .setContent(voartical.getContent())
                .setDescription(voartical.getTextarea())
                .setIsPublished((voartical.getIspublished().equals("1")))
                .setIsCommentEnable(voartical.getIscommentenable().equals("1"))
                .setCategory(voartical.getCategoryid())
                .setDescription(voartical.getTextarea())
                .setIsTop(voartical.getIstop().equals("1"))
                .setName(voartical.getName())
                .setCreateTime(sdf.parse(voartical.getDatavalue()));
        boolean saveState = blogService.save(blog);

        if (!saveState) {
            Result res = Result.create(500, "发布失败");
        }
        Result res = Result.create(200, "发布成功");
        return JsonUtil.getJson(res);
    }
}

