package xyz.foolcat.config.resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;

/**
 * @author Leojan
 * @date 2021-06-16 12:00
 */

@Slf4j
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableResourceServer
public class ResourceSercerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement().disable()
                .authorizeRequests().antMatchers(
                "/swagger**/**",
                "/webjars/**",
                "/v3/**",
                "/doc.html"
        ).permitAll()
                .antMatchers("/**").authenticated()
                .and().headers().cacheControl();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore());
    }

    private TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    private JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        //加载公钥
        ClassPathResource publicKeyResource = new ClassPathResource("foolcat.pub");
        String publicKey = null;
        try {
            byte[] bytes = FileCopyUtils.copyToByteArray(publicKeyResource.getInputStream());
            publicKey = new String(bytes);
        } catch (IOException e) {
            log.warn("读取公钥失败");
        }
        jwtAccessTokenConverter.setVerifierKey(publicKey);
        return jwtAccessTokenConverter;
    }


}
