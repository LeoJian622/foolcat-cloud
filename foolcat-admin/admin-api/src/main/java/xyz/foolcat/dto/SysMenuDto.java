package xyz.foolcat.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author Leojan
 * @date 2021-06-24 11:08
 */

@Builder
@Data
public class SysMenuDto {

    /**
     * 主键
     */
    private Long id;

    /**
     * 上级菜单ID
     */
    private String parentId;

    /**
     * 上级菜单唯一key
     */
    private String parentKey;

    /**
     * 类型
     */
    private Byte type;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 目标地址
     */
    private String targetUrl;

    /**
     * 排序索引
     */
    private Integer sort;

    /**
     * 状态
     */
    private Byte status;

    /**
     * 创建者
     */
    private Long creator;

    /**
     * 修改者
     */
    private Long modifier;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}
