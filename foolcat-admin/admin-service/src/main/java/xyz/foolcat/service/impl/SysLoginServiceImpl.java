package xyz.foolcat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.foolcat.domain.SysUser;
import xyz.foolcat.dto.SysMenuDto;
import xyz.foolcat.dto.SysUserDto;
import xyz.foolcat.service.SysLoginService;
import xyz.foolcat.service.SysMenuService;
import xyz.foolcat.service.SysPrivilegeService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 登录接口实现
 *
 * @author Leojan
 * @date 2021-06-22 14:21
 */

@DubboService
@Slf4j
public class SysLoginServiceImpl implements SysLoginService {

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SysPrivilegeService sysPrivilegeService;

    /**
     * 登录信息获取
     *
     * @param username 用户名
     * @return 用户信息
     */
    @Override
    public SysUserDto login(String username) {
        log.info("用户{}开始登录，获取相关信息", username);
        //1 获取用户信息
        SysUser sysUser = new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername, username).getEntity();
        //  菜单数据
        List<SysMenuDto> menus = sysMenuService.getMenusByUserId(sysUser.getId()).stream()
                .map(sysMenu -> SysMenuDto.builder()
                        .id(sysUser.getId())
                        .parentId(sysMenu.getParentId())
                        .parentKey(sysMenu.getParentKey())
                        .type(sysMenu.getType())
                        .name(sysMenu.getName())
                        .description(sysMenu.getDescription())
                        .targetUrl(sysMenu.getTargetUrl())
                        .sort(sysMenu.getSort())
                        .status(sysMenu.getStatus())
                        .build())
                .collect(Collectors.toList());
        //  权限数据
        List<String> authorities = sysPrivilegeService.getAuthorityByUserId(sysUser.getId());
        return SysUserDto.builder()
                .id(sysUser.getId())
                .username(sysUser.getUsername())
                .password(sysUser.getPassword())
                .status(sysUser.getStatus() == 1 ? Boolean.TRUE : Boolean.FALSE)
                .menus(menus)
                .authorities(authorities)
                .build();
    }
}
