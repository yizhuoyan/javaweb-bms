package com.valentinalee.bms.web.servlet.borrow;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.valentinalee.bms.bll.BorrowService;
import com.valentinalee.bms.bll.impl.BorrowServiceImpl;
import com.valentinalee.bms.exception.ThisAppException;
import com.valentinalee.bms.vo.ManagerVO;

public class AddServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
			req.setCharacterEncoding("utf-8");
			String[] isbns=req.getParameterValues("isbn");
			String studentId=req.getParameter("studentId");
			ManagerVO managerVO=(ManagerVO) req.getSession().getAttribute("currentManager");
			BorrowService borrowService=new BorrowServiceImpl();
			borrowService.registerBorrow(studentId, managerVO, isbns);
			req.setAttribute("isbns", isbns);
		}catch(ThisAppException e){
			req.setAttribute("message", e.getMessage());
		}catch(Exception e){
			req.setAttribute("message", "网络繁忙,请稍候再试");
			e.printStackTrace();
		}
	}
}
