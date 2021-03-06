package com.bookyue.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.bookyue.model.Recommendation;
import com.bookyue.model.RecommendationExample;

public interface RecommendationMapper {
    long countByExample(RecommendationExample example);

    int deleteByExample(RecommendationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Recommendation record);

    int insertSelective(Recommendation record);

    List<Recommendation> selectByExample(RecommendationExample example);

    Recommendation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Recommendation record, @Param("example") RecommendationExample example);

    int updateByExample(@Param("record") Recommendation record, @Param("example") RecommendationExample example);

    int updateByPrimaryKeySelective(Recommendation record);

    int updateByPrimaryKey(Recommendation record);
}