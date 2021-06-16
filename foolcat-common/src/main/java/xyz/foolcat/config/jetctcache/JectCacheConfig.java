package xyz.foolcat.config.jetctcache;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.context.annotation.Configuration;

/**
 * @author Leojan
 * @date 2021-06-16 16:30
 */

@Configuration
@EnableCreateCacheAnnotation
@EnableMethodCache(basePackages = "xyz.foolcat.service.impl")
public class JectCacheConfig {
}
