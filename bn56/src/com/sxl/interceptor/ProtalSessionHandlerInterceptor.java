package com.sxl.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ProtalSessionHandlerInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	private MessageSource messageSource;	
	

	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		request.setAttribute("site_title", messageSource.getMessage("site_title", null, "", null));
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String url =getRequestUrl(request);
		
//		
		return true;
		
	}
	/**
	 * like "/action!method.action"
	 */
	public String getRequestUrl(HttpServletRequest request)
	{
		String url =request.getRequestURI();
		String path = request.getContextPath();
		if (StringUtils.isNotEmpty(path))
		{
			return url.substring(path.length());
		}
		return url;
	}
		/***
		 * 获取IP（如果是多级代理，则得到的是一串IP值）
		 */
		public static String getIpAddr(HttpServletRequest request) {
			String ip = request.getHeader("x-forwarded-for");
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
			}

			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}

			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
			}

			if (ip != null && ip.length() > 0) {
				String[] ips = ip.split(",");
				for (int i = 0; i < ips.length; i++) {
					if (!"unknown".equalsIgnoreCase(ips[i])) {
						ip = ips[i];
						break;
					}
				}
			}

			return ip;
		}
		

}
