package com.valentinalee.bms.web.servlet.book;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.valentinalee.bms.bll.BookService;
import com.valentinalee.bms.bll.StudentService;
import com.valentinalee.bms.bll.impl.BookServiceImpl;
import com.valentinalee.bms.bll.impl.StudentServiceImpl;
import com.valentinalee.bms.exception.ThisAppException;

public class DeleteBookServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
			req.setCharacterEncoding("utf-8");
			String[] ids=req.getParameterValues("bookId");
			if(ids==null||ids.length==0){
				throw new ThisAppException("未选择任何学生");
			}
			BookService service=new BookServiceImpl();
			int n=service.deleteBook(ids);
			req.setAttribute("message", "已成功删除"+n+"本图书");
		}catch(ThisAppException e){
			req.setAttribute("message", e.getMessage());
		}catch(Exception e){
			req.setAttribute("message", "网络繁忙,请稍候再试");
			e.printStackTrace();
		}
		req.getRequestDispatcher("/book/query.do").forward(req, resp);
	}
}
