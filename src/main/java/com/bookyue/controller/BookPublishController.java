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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookyue.mapper.UserRedis;
import com.bookyue.model.BookPublish;
import com.bookyue.service.BookPublishSerivce;
import com.bookyue.util.CheckContent;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 书籍信息
 * 
 * @author bigOrang
 *
 */
@RestController
@RequestMapping(value = "/book")
@EnableSwagger2
public class BookPublishController {

	private static Logger logger = LoggerFactory.getLogger(BookPublishController.class);

	@Autowired
	private BookPublishSerivce bookPublishService;

	@Autowired
	private UserRedis userRedis;
	
	@Autowired
	private CheckContent checkContet;
	
	
	private Map<String, Object> map = new HashMap<String, Object>();

	/**
	 * 添加一个发布书籍的记录
	 * 
	 * @param bookPublish
	 * @return
	 */
	@PostMapping("/save")
	@ApiOperation("发布新书籍信息")
	public Map<String, Object> addBookPublish(@RequestBody BookPublish bookPublish,
			@RequestHeader("sessionId") String sessionId) {
		logger.debug("addBookPublish()...");
		logger.debug("bookPublish:" + bookPublish.toString());
		logger.debug("sessionId:" + sessionId);
		logger.debug("userRedis:" + userRedis + "");
		logger.debug(userRedis.getUserId(sessionId).toString());
		
		if(checkContet.isSafe(bookPublish.getBookDesc())) {
			bookPublish.setUserId(userRedis.getUserId(sessionId));
			logger.debug(bookPublish.toString());
			map.put("success", bookPublishService.addBookPublish(bookPublish));
			
		}else {
			map.put("success", false);
			map.put("errCode", 1);
			map.put("errMsg", "含有敏感内容");
		}
		
		return map;
	}

	/**
	 * 无条件分页查询所有的list数据
	 * 使用public Map<String, Object> getBookPublishList(int pageNum, BookPublish bookPublish)
	 * bookPublish
	 * @param page
	 *            目标页
	 * @return
	 */
	// @GetMapping("/getBookPublishList")
	// public Map<String, Object> getBookPublishList(int pageNum) {
	// Map<String, Object> map = new HashMap<String, Object>();
	// map.put("pageInfo", bookPublishService.getBookPublishList(pageNum, null));
	// return map;
	// }

	/**
	 * 带条件的分页查询list数据
	 * 
	 * @param pageNum
	 * @param bookPublish
	 * @return
	 */
	// @GetMapping("/getBookPublishList")
	// public Map<String, Object> getBookPublishList(int pageNum, BookPublish
	// bookPublish) {
	// System.out.println(bookPublish);
	// Map<String, Object> map = new HashMap<String, Object>();
	// map.put("pageInfo", bookPublishService.getBookPublishList(pageNum,
	// bookPublish));
	// return map;
	// }
	@GetMapping("/getMyBookPublishList")
	public Map<String, Object> getMyBookPublishList(int pageNum, BookPublish bookPublish,@RequestHeader("sessionId") String sessionId) {
		Map<String, Object> map = new HashMap<String, Object>();
		bookPublish.setUserId(userRedis.getUserId(sessionId));
		map.put("pageInfo", bookPublishService.getMyBookPublishList(pageNum, bookPublish));
		return map;
	}

	/**
	 * 根据bookTypeId，书籍类型,搜索关键字来进行搜索查询
	 * @param pageNum
	 * @param bookTypeId
	 * @param keyword
	 * @return
	 */
	@GetMapping("/search")
	@ApiOperation("根据bookTypeId，书籍类型,搜索关键字来进行搜索查询")
	public Map<String, Object> getBookPublishList(int pageNum, Byte bookTypeId, String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageInfo", bookPublishService.getBookPublishCustomList(pageNum, bookTypeId, keyword));
		return map;
	}

	/**
	 * 通过已发布的书籍记录的bookId来获取对应的BookPublish对象
	 * 
	 * @param bookId
	 * @return
	 */
	@GetMapping("/{bookId}")
	@ApiOperation("通过已发布的书籍记录的bookId来获取对应的BookPublish对象")
	public Map<String, Object> getBookPublishByBookId(@PathVariable("bookId") Integer bookId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bookPublish", bookPublishService.getByBookId(bookId));
		return map;
	}
	
	@GetMapping("/get2/{bookId}")
	@ApiOperation("通过已发布的书籍记录的bookId来获取对应的BookPublishCustom对象")
	public Map<String, Object> getFullBookPublishByBookId(@PathVariable("bookId") Integer bookId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bookPublishCustom", bookPublishService.getBookPublishCustomByBookId(bookId));
		return map;
	}
	
	
	// http://localhost:8080//book/searchBookPublishCustomList?pageNum=1&bookTypeId=2
	/**
	 * 根据关键字和书籍分类Id查询List<br>
	 * 结果包含了用户的头像、用户名、性别数据
	 * @param pageNum
	 * @param bookTypeId
	 * @param keyword
	 * @return
	 */
	@GetMapping("/searchBookPublishCustomList")
	@ApiOperation("根据关键字和书籍分类Id查询List,结果包含了用户的头像、用户名、性别数据")
	public Map<String, Object> getBookPublishCustomList(int pageNum, Byte bookTypeId, String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageInfo", bookPublishService.getBookPublishCustomList(pageNum, bookTypeId, keyword));
		return map;
	}

	/**
	 * 通过userId和bookId删除记录
	 * @param userId
	 * @param bookId
	 * @return
	 */
	@DeleteMapping("/delete")
	@ApiOperation(" 通过userId和bookId删除记录")
	public Map<String, Object> deleteByUserIdAndBookId(@RequestBody BookPublish bookPublish, @RequestHeader("sessionId") String sessionId) {
		
		bookPublish.setUserId(userRedis.getUserId(sessionId));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", bookPublishService.deleteBookPublish(bookPublish.getUserId(), bookPublish.getBookId()));
		return map;
	}

	@GetMapping("/getByUserIdAndBookId")
	@ApiOperation("")
	public Map<String, Object> getByUserIdAndBookId(Integer bookId, @RequestHeader("sessionId") String sessionId) {
		Integer userId = userRedis.getUserId(sessionId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		BookPublish bookPublish = bookPublishService.getByBookIdAndUserId(bookId, userId);
		if (bookPublish != null) {
			map.put("success", true);
			map.put("bookPublish", bookPublish);
		} else {
			map.put("success", false);
		}
		return map;
	}

	/**
	 * 修改更新数据
	 * @param bookPublish
	 * @return
	 */
	@PutMapping("/update")
	@ApiOperation("更新书籍数据")
	public Map<String, Object> update(@RequestBody BookPublish bookPublish, @RequestHeader("sessionId") String sessionId) {
		bookPublish.setUserId(userRedis.getUserId(sessionId));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", bookPublishService.updateBookPublish(bookPublish));
		map.put("bookPublish", bookPublish);
		return map;
	}
	
}
