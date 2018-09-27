package com.bookyue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookyue.model.SchoolInfo;
import com.bookyue.service.SchoolInfoService;

/**
 * 学校信息
 * 
 * @author bigOrang
 *
 */
@RestController
@RequestMapping(value = "/schoolInfo")
public class SchoolInfoController {

	@Autowired
	private SchoolInfoService schoolInfoService;

	/**
	 * 通过schoolId得到对应的学校信息
	 * @param schoolId 
	 * @return 
	 */
	@GetMapping("/getBySchoolId/{schoolId}")
	public SchoolInfo getSchoolInfoBySchoolId(@PathVariable("schoolId") Short schoolId) {
		return schoolInfoService.getBySchoolId(schoolId);
	}

	@GetMapping("/getByKeyword")
	public List<SchoolInfo> getSchoolInfoBykeyword(String keyword) {
		return schoolInfoService.getByKeyword(keyword);
	}

}
