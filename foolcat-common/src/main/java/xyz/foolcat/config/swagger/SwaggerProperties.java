package xyz.foolcat.config.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Leojan
 * @date 2021-06-15 11:09
 */

@Data
@ConfigurationProperties(prefix = "swagger")
public class SwaggerProperties {

    /**
     * 包扫描路径
     */
    private String basePackage;

    /**
     * 联系人名称
     */
    private String name;

    /**
     * 联系人主页
     */
    private String url;

    /**
     * 联系人邮箱
     */
    private String email;

    /**
     * API标题
     */
    private String title;

    /**
     * API描述
     */
    private String description;

    /**
     * API 版本号
     */
    private String version;

    /**
     * API 服务团队
     */
    private String termsOfServiceUrl;

    /**
     * 是否开启swagger
     */
    private boolean enable;

    /**
     * 调试地址
     */
    private String tryHost;

}
