package com.renren.renrenXiao.dao.rdb;

import com.renren.renrenXiao.bean.entity.rdb.PresentRecord;

/**
 * 提现记录表mapper
 * @author Segoul
 *
 */

public interface PresentRecordMapper {
    
	int deleteByPrimaryKey(Integer id);

    int insert(PresentRecord record);

    int insertSelective(PresentRecord record);

    PresentRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PresentRecord record);

    int updateByPrimaryKey(PresentRecord record);
}