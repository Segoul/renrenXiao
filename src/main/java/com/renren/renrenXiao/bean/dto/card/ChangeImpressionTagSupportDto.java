package com.renren.renrenXiao.bean.dto.card;

/**
 * 名片印象标签点赞/取消点赞入参
 * @author Segoul
 *
 */

public class ChangeImpressionTagSupportDto {

	private Integer impressionTagId;  //印象标签ID
	
	private String openId;  //openId
	
	private Integer moudleId;  //模块ID
	
	private Integer userId;  //用户ID（前端不传）

	public Integer getImpressionTagId() {
		return impressionTagId;
	}

	public void setImpressionTagId(Integer impressionTagId) {
		this.impressionTagId = impressionTagId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Integer getMoudleId() {
		return moudleId;
	}

	public void setMoudleId(Integer moudleId) {
		this.moudleId = moudleId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
