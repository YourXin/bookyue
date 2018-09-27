package com.bookyue.service;

import com.bookyue.model.Recommendation;
import com.github.pagehelper.PageInfo;



public interface RecommendationService {

	/**
	 * 无条件查询-做分页
	 * @param pageNum
	 * @return PageInfo<Recommendation>
	 */
	public PageInfo<Recommendation> get(int pageNum, int pageSize);

}
