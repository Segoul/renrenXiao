package com.renren.renrenXiao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * 基础controller
 * @author Segoul
 *
 */

@Api
@RestController
@RequestMapping("/renren/base")
public class BaseController {

	protected String accessCustomerByOpenId(String openId,Integer type){
		return "";
	}
}
