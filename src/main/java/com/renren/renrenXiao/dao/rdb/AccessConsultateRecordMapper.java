package com.renren.renrenXiao.dao.rdb;

import com.renren.renrenXiao.bean.entity.rdb.AccessConsultateRecord;

/**
 * 顾客咨询记录表mapper
 * @author Segoul
 *
 */

public interface AccessConsultateRecordMapper {
    
	int deleteByPrimaryKey(Integer id);

    int insert(AccessConsultateRecord record);

    int insertSelective(AccessConsultateRecord record);

    AccessConsultateRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccessConsultateRecord record);

    int updateByPrimaryKey(AccessConsultateRecord record);
}