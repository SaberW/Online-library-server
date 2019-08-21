package com.xzr.onlinelibrary.entity;

import lombok.Data;

import java.util.HashMap;

/**
 * 返回数据
 */
@Data
public class ResultData extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public static final String CODE_TAG = "code";

    public static final String MSG_TAG = "msg";

    public static final String DATA_TAG = "data";

    /**
     * 状态类型
     */
    public enum Type {
        /**
         * 成功
         */
        SUCCESS(1),
        /**
         * 警告
         */
        WARN(301),
        /**
         * 错误
         */
        ERROR(500);

        private final int value;

        Type(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }

    /**
     * 状态类型
     */
    private Type type;

    /**
     * 状态码
     */
    private int code;

    /**
     * 返回内容
     */
    private String msg;

    /**
     * 数据对象
     */
    private Object data;

    /**
     * 初始化一个新创建的 ResultData 对象，使其表示一个空消息。
     */
    public ResultData() {
    }


    /**
     * 初始化一个新创建的 ResultData 对象
     *
     * @param type 状态类型
     * @param msg  返回内容
     */
    public ResultData(Type type, String msg) {
        super.put(CODE_TAG, type.value);
        super.put(MSG_TAG, msg);
    }

    /**
     * 初始化一个新创建的 ResultData 对象
     *
     * @param type 状态类型
     * @param msg  返回内容
     * @param data 数据对象
     */
    public ResultData(Type type, String msg, Object data) {
        super.put(CODE_TAG, type.value);
        super.put(MSG_TAG, msg);
        if (null != data) {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static ResultData success() {
        return ResultData.success("操作成功");
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static ResultData success(Object data) {
        return ResultData.success("操作成功", data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static ResultData success(String msg) {
        return ResultData.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static ResultData success(String msg, Object data) {
        return new ResultData(Type.SUCCESS, msg, data);
    }

    /**
     * 返回警告消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static ResultData warn(String msg) {
        return ResultData.warn(msg, null);
    }

    /**
     * 返回警告消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static ResultData warn(String msg, Object data) {
        return new ResultData(Type.WARN, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static ResultData error() {
        return ResultData.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static ResultData error(String msg) {
        return ResultData.error(msg, null);
    }

    /**
     * 返回错误消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static ResultData error(String msg, Object data) {
        return new ResultData(Type.ERROR, msg, data);
    }

}
