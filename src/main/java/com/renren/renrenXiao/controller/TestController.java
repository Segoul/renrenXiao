package com.renren.renrenXiao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.renren.renrenXiao.bean.entity.rdb.TestTable;
import com.renren.renrenXiao.common.rest.ResultData;
import com.renren.renrenXiao.service.TestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("/renren/test")
public class TestController {

	@Autowired
	private TestService testService;
	
	/**
	 * 测试方法
	 * @return
	 */
	@ApiOperation(value = "测试方法")
    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
	public String sayHello(){
		return "123";
	}
	
	/**
	 * 新增测试
	 * @param record
	 * @return
	 */
	@ApiOperation(value = "新增测试")
    @RequestMapping(value = "/insertTest", method = RequestMethod.POST)
	public String insertTest(TestTable record){
		
		int count = testService.addTestTable(record);
		
		return "add ok!";
	}
	
	/**
	 * 查询测试
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "查询测试")
    @RequestMapping(value = "/queryTestById", method = RequestMethod.GET)
	public ResultData queryTestById(Long id){
		
		TestTable record = testService.findTestTableById(id);
		
		return ResultData.one(record);
	}
}
