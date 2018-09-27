package com.bookyue.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookyue.mapper.BookCommentMapper;
import com.bookyue.model.BookComment;
import com.bookyue.model.BookCommentCustom;
import com.bookyue.model.BookCommentExample;
import com.bookyue.service.BookCommentService;

@Service
public class BookCommentServiceImpl implements BookCommentService {

	@Autowired
	private BookCommentMapper bookCommentMapper;

	@Override
	public boolean addBookComment(BookComment bookComment) {
		try {
			if (bookComment.getUserId() != null && !"".equals(bookComment.getCommentContent())
					&& bookComment.getCommentBookId() != null) {
				bookComment.setCommentTime(new Date());
				int effectNum = bookCommentMapper.insert(bookComment);
				return effectNum == 1 ? true : false;
			}
			return false;
		} catch (Exception e) {
			throw new RuntimeException("添加BookComment失败,bookComment为" + bookComment);
		}
	}

	@Override
	public boolean deleteByCommentId(Integer commentId) {
		try {
			if (commentId != null) {
				int effectNum = bookCommentMapper.deleteByPrimaryKey(commentId);
				return effectNum == 1 ? true : false;
			}
			return false;
		} catch (Exception e) {
			throw new RuntimeException("删除BookComment失败,commentId为" + commentId);
		}

	}


	@Override
	public List<BookCommentCustom> getBookCommentCustomListByBookId(Integer commentBookId) {
		try {
			if (commentBookId != null) {
				BookCommentExample bookCommentExample = new BookCommentExample();
				bookCommentExample.createCriteria().andCommentBookIdEqualTo(commentBookId);
				return bookCommentMapper.selectByCommentBookId(commentBookId);
			}
			throw new RuntimeException("commentBookId为 null");
		} catch (Exception e) {
			throw new RuntimeException("getBookCommentCustomListByBookId()异常,commentBookId:" + commentBookId);
		}
	}
}
