package com.renren.renrenXiao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.renren.renrenXiao.bean.entity.rdb.TestTable;
import com.renren.renrenXiao.dao.rdb.TestTableMapper;
import com.renren.renrenXiao.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestTableMapper testTableMapper;
	
	@Override
	public int addTestTable(TestTable record){
		int count = testTableMapper.insertSelective(record);
		return count;
	}
	
	@Override
	public TestTable findTestTableById(Long id){
		TestTable result = testTableMapper.selectByPrimaryKey(id);
		return result;
	}
	
	@Override
	public PageInfo<TestTable> findAllByPage(int pageNum,int pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<TestTable> list = testTableMapper.selectAllByList();
		PageInfo<TestTable> result = new PageInfo<TestTable>(list);
		return result;
	}
}
