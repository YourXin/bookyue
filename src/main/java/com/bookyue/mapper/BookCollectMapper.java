package com.bookyue.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bookyue.model.BookCollect;
import com.bookyue.model.BookCollectCustom;
import com.bookyue.model.BookCollectExample;

public interface BookCollectMapper {
    long countByExample(BookCollectExample example);

    int deleteByExample(BookCollectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BookCollect record);

    int insertSelective(BookCollect record);

    List<BookCollect> selectByExample(BookCollectExample example);

    BookCollect selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BookCollect record, @Param("example") BookCollectExample example);

    int updateByExample(@Param("record") BookCollect record, @Param("example") BookCollectExample example);

    int updateByPrimaryKeySelective(BookCollect record);

    int updateByPrimaryKey(BookCollect record);
    
    /**
     * 通过userId查询收藏记录
     * @param userId 用户id
     * @return
     */
    List<BookCollectCustom> selectByUserId(Integer userId);
}