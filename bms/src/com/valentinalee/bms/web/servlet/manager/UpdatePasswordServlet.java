package com.valentinalee.bms.web.servlet.manager;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.valentinalee.bms.dal.ManagerDAO;
import com.valentinalee.bms.dal.impl.ManagerDAOImpl;
import com.valentinalee.bms.exception.ThisAppException;
import com.valentinalee.bms.util.ValidateUtil;

public class UpdatePasswordServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
			req.setCharacterEncoding("utf-8");
			String id=req.getParameter("id");
			String newPassword=ValidateUtil.throwIfNone(req.getParameter("newPassword"), "密码不能为空");
			ManagerDAO dao=new ManagerDAOImpl();
			dao.updatePassword(id, newPassword);
			req.getRequestDispatcher("/student/query.do").forward(req, resp);
		}catch(ThisAppException e){
			req.setAttribute("message", e.getMessage());
		}catch(Exception e){
			req.setAttribute("message", "网络繁忙,请稍候再试");
			e.printStackTrace();
		}
		req.getRequestDispatcher("/jsp/manager/update.jsp").forward(req, resp);
	}
}
