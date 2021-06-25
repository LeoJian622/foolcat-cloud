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
 * 权限配置
 */
@ApiModel(value = "xyz-foolcat-domain-SysPrivilege")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_privilege")
public class SysPrivilege implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 所属菜单ID
     */
    @TableField(value = "menu_id")
    @ApiModelProperty(value = "所属菜单ID")
    private String menuId;

    /**
     * 名称
     */
    @TableField(value = "`name`")
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 描述
     */
    @TableField(value = "description")
    @ApiModelProperty(value = "描述")
    private String description;

    /**
     * 目标地址
     */
    @TableField(value = "url")
    @ApiModelProperty(value = "目标地址")
    private String url;

    @TableField(value = "`method`")
    @ApiModelProperty(value = "")
    private String method;

    /**
     * 创建者
     */
    @TableField(value = "creator", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建者")
    private Long creator;

    /**
     * 修改者
     */
    @TableField(value = "modifier", fill = FieldFill.UPDATE)
    @ApiModelProperty(value = "修改者")
    private Long modifier;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;


    /**
     * 标记单前角色是否拥有该权限
     */
    @TableField(exist = false)
    @ApiModelProperty(value = "当前角色是否拥有这个权限")
    private int own;

    private static final long serialVersionUID = 1L;
}