package com.bookyue.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.bookyue.model.BookPublish;
import com.bookyue.model.BookPublishCustom;
import com.bookyue.model.BookPublishExample;

public interface BookPublishMapper {
    long countByExample(BookPublishExample example);

    int deleteByExample(BookPublishExample example);

    int deleteByPrimaryKey(Integer bookId);

    int insert(BookPublish record);

    int insertSelective(BookPublish record);

    List<BookPublish> selectByExample(BookPublishExample example);

    BookPublish selectByPrimaryKey(Integer bookId);

    int updateByExampleSelective(@Param("record") BookPublish record, @Param("example") BookPublishExample example);

    int updateByExample(@Param("record") BookPublish record, @Param("example") BookPublishExample example);

    int updateByPrimaryKeySelective(BookPublish record);

    int updateByPrimaryKey(BookPublish record);
    
    /**
     * 查询书籍发布的信息,包括发布者的头像路径，昵称，性别
     * @param bookId
     * @return BookPublishCustom
     */
    BookPublishCustom selectBookPublishCustomByPrimaryKey(Integer bookId);
    
    /**
     * 查询书籍发布的信息集合List,包括发布者的头像路径，昵称，性别
     * @param bookPublish
     * @return List<BookPublishCustom>
     */
    List<BookPublishCustom> selectBookPublishCustomByExample(BookPublishExample example);
    
    
}