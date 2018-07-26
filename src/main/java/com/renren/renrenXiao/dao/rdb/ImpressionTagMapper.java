package com.renren.renrenXiao.dao.rdb;

import com.renren.renrenXiao.bean.entity.rdb.ImpressionTag;

/**
 * 印象标签表mapper
 * @author Segoul
 *
 */

public interface ImpressionTagMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(ImpressionTag record);

    int insertSelective(ImpressionTag record);

    ImpressionTag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImpressionTag record);

    int updateByPrimaryKey(ImpressionTag record);
}