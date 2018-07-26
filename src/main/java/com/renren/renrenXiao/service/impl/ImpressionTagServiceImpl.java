package com.renren.renrenXiao.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.renren.renrenXiao.bean.dto.card.ChangeImpressionTagSupportDto;
import com.renren.renrenXiao.bean.entity.rdb.ImpressionTag;
import com.renren.renrenXiao.bean.entity.rdb.TagSupportRecord;
import com.renren.renrenXiao.bean.vo.card.ImpressionTagSupportVo;
import com.renren.renrenXiao.common.constant.StatusCode;
import com.renren.renrenXiao.common.exception.CommonException;
import com.renren.renrenXiao.dao.rdb.ImpressionTagMapper;
import com.renren.renrenXiao.dao.rdb.TagSupportRecordMapper;
import com.renren.renrenXiao.service.ImpressionTagService;

/**
 * 印象标签ServiceImpl
 * @author Segoul
 *
 */

@Service
public class ImpressionTagServiceImpl implements ImpressionTagService {

	@Autowired
	private ImpressionTagMapper impressionTagMapper;
	
	@Autowired
	private TagSupportRecordMapper tagSupportRecordMapper;
	
	/**
	 * 名片印象标签点赞/取消点赞
	 * @param form
	 * @return
	 */
	@Transactional
	public ImpressionTagSupportVo changeImpressionTagSupport(ChangeImpressionTagSupportDto form){
		
		ImpressionTagSupportVo result = new ImpressionTagSupportVo();
		
		//根据印象标签ID查询印象标签
		ImpressionTag impressionTag = impressionTagMapper.selectByPrimaryKey(form.getImpressionTagId());
		if(impressionTag == null){
			throw new CommonException(StatusCode.DATA_NOT_EXIST);
		}
		
		Integer status = 0;  //0：取消点赞成功，1：点赞成功
		Integer support_num = impressionTag.getSupportPoint();  //用户点赞数
		Integer total_num = support_num+impressionTag.getInitialPoint();  //用户点赞数+默认点赞数
		
		//根据印象标签ID和用户ID查询印象标签点赞记录
		TagSupportRecord valid = tagSupportRecordMapper.selectTagSupportRecordByUserTagId(form.getUserId(),form.getImpressionTagId());
		if(valid == null){  //用户未点赞，执行点赞
			//新增印象标签点赞记录
			TagSupportRecord newRecord = new TagSupportRecord();
			newRecord.setUserId(form.getUserId());
			newRecord.setTagId(form.getImpressionTagId());
			newRecord.setCreateTime(new Date());
			
			int count = tagSupportRecordMapper.insertSelective(newRecord);
			if(count == 0){
				throw new CommonException(StatusCode.DATA_BASE_OPERATE_FAIL);
			}
			
			//增加印象标签用户点赞数，加1
			impressionTag.setSupportPoint(support_num+1);
			int updateCount = impressionTagMapper.updateByPrimaryKeySelective(impressionTag);
			if(updateCount == 0){
				throw new CommonException(StatusCode.DATA_BASE_OPERATE_FAIL);
			}
			
			result.setStatus(1);
			result.setSupportNum(total_num+1);
			
		}else{
			//删除印象标签点赞记录
			int count = tagSupportRecordMapper.deleteByPrimaryKey(valid.getId());
			if(count == 0){
				throw new CommonException(StatusCode.DATA_BASE_OPERATE_FAIL);
			}
			
			//减少印象标签用户点赞数，减1
			if(support_num > 0){
				impressionTag.setSupportPoint(support_num-1);
				int updateCount = impressionTagMapper.updateByPrimaryKeySelective(impressionTag);
				if(updateCount == 0){
					throw new CommonException(StatusCode.DATA_BASE_OPERATE_FAIL);
				}
				
				result.setSupportNum(total_num-1);
			}
			
			result.setStatus(0);
			
		}
		
		return result;
	}
}
