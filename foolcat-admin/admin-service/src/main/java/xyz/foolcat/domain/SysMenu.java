package xyz.foolcat.domain;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 系统菜单
 */
@ApiModel(value = "xyz-foolcat-domain-SysMenu")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_menu")
public class SysMenu implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 上级菜单ID
     */
    @TableField(value = "parent_id")
    @ApiModelProperty(value = "上级菜单ID")
    private String parentId;

    /**
     * 上级菜单唯一key
     */
    @TableField(value = "parent_key")
    @ApiModelProperty(value = "上级菜单唯一key")
    private String parentKey;

    /**
     * 类型
     */
    @TableField(value = "`type`")
    @ApiModelProperty(value = "类型")
    private Byte type;

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
    @TableField(value = "target_url")
    @ApiModelProperty(value = "目标地址")
    private String targetUrl;

    /**
     * 排序索引
     */
    @TableField(value = "sort")
    @ApiModelProperty(value = "排序索引")
    private Integer sort;

    /**
     * 状态
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value = "状态")
    private Byte status;

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
     * 一个菜单对应多个权限
     */
    @TableField(exist = false)
    @ApiModelProperty("该菜单下的所有的权限")
    private List<SysPrivilege> privileges = Collections.emptyList();

    /**
     * 一个菜单对应多个子菜单
     */
    @TableField(exist = false)
    @ApiModelProperty("该菜单的子菜单")
    private List<SysMenu> childs = Collections.emptyList();

    /**
     * 前台显示唯一key值
     */
    @TableField(exist = false)
    @ApiModelProperty("该菜单的唯一key值")
    private String menuKey;

    /**
     * 获取菜单的唯一KEY凭证
     *
     * @return
     */
    public String getMenuKey() {
        if (!StringUtils.isEmpty(parentKey)) {
            return parentKey + id;
        } else {
            return Long.toString(id);
        }
    }

    private static final long serialVersionUID = 1L;
}