package xyz.foolcat.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import xyz.foolcat.constant.LoginConstant;
import xyz.foolcat.dto.SysUserDto;
import xyz.foolcat.service.SysLoginService;

import java.util.stream.Collectors;

/**
 * @author Leojan
 * @date 2021-06-09 15:07
 */

public class UserServiceDetailsServiceImpl implements UserDetailsService {

    @DubboReference
    private SysLoginService sysLoginService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert requestAttributes != null;
        String loginType = requestAttributes.getRequest().getParameter("login_type");
        if (StringUtils.isEmpty(loginType)) {
            throw new AuthenticationServiceException("登录类型不能为null");
        }

        switch (loginType) {
            case LoginConstant.ADMIN_TYPE:
                return loadSysUserByUsername(username);
            case LoginConstant.MEMBER_TYPE:
                return loadMemberUserByUsername(username);
            default:
                throw new AuthenticationServiceException("不支持的登录类型");
        }
    }

    private UserDetails loadMemberUserByUsername(String username) {
        SysUserDto userInfo = sysLoginService.login(username);
        User user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus(), true, true, true, userInfo.getAuthorities().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        return null;
    }

    private UserDetails loadSysUserByUsername(String username) {
        return null;
    }
}
