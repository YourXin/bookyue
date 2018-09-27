package com.bookyue.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookyue.service.RecommendationService;

/**
 * 推荐功能
 * @author bigOrang
 *
 */
@RestController
public class RecommendationController {

	@Autowired
	private RecommendationService recommendationService;

	@GetMapping("/getRecommendation")
	public Map<String, Object> get(int pageNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageInfo", recommendationService.get(pageNum, 15));
		return map;
	}
}
