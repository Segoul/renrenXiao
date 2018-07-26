package com.renren.renrenXiao.dao.rdb;

import com.renren.renrenXiao.bean.entity.rdb.AccessMallRecord;

/**
 * 顾客浏览商城记录表mapper
 * @author Segoul
 *
 */

public interface AccessMallRecordMapper {
    
	int deleteByPrimaryKey(Integer id);

    int insert(AccessMallRecord record);

    int insertSelective(AccessMallRecord record);

    AccessMallRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccessMallRecord record);

    int updateByPrimaryKey(AccessMallRecord record);
}