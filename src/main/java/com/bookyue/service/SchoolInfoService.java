package com.bookyue.service;

import java.util.List;

import com.bookyue.model.SchoolInfo;

/**
 * 学校Service
 * @author bigOrang
 *
 */
public interface SchoolInfoService {

	/**
	 * 通过学校id来查询学校
	 * @param schoolId
	 * @return
	 */
	SchoolInfo getBySchoolId(Short schoolId);

	/**
	 * 通过学校名字的关键字来模糊查询,得到符合条件的集合
	 * @param keyword 
	 * @return
	 */
	List<SchoolInfo> getByKeyword(String keyword);
	
}
