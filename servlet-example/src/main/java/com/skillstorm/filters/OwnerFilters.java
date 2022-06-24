package com.skillstorm.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// needs this tio know it's a filter
@WebFilter(urlPatterns = "/api/owners")
public class OwnerFilters implements Filter {

	//these methods are the same as your servlet lifecycle methods
	@Override
	public void destroy() {
		System.out.println("Filter destroyed");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Filter filtering");
		// initialised first, called first, last to be destroyed
		
		//could potentially add a header, or check security here
		HttpServletResponse resp = (HttpServletResponse) response;
		resp.addHeader("Access-Control-Allow-Origin", "SomeOrigin");
		
		// holds on to the request it intercepts until we tell it otherwise
		// this forwards it along the chain
		chain.doFilter(request, resp);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter created");
	}

}
