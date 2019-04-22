package com.etres.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.etres.ErrorMsg;

public class MyInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object attribute = request.getSession().getAttribute("user");
		if(attribute == null) {
			ErrorMsg errorMsg = new ErrorMsg();
			errorMsg.setMsg("用户名或密码错误");
			errorMsg.setMsgId("1001");
			request.getSession().setAttribute("error", errorMsg);
			request.getRequestDispatcher("/").forward(request, response);
			return false;
		}
		
		return super.preHandle(request, response, handler);
	}
}
