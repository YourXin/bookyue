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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookyue.mapper.UserRedis;
import com.bookyue.model.BookCollect;
import com.bookyue.service.BookCollectService;

/**
 * 书籍收藏
 * @author bigOrang
 *
 */
@RestController
@RequestMapping(value = "/bookCollect")
public class BookCollectController {

	private static Logger logger = LoggerFactory.getLogger(BookCollectController.class);

	@Autowired
	private BookCollectService bookCollectService;

	@Autowired
	private UserRedis userRedis;

	// 返回数据
	private Map<String, Object> map = new HashMap<String, Object>();

	/**
	 * 添加收藏记录
	 * @param bookCollect
	 * @return
	 */
	@PostMapping("/save")
	public Map<String, Object> save(@RequestParam("bookId") Integer bookId, @RequestHeader("sessionId") String sessionId) {
		logger.debug(bookId + "");
		logger.debug(sessionId);
		BookCollect bookCollect = new BookCollect();
		bookCollect.setUserId(userRedis.getUserId(sessionId));
		bookCollect.setBookId(bookId);
		map.put("success", bookCollectService.addBookCollect(bookCollect));
		return map;
	}

	/**
	 * 通过id和userId
	 * 删除收藏记录/取消收藏
	 * 个人收藏菜单时使用
	 * @param bookCollect
	 * @return
	 */
	@DeleteMapping("/delete")
	public Map<String, Object> delete(@RequestBody BookCollect bookCollect,
			@RequestHeader("sessionId") String sessionId) {
		bookCollect.setUserId(userRedis.getUserId(sessionId));

		map.put("success", bookCollectService.deleteBookCollect(bookCollect.getId(), bookCollect.getUserId()));
		return map;
	}

	/**
	 * 使用bookId和userId来取消收藏
	 * @param bookCollect
	 * @return
	 */
	@DeleteMapping("/cancleFavorite")
	public Map<String, Object> cancleFavorite(@RequestBody BookCollect bookCollect,
			@RequestHeader("sessionId") String sessionId) {

		bookCollect.setUserId(userRedis.getUserId(sessionId));

		map.put("success", bookCollectService.deleteBookCollectByBookIdAndUserId(bookCollect.getBookId(),
				bookCollect.getUserId()));
		return map;
	}

	/**
	 * 通过userid和bookid得到bookCollect记录
	 * 
	 * @param bookCollect
	 * @return
	 */

	@GetMapping("/getByBookIdAndUserId")
	public Map<String, Object> getByBookIdAndUserId(BookCollect bookCollect,
			@RequestHeader("sessionId") String sessionId) {
		logger.debug("getByBookIdAndUserId sessionId:" + sessionId);
		logger.debug("userId" + userRedis.getUserId(sessionId));
		
		bookCollect.setUserId(userRedis.getUserId(sessionId));

		logger.debug(bookCollect.toString());
//		boolean isExist = bookCollectService.isExist(bookCollect.getUserId(), bookCollect.getBookId());
		BookCollect tempBookCollect = bookCollectService.getByUserIdAndBookId(bookCollect.getBookId(),
				bookCollect.getUserId());
		if (tempBookCollect != null) {
			map.put("success", true);
			map.put("isFavorite", true);
			map.put("id", tempBookCollect.getId());
		} else {
			map.put("success", true);
			map.put("isFavorite", false);
		}
		return map;
	}

	/**
	 * 通过userid得到bookCollect的List集合
	 * 
	 * @param userId 用户id
	 * @return
	 */
	@GetMapping("/getListByUserId")
	public Map<String, Object> getListByUserId(int pageNum, @RequestHeader("sessionId") String sessionId) {
		Integer userId = userRedis.getUserId(sessionId);
		
		map.put("success", true);
		map.put("pageInfo", bookCollectService.getListByUserId(pageNum, userId));
		return map;
	}

	/**
	 * 通过收藏id:collectId得到bookCollect
	 * 
	 * @param collectId 收藏记录编号id
	 * @return
	 */
	@GetMapping("/get/{collectId}")
	public Map<String, Object> get(@PathVariable Integer collectId) {
		map.put("success", true);
		map.put("bookCollect", bookCollectService.getByCollectId(collectId));
		return map;
	}

}
