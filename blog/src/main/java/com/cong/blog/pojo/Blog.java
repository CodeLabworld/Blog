package com.cong.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author qiu
 * @since 2021-06-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Blog对象", description="")
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "文章标题")
    private String title;

    @ApiModelProperty(value = "首图")
    private String firstPicture;

    @ApiModelProperty(value = "文章内容")
    private String content;

    @ApiModelProperty(value = "文章描述")
    private String description;

    @ApiModelProperty(value = "是否公开")
    private Boolean isPublished;

    @ApiModelProperty(value = "是否推荐")
    private Boolean isRecommend;

    @ApiModelProperty(value = "是否支持评论")
    private Boolean isCommentEnable;

    @ApiModelProperty(value = "文章创建时间")
    private Date createTime;

    @ApiModelProperty(value = "文章更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "观看次数")
    private Integer views;

    @ApiModelProperty(value = "分类")
    private Integer category;

    @ApiModelProperty(value = "是否置顶")
    private Boolean isTop;

    @ApiModelProperty(value = "文章密码")
    private String password;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "文章别名")
    private String name;


}
