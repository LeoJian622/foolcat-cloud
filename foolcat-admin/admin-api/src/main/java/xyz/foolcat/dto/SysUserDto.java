package xyz.foolcat.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 用户登录信息校验返回
 *
 * @author Leojan
 * @date 2021-06-23 14:25
 */

@Data
@Builder
public class SysUserDto implements Serializable {

    private static final long serialVersionUID = 5260686281070335852L;

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 是否有效
     */
    private Boolean status;

    /**
     * 菜单数据
     */
    private List<SysMenuDto> menus;

    /**
     * 权限数据
     */
    private List<String> authorities;
}
