package com.bookyue.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookyue.mapper.UserRedis;
import com.bookyue.model.BookComment;
import com.bookyue.service.BookCommentService;
import com.bookyue.service.UserInfoService;
import com.bookyue.util.CheckContent;

/**
 * 书籍评论Controller
 * 
 * @author bigOrang
 * @version 1.0
 *
 */
@RestController
@RequestMapping(value = "/bookComment")
public class BookCommentController {

	private static Logger logger = LoggerFactory.getLogger(BookCommentController.class);

	@Autowired
	private BookCommentService bookCommentService;

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private UserRedis userRedis;

	@Autowired
	private CheckContent checkContent;

	private Map<String, Object> result = new HashMap<String, Object>();

	/**
	 * 新增一条评论
	 * @param bookComment
	 * @return
	 */
	@PostMapping("/save")
	public Map<String, Object> add(@RequestBody BookComment bookComment, @RequestHeader("sessionId") String sessionId) {

		logger.debug(bookComment.getCommentContent());
		
		bookComment.setUserId(userRedis.getUserId(sessionId));

		// 调用微信接口检验 输入内容是否合法
		if (checkContent.isSafe(bookComment.getCommentContent())) {
			boolean isSuccess = bookCommentService.addBookComment(bookComment);
			// 添加成功
			if (isSuccess) {
				result.put("success", isSuccess);
				logger.debug("" + bookComment.getUserId());
				result.put("userInfo", userInfoService.getBriefUserInfoByUserId(bookComment.getUserId()));
			} else {
				result.put("success", false);
			}
		} else {
			result.put("success", false);
			result.put("errCode", 1);
			result.put("errMsg", "有敏感词汇");
		}
		return result;
	}

	/**
	 * 根据commentId删除评论
	 * @param commentId
	 * @return
	 */
	@DeleteMapping("/{commentId}")
	public Map<String, Object> delete(@PathVariable("commentId") Integer commentId) {
		result.put("success", bookCommentService.deleteByCommentId(commentId));
		return result;
	}

	/**
	 * 根据书籍编号commentBookId 来返回对应书籍相关的评论List集合
	 * @param bookId
	 * @return
	 */
	@GetMapping("/{bookId}")
	public Map<String, Object> getByBookId(@PathVariable("bookId") Integer bookId) {
		result.put("commentList", bookCommentService.getBookCommentCustomListByBookId(bookId));
		return result;
	}

}
