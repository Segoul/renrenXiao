package com.renren.renrenXiao.common.constant;

/**
 * 系统返回码
 * @author Segoul
 *
 */

public enum StatusCode {

	SUCCESS("000000", "操作成功"),
	FAIL("900000","操作失败"),
	INVALID_PARAM("900001","参数错误"),
	SYS_ERROR("900002","系统未知错误"),
	DATA_NOT_EXIST("900003", "要操作的数据不存在"),
	DATA_BASE_OPERATE_FAIL("900004", "数据库操作失败");
	
	private String code;
	private String message;
	
	StatusCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static StatusCode getByCode(String code) {
        for (StatusCode statusCode : StatusCode.values()) {
            if (statusCode.getCode().equals(code)) {
                return statusCode;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
