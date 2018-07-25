package com.renren.renrenXiao.dao.rdb;

import java.util.List;

import com.renren.renrenXiao.bean.entity.rdb.TestTable;

public interface TestTableMapper {
    
	int deleteByPrimaryKey(Long id);

    int insert(TestTable record);

    int insertSelective(TestTable record);

    TestTable selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TestTable record);

    int updateByPrimaryKey(TestTable record);
    
    List<TestTable> selectAllByList();
}