package com.renren.renrenXiao.dao.rdb;

import com.renren.renrenXiao.bean.entity.rdb.MasterUser;

/**
 * 用户主表mapper
 * @author Segoul
 *
 */

public interface MasterUserMapper {
    
	int deleteByPrimaryKey(Integer id);

    int insert(MasterUser record);

    int insertSelective(MasterUser record);

    MasterUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MasterUser record);

    int updateByPrimaryKey(MasterUser record);
}