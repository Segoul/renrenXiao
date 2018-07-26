package com.renren.renrenXiao.dao.rdb;

import com.renren.renrenXiao.bean.entity.rdb.CardSupportRecord;

/**
 * 名片点赞记录表mapper
 * @author Segoul
 *
 */

public interface CardSupportRecordMapper {
    
	int deleteByPrimaryKey(Integer id);

    int insert(CardSupportRecord record);

    int insertSelective(CardSupportRecord record);

    CardSupportRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CardSupportRecord record);

    int updateByPrimaryKey(CardSupportRecord record);
}