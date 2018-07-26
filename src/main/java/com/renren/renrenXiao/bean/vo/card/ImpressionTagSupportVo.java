package com.renren.renrenXiao.bean.vo.card;

/**
 * 印象标签点赞结果出参
 * @author Segoul
 *
 */

public class ImpressionTagSupportVo {

	private Integer status;  //0：取消点赞成功，1：点赞成功
	
	private Integer supportNum;  //总点赞数

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSupportNum() {
		return supportNum;
	}

	public void setSupportNum(Integer supportNum) {
		this.supportNum = supportNum;
	}
	
	
}
