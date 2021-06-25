package xyz.foolcat.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户权限配置
 */
@ApiModel(value = "xyz-foolcat-domain-SysRolePrivilegeUser")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_role_privilege_user")
public class SysRolePrivilegeUser implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 角色ID
     */
    @TableField(value = "role_id")
    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户ID")
    private Long userId;

    /**
     * 权限ID
     */
    @TableField(value = "privilege_id")
    @ApiModelProperty(value = "权限ID")
    private Long privilegeId;

    private static final long serialVersionUID = 1L;
}