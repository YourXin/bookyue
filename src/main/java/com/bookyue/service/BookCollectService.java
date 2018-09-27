package com.bookyue.service;

import java.util.List;

import com.bookyue.model.BookCollect;
import com.bookyue.model.BookCollectCustom;
import com.github.pagehelper.PageInfo;

public interface BookCollectService {
	
	/**
	 * 添加收藏记录
	 * 
	 * @param bookCollect
	 * @return
	 */
	boolean addBookCollect(BookCollect bookCollect);

	/**
	 * 通过id和userId来删除记录
	 * @param userId 用户id
	 * @param id 收藏记录id
	 * @return
	 */
	boolean deleteBookCollect(Integer id, Integer userId);
	
	
	boolean deleteBookCollectByBookIdAndUserId(Integer bookId, Integer userId);

	/**
	 * 通过bookId和userId来判断是否已被收藏
	 * 
	 * @param bookCollect
	 * @return
	 */
	boolean isExist(Integer userId, Integer bookId);
	
	
	BookCollect getByUserIdAndBookId(Integer bookId,Integer userId);
	

	/**
	 * 通过收藏记录的id来获取一个BookCollect
	 * 
	 * @param colectId
	 * @return
	 */
	BookCollect getByCollectId(Integer colectId);

	/**
	 * 根据userId来得到该用户
	 * 所有的收藏书籍记录
	 * 
	 * @param userId
	 * @return
	 */
	List<BookCollectCustom> getListByUserId(Integer userId);

	/**
	 * 根据userId来得到该用户
	 * 所有的收藏书籍记录-分页
	 * @param pageNum
	 * @param userId
	 * @return PageInfo<BookCollectCustom>
	 */
	PageInfo<BookCollectCustom> getListByUserId(int pageNum, Integer userId);

}
