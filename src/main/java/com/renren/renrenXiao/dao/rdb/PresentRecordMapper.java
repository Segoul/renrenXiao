package com.renren.renrenXiao.dao.rdb;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
    
    /**
     * 根据用户ID查询提现记录（区分类别）
     * @param userId  用户ID
     * @param type  类型
     * @return
     */
    List<PresentRecord> selectPresentRecordByUserId(@Param("userId") Integer userId,@Param("type") Integer type);
}