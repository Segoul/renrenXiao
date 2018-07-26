package com.renren.renrenXiao.service;

import com.github.pagehelper.PageInfo;
import com.renren.renrenXiao.bean.dto.presentRecord.QueryPresentRecordPageByUserIdDto;
import com.renren.renrenXiao.bean.entity.rdb.PresentRecord;

/**
 * 提现记录Service
 * @author Segoul
 *
 */

public interface PresentRecordService {

	/**
	 * 根据用户ID分页查询提现记录
	 * @param form
	 * @return
	 */
	PageInfo<PresentRecord> findPresentRecordPageByUserId(QueryPresentRecordPageByUserIdDto form);
}
