package com.neu.ruidaoQA.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class filter01_encoding
 */
@WebFilter(filterName="/filter01_encoding",urlPatterns="/*")
public class filter01_encoding implements Filter {

    /**
     * Default constructor. 
     */
    public filter01_encoding() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//System.out.println("进入了filter01");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");//写在dofilter的前面，保证response响应中文
		//最常用做法，过滤中文字符
		chain.doFilter(request, response);//进入url中的servlet
		//System.out.println("从servlet回来会再次进入过滤器filter01，常用操作是输出日志信息");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
