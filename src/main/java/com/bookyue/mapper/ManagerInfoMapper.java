package com.bookyue.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.bookyue.model.ManagerInfo;
import com.bookyue.model.ManagerInfoExample;

public interface ManagerInfoMapper {
    long countByExample(ManagerInfoExample example);

    int deleteByExample(ManagerInfoExample example);

    int deleteByPrimaryKey(Integer managerId);

    int insert(ManagerInfo record);

    int insertSelective(ManagerInfo record);

    List<ManagerInfo> selectByExample(ManagerInfoExample example);

    ManagerInfo selectByPrimaryKey(Integer managerId);

    int updateByExampleSelective(@Param("record") ManagerInfo record, @Param("example") ManagerInfoExample example);

    int updateByExample(@Param("record") ManagerInfo record, @Param("example") ManagerInfoExample example);

    int updateByPrimaryKeySelective(ManagerInfo record);

    int updateByPrimaryKey(ManagerInfo record);
}