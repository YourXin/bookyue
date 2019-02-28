package com.bookyue.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookyue.model.JSONResult;

/**
 * 统一的异常处理类
 * @author bigOrang
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

//	@ExceptionHandler(value = Exception.class)
//	@ResponseBody
//	private Map<String, Object> exceptionHandler(Exception e) {
//
//		Map<String, Object> modelMap = new HashMap<String, Object>();
//		modelMap.put("success", false);
//		modelMap.put("message", e.getMessage());
//		modelMap.put("errMsg", e.getMessage());
//		return modelMap;
//	}
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	private JSONResult exceptionHandler(Exception e) {
		return JSONResult.errorMsg(e.getMessage());
	}
}
