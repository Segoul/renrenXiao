package com.renren.renrenXiao.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.renren.renrenXiao.bean.dto.card.ChangeImpressionTagSupportDto;
import com.renren.renrenXiao.bean.vo.card.ImpressionTagSupportVo;
import com.renren.renrenXiao.common.constant.StatusCode;
import com.renren.renrenXiao.common.rest.ResultData;
import com.renren.renrenXiao.service.ImpressionTagService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 名片相关controller
 * @author Segoul
 *
 */

@Api
@RestController
@RequestMapping("/renren/card")
public class CardController extends BaseController {

	@Autowired
	private ImpressionTagService impressionTagService;
	
	/**
	 * 名片印象标签点赞/取消点赞
	 * @param form
	 * @return
	 */
	@ApiOperation(value = "名片印象标签点赞/取消点赞")
    @RequestMapping(value = "/changeImpressionTagSupport", method = RequestMethod.POST)
	public ResultData changeImpressionTagSupport(ChangeImpressionTagSupportDto form){
		
		//验证参数
		if(form == null){
			return ResultData.error(StatusCode.INVALID_PARAM);
		}
		
		Integer impressionTagId = form.getImpressionTagId();  //印象标签ID
		String openId = form.getOpenId();  //openId
		Integer moudleId = form.getMoudleId();  //模块ID
		
		if(impressionTagId == null || StringUtils.isBlank(openId) || moudleId  == null){
			return ResultData.error(StatusCode.INVALID_PARAM);
		}
		
		//获取用户信息
		Integer userId = null;
		form.setUserId(userId);
		
		//名片印象标签点赞/取消点赞
		ImpressionTagSupportVo result = impressionTagService.changeImpressionTagSupport(form);
		
		return ResultData.one(result);
	}
}
