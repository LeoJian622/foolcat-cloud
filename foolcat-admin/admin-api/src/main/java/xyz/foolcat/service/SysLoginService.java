package xyz.foolcat.service;

import xyz.foolcat.dto.SysUserDto;

/**
 * 登录的接口
 *
 * @author Leojan
 * @date 2021-06-22 14:19
 */

public interface SysLoginService {

    /**
     * 登录的实现
     *
     * @param username 用户名
     * @return 用户信息
     */
    SysUserDto login(String username);
}
