package xyz.foolcat.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import xyz.foolcat.constant.LoginConstant;

/**
 * @author Leojan
 * @date 2021-06-09 15:07
 */

public class UserServiceDetailsServiceImpl implements UserDetailsService {
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
        return null;
    }

    private UserDetails loadSysUserByUsername(String username) {
        return null;
    }
}
