package com.valentinalee.bms.web.servlet.borrow;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.valentinalee.bms.bll.BorrowService;
import com.valentinalee.bms.bll.impl.BorrowServiceImpl;
import com.valentinalee.bms.exception.ThisAppException;
import com.valentinalee.bms.vo.BorrowVO;

public class QueryStudentNoGiveBackServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
			req.setCharacterEncoding("utf-8");
			String studentId=req.getParameter("studentId");
			BorrowService borrowService=new BorrowServiceImpl();
			List<BorrowVO> borrowVOs=borrowService.queryStudentNoGiveBackBooksPageData(studentId);
			//学生目前还能借多少本
			int noGiveBackBooksAmount=borrowService.queryStudentNoGiveBackBooks(studentId);
			req.setAttribute("noGiveBackBooksAmount", noGiveBackBooksAmount);
			req.setAttribute("borrowVOs", borrowVOs);
		}catch(ThisAppException e){
			req.setAttribute("message", e.getMessage());
		}catch(Exception e){
			req.setAttribute("message", "网络繁忙,请稍候再试");
			e.printStackTrace();
		}
		req.getRequestDispatcher("/jsp/borrow/add2.jsp").forward(req, resp);
	}
}
