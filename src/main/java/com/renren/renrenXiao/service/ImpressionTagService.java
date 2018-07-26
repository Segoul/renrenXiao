package com.renren.renrenXiao.service;

import com.renren.renrenXiao.bean.dto.card.ChangeImpressionTagSupportDto;
import com.renren.renrenXiao.bean.vo.card.ImpressionTagSupportVo;

/**
 * 印象标签Service
 * @author Segoul
 *
 */

public interface ImpressionTagService {

	/**
	 * 名片印象标签点赞/取消点赞
	 * @param form
	 * @return
	 */
	ImpressionTagSupportVo changeImpressionTagSupport(ChangeImpressionTagSupportDto form);
}
