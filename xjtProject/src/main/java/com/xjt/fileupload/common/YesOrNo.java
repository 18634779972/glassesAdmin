package com.xjt.fileupload.common;

/**
 * @Author 刘威
 * @Date Create in 18/5/24 16:25
 * @Description
 */
public enum YesOrNo {
    YES("y"), NO("n");
    private String value;
    YesOrNo(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}