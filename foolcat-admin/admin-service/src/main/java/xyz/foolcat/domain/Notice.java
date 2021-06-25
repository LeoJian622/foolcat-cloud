package xyz.foolcat.domain;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统资讯公告信息
 */
@ApiModel(value = "xyz-foolcat-domain-Notice")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "notice")
public class Notice implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 标题
     */
    @TableField(value = "title")
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 简介
     */
    @TableField(value = "description")
    @ApiModelProperty(value = "简介")
    private String description;

    /**
     * 作者
     */
    @TableField(value = "author")
    @ApiModelProperty(value = "作者")
    private String author;

    /**
     * 文章状态
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value = "文章状态")
    private Integer status;

    /**
     * 文章排序，越大越靠前
     */
    @TableField(value = "sort")
    @ApiModelProperty(value = "文章排序，越大越靠前")
    private Integer sort;

    /**
     * 内容
     */
    @TableField(value = "content")
    @ApiModelProperty(value = "内容")
    private String content;

    /**
     * 最后修改时间
     */
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    @ApiModelProperty(value = "最后修改时间")
    private Date updateTime;

    /**
     * 创建日期
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建日期")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}