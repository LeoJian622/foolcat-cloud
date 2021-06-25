package xyz.foolcat.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;

/**
 * @author Leojan
 * @date 2021-06-18 9:25
 */

public class AutoFiledValueHandler implements MetaObjectHandler {

    /**
     * 新增时填入值
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        Long userId = getUserId();
        /**
         * 3 种情况不填充
         * 1 值为null
         * 2 自动类型不匹配
         * 3 没有改字段
         */
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "updateTime", Date.class, new Date());
        // 创建人的填充
        this.strictInsertFill(metaObject, "creator", Long.class, userId);
    }

    /**
     * 修改时填入值
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        Long userId = getUserId();
        this.strictInsertFill(metaObject, "updateTime", Date.class, new Date());
        // 修改人的填充
        this.strictInsertFill(metaObject, "modifier", Long.class, userId);
    }

    /**
     * 获取安全上下文里的用户对象 --- 主要是在线程里面获取改值
     *
     * @return
     */
    private Long getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long userId = null;
        if (authentication != null) {
            String principal = authentication.getPrincipal().toString();
            userId = Long.valueOf(principal);
        }
        return userId;

    }
}
