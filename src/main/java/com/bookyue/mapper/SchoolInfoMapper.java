package com.bookyue.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.bookyue.model.SchoolInfo;
import com.bookyue.model.SchoolInfoExample;

public interface SchoolInfoMapper {
    long countByExample(SchoolInfoExample example);

    int deleteByExample(SchoolInfoExample example);

    int deleteByPrimaryKey(Short schoolId);

    int insert(SchoolInfo record);

    int insertSelective(SchoolInfo record);

    List<SchoolInfo> selectByExample(SchoolInfoExample example);

    SchoolInfo selectByPrimaryKey(Short schoolId);

    int updateByExampleSelective(@Param("record") SchoolInfo record, @Param("example") SchoolInfoExample example);

    int updateByExample(@Param("record") SchoolInfo record, @Param("example") SchoolInfoExample example);

    int updateByPrimaryKeySelective(SchoolInfo record);

    int updateByPrimaryKey(SchoolInfo record);
}