package com.renren.renrenXiao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.renren.renrenXiao.bean.dto.presentRecord.QueryPresentRecordPageByUserIdDto;
import com.renren.renrenXiao.bean.entity.rdb.PresentRecord;
import com.renren.renrenXiao.dao.rdb.PresentRecordMapper;
import com.renren.renrenXiao.service.PresentRecordService;

/**
 * 提现记录ServiceImpl
 * @author Segoul
 *
 */

@Service
public class PresentRecordServiceImpl implements PresentRecordService {

	@Autowired
	private PresentRecordMapper presentRecordMapper;
	
	/**
	 * 根据用户ID分页查询提现记录
	 * @param form
	 * @return
	 */
	@Override
	public PageInfo<PresentRecord> findPresentRecordPageByUserId(QueryPresentRecordPageByUserIdDto form){
		PageHelper.startPage(form.getCurrentPage(), form.getPageSize());
		List<PresentRecord> list = presentRecordMapper.selectPresentRecordByUserId(form.getUserId(),1);
		PageInfo<PresentRecord> result = new PageInfo<PresentRecord>(list);
		return result;
	}
}
