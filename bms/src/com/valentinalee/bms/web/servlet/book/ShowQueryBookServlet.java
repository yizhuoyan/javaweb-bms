package com.valentinalee.bms.web.servlet.book;


import java.io.IOException;



import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.valentinalee.bms.bll.PublisherService;
import com.valentinalee.bms.bll.TypeService;
import com.valentinalee.bms.bll.impl.PublisherServiceImpl;
import com.valentinalee.bms.bll.impl.TypeServiceImpl;
import com.valentinalee.bms.exception.ThisAppException;
import com.valentinalee.bms.vo.PublisherVO;
import com.valentinalee.bms.vo.TypeVO;

public class ShowQueryBookServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
			
		}catch(ThisAppException e){
			req.setAttribute("message", e.getMessage());
		}catch(Exception e){
			req.setAttribute("message", "网络繁忙,请稍候再试");
			e.printStackTrace();
		}
		req.getRequestDispatcher("/jsp/book/queryBook.jsp").forward(req, resp);
	}
}
