package xyz.foolcat.domain;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 系统日志
 */
@ApiModel(value = "xyz-foolcat-domain-SysUserLog")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_user_log")
public class SysUserLog implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 组
     */
    @TableField(value = "group_name")
    @ApiModelProperty(value = "组")
    private String groupName;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户ID")
    private Long userId;

    /**
     * 日志类型-1查询2修改3新增4删除5导出6审核
     */
    @TableField(value = "`type`")
    @ApiModelProperty(value = "日志类型-1查询2修改3新增4删除5导出6审核")
    private Short type;

    /**
     * 方法
     */
    @TableField(value = "`method`")
    @ApiModelProperty(value = "方法")
    private String method;

    /**
     * 参数
     */
    @TableField(value = "params")
    @ApiModelProperty(value = "参数")
    private String params;

    /**
     * IP地址
     */
    @TableField(value = "ip")
    @ApiModelProperty(value = "IP地址")
    private String ip;

    /**
     * 描述
     */
    @TableField(value = "description")
    @ApiModelProperty(value = "描述")
    private String description;

    /**
     * 备注
     */
    @TableField(value = "remark")
    @ApiModelProperty(value = "备注")
    private String remark;

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

    private static final long serialVersionUID = 1L;
}