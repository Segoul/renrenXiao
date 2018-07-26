package com.renren.renrenXiao.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.renren.renrenXiao.bean.dto.presentRecord.QueryPresentRecordPageByUserIdDto;
import com.renren.renrenXiao.bean.entity.rdb.PresentRecord;
import com.renren.renrenXiao.common.constant.StatusCode;
import com.renren.renrenXiao.common.rest.ResultPage;
import com.renren.renrenXiao.service.PresentRecordService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 提现记录controller
 * @author Segoul
 *
 */

@Api
@RestController
@RequestMapping("/renren/presentRecord")
public class PresentRecordController extends BaseController {

	@Autowired
	private PresentRecordService presentRecordService;
	
	/**
	 * 根据用户ID分页查询提现记录
	 * @param form
	 * @return
	 */
	@ApiOperation(value = "根据用户ID分页查询提现记录")
    @RequestMapping(value = "/queryPresentRecordPageByUserId", method = RequestMethod.POST)
	public ResultPage queryPresentRecordPageByUserId(QueryPresentRecordPageByUserIdDto form){
		
		//验证参数
		if(form == null){
			return ResultPage.error(StatusCode.INVALID_PARAM);
		}
		
		Integer currentPage = form.getCurrentPage();  //当前页
		Integer pageSize = form.getPageSize();  //每页显示的总条数
		String openId = form.getOpenId();  //openId
		Integer moudleId = form.getMoudleId();  //模块ID
		
		if(currentPage == null || pageSize == null || StringUtils.isBlank(openId) || moudleId  == null){
			return ResultPage.error(StatusCode.INVALID_PARAM);
		}
		
		//获取用户信息
		Integer userId = null;
		form.setUserId(userId);
		
		//根据用户ID分页查询提现记录
		PageInfo<PresentRecord> pageList = presentRecordService.findPresentRecordPageByUserId(form);
		
		return ResultPage.list(pageList);
	}
}
