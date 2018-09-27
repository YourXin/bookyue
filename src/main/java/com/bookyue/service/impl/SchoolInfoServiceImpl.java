package com.bookyue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookyue.mapper.SchoolInfoMapper;
import com.bookyue.model.SchoolInfo;
import com.bookyue.model.SchoolInfoExample;
import com.bookyue.service.SchoolInfoService;

@Service
public class SchoolInfoServiceImpl implements SchoolInfoService {

	@Autowired
	private SchoolInfoMapper schoolInfoMapper;

	@Override
	public SchoolInfo getBySchoolId(Short schoolId) {
		if (schoolId == null) {
			throw new RuntimeException("schoolId为空");
		}
		return schoolInfoMapper.selectByPrimaryKey(schoolId);
	}

	@Override
	public List<SchoolInfo> getByKeyword(String keyword) {

		if (keyword != null && !"".equals(keyword)) {
			SchoolInfoExample schoolInfoExample = new SchoolInfoExample();
			schoolInfoExample.createCriteria().andSchoolNameLike("%" + keyword + "%");
			return schoolInfoMapper.selectByExample(schoolInfoExample);
		} else {
			throw new RuntimeException("keyword为空");
		}
	}
}
