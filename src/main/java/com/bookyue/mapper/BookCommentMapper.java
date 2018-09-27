package com.bookyue.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.bookyue.model.BookComment;
import com.bookyue.model.BookCommentCustom;
import com.bookyue.model.BookCommentExample;

public interface BookCommentMapper {
	long countByExample(BookCommentExample example);

	int deleteByExample(BookCommentExample example);

	int deleteByPrimaryKey(Integer commentId);

	int insert(BookComment record);

	int insertSelective(BookComment record);

	List<BookComment> selectByExample(BookCommentExample example);

	BookComment selectByPrimaryKey(Integer commentId);

	int updateByExampleSelective(@Param("record") BookComment record, @Param("example") BookCommentExample example);

	int updateByExample(@Param("record") BookComment record, @Param("example") BookCommentExample example);

	int updateByPrimaryKeySelective(BookComment record);

	int updateByPrimaryKey(BookComment record);

	/**
	 * 通过书籍id来查询评论记录
	 * @param commentBookId
	 * @return
	 */
	List<BookCommentCustom> selectByCommentBookId(Integer commentBookId);
}