package com.acme.web;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.acme.web.domain.Page;
import com.acme.web.domain.Visit;
import com.acme.web.domain.PageVisited;
import com.acme.web.domain.Visitor;
import com.acme.web.service.CustomRepositoryService;
import com.acme.web.service.SpringDataRepositoryService;

@Controller
public class TrackingFilter implements Filter {
	private static final int cookieAgeInSeconds = 10000000;

	private static final String ROOT_URL = "web/";
	private static final String VISITOR = "VISITOR";
	private static final String VISIT = "VISIT";
	
	@Autowired
	CustomRepositoryService repositoryService;
	@Autowired
	SpringDataRepositoryService springDataRepositoryService;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest  httprequest = (HttpServletRequest)  request;
		HttpServletResponse  httpresponse = (HttpServletResponse) response;
		HttpSession  session = httprequest.getSession();
		Visitor visitor = (Visitor) session.getAttribute(VISITOR);
		Long currentMili = System.currentTimeMillis();
		if(visitor == null) {
			session.setAttribute(VISITOR, visitor);
			String visitorIdStrValue = null;
			Long visitorId = null;
			Cookie[] cookies = httprequest.getCookies();
			boolean createNewVisitor = true;
			if(cookies != null && cookies.length > 0) {
				Cookie cookie;
				for(int i=0;i<cookies.length;i++) {
					cookie = cookies[i];
					if("id".equalsIgnoreCase(cookie.getName())) {
						visitorIdStrValue = cookie.getValue();
						break;
					}
				}
				if(visitorIdStrValue != null) {
					if(visitorIdStrValue.length() > 0) {
						visitorId = Long.valueOf(visitorIdStrValue);
						visitor = repositoryService.find(Visitor.class, visitorId);
						if(visitor != null) {
							createNewVisitor = false;
						}
					}
				}
			} 
			if(createNewVisitor) {
				visitor = new Visitor();
				repositoryService.persist(visitor);
				Cookie cookie = new Cookie("id", visitor.getId().toString());
				cookie.setMaxAge(cookieAgeInSeconds);
				httpresponse.addCookie(cookie);
			}
		}
		Visit visit = (Visit) session.getAttribute(VISIT);
		if(visit == null) {
			visit = createVisit(visitor);
			repositoryService.persist(visit);
			session.setAttribute(VISIT, visit);
		}
		PageVisited pageVisited = createPageVisited(visit, httprequest.getRequestURI());
		repositoryService.persist(pageVisited);
		
		chain.doFilter(request, response);		
	}
	
	private Visit createVisit(Visitor visitor) {
		Long currentMili = System.currentTimeMillis();
		Visit visit = new Visit();
		visit.setVisitor(visitor);
		visit.setStartDateTime(new Timestamp(currentMili));
		
		return visit;
	}
	
	private PageVisited createPageVisited(Visit visit, String requestURL) {
		Long currentMili = System.currentTimeMillis();
		PageVisited pageVisited = new PageVisited();
		pageVisited.setVisit(visit);
		visit.setStartDateTime(new Timestamp(currentMili));
		
		String name = null;
		if(requestURL != null) {
			int index = requestURL.indexOf(ROOT_URL);
			if(index >=0) {
				name = requestURL.substring(index + ROOT_URL.length(), requestURL.length());
			}
		}
		if(name == null || name.trim().length() == 0) {
			name = "root";
		}
		Page page = springDataRepositoryService.findPageByName(name);
		if(page == null) {
			page = new Page();
			page.setName(name);
			repositoryService.persist(page);
		}
		pageVisited.setPage(page);
		
		return pageVisited;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub		
	}

}
