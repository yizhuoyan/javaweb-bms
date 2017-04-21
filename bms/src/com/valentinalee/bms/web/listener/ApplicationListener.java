package com.valentinalee.bms.web.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.valentinalee.bms.bll.PublisherService;
import com.valentinalee.bms.bll.TypeService;
import com.valentinalee.bms.bll.impl.PublisherServiceImpl;
import com.valentinalee.bms.bll.impl.TypeServiceImpl;
import com.valentinalee.bms.vo.PublisherVO;
import com.valentinalee.bms.vo.TypeVO;

public class ApplicationListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent event) {
	}

	public void contextInitialized(ServletContextEvent event) {
		try {
			PublisherService publisherService = new PublisherServiceImpl();
			List<PublisherVO> pulishers = publisherService.queryPublisher();
			TypeService typeService = new TypeServiceImpl();
			List<TypeVO> types = typeService.queryType();
			ServletContext sc = event.getServletContext();
			sc.setAttribute("BOOK-PUBLISHERS", pulishers);
			sc.setAttribute("BOOK-TYPES", types);
		} catch (Exception e) {
				e.printStackTrace();
			// throw new ThisAppException("加载书籍类型发生异常");
		}

	}

}
