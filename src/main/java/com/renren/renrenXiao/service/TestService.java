package com.renren.renrenXiao.service;

import com.github.pagehelper.PageInfo;
import com.renren.renrenXiao.bean.entity.rdb.TestTable;

public interface TestService {

	int addTestTable(TestTable record);
	
	TestTable findTestTableById(Long id);
	
	PageInfo<TestTable> findAllByPage(int pageNum,int pageSize);
}
