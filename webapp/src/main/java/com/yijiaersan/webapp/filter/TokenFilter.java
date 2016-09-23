package com.yijiaersan.webapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yijiaersan.webapp.model.UserInfo;
import com.yijiaersan.webapp.utils.UserSession;

public class TokenFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpServletRequest = (HttpServletRequest) req;
		HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
		String token = httpServletRequest.getParameter("token");
		UserInfo userInfo = UserSession.get(token,UserInfo.class);
		if(userInfo == null){
			httpServletResponse.sendRedirect("login/login");
		}else{
			chain.doFilter(req, resp);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
