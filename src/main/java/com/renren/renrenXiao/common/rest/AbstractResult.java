package com.renren.renrenXiao.common.rest;

import com.renren.renrenXiao.common.constant.StatusCode;

/**
 * 
 * @author Segoul
 *
 */

public class AbstractResult {

	String code;
	
	String message;
	
	public AbstractResult(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage();
    }

    public AbstractResult(String code, String message) {
        this.code = code;
        this.message = message;
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
