package com.bookyue.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class WeiXinRequestInterceptor implements HandlerInterceptor {

	private static  Logger logger = LoggerFactory.getLogger(WeiXinRequestInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("perHandle()...");

		// 简单判断请求是否来自于微信服务器或开发者工具
		// 判断referer是否是微信
		String referer = request.getHeader("referer");
		logger.debug(referer);
		String phoneReferer = "https://servicewechat.com/wx3de14ec4cdd7ef43/0/page-frame.html";
		String devReferer = "https://servicewechat.com/wx3de14ec4cdd7ef43/devtools/page-frame.html";
		if (phoneReferer.equals(referer) || devReferer.equals(referer)) {
			return true;
		}

		response.setStatus(403);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
