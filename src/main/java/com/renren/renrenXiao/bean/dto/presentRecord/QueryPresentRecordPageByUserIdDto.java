package com.renren.renrenXiao.bean.dto.presentRecord;

/**
 * 根据用户ID分页查询提现记录入参
 * @author Segoul
 *
 */

public class QueryPresentRecordPageByUserIdDto {

	private Integer currentPage;  //当前页
	
	private Integer pageSize;  //每页显示的总条数
	
	private String openId;  //openId
	
	private Integer moudleId;  //模块ID
	
	private Integer userId;  //用户ID（前端不传）

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
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
