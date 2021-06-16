package xyz.foolcat.model;

import xyz.foolcat.constant.Constants;

import java.io.Serializable;

/**
 * 公告的返回值对象
 *
 * @param <T>
 * @author Leojan
 * @date 2021-06-16 16:56
 */

public class R<T> implements Serializable {

    private static final long serialVersionUID = -7985748404021353927L;

    /**
     * 成功
     */
    public static final int SUCCESS = Constants.SUCCESS;

    /**
     * 失败
     */
    public static final int FAIL = Constants.FAIL;

}
