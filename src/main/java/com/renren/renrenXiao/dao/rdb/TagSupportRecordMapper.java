package com.renren.renrenXiao.dao.rdb;

import org.apache.ibatis.annotations.Param;

import com.renren.renrenXiao.bean.entity.rdb.TagSupportRecord;

/**
 * 印象标签点赞记录表mapper
 * @author Segoul
 *
 */

public interface TagSupportRecordMapper {
    
	int deleteByPrimaryKey(Integer id);

    int insert(TagSupportRecord record);

    int insertSelective(TagSupportRecord record);

    TagSupportRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TagSupportRecord record);

    int updateByPrimaryKey(TagSupportRecord record);
    
    /**
     * 根据印象标签ID和用户ID查询印象标签点赞记录
     * @param userId  用户ID
     * @param tagId  印象标签ID
     * @return
     */
    TagSupportRecord selectTagSupportRecordByUserTagId(@Param("userId") Integer userId,@Param("tagId") Integer tagId);
}