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
 * 平台配置信息
 */
@ApiModel(value = "xyz-foolcat-domain-Config")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "config")
public class Config implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 配置规则类型
     */
    @TableField(value = "`type`")
    @ApiModelProperty(value = "配置规则类型")
    private String type;

    /**
     * 配置规则代码
     */
    @TableField(value = "code")
    @ApiModelProperty(value = "配置规则代码")
    private String code;

    /**
     * 配置规则名称
     */
    @TableField(value = "`name`")
    @ApiModelProperty(value = "配置规则名称")
    private String name;

    /**
     * 配置规则描述
     */
    @TableField(value = "`desc`")
    @ApiModelProperty(value = "配置规则描述")
    private String desc;

    /**
     * 配置值
     */
    @TableField(value = "`value`")
    @ApiModelProperty(value = "配置值")
    private String value;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}