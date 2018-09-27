package com.bookyue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookyue.mapper.RecommendationMapper;
import com.bookyue.model.Recommendation;
import com.bookyue.service.RecommendationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class RecommendationServiceImpl implements RecommendationService {

	@Autowired
	private RecommendationMapper recommendationMapper;

	@Override
	public PageInfo<Recommendation> get(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Recommendation> list = recommendationMapper.selectByExample(null);
		return new PageInfo<Recommendation>(list);
	}

}
