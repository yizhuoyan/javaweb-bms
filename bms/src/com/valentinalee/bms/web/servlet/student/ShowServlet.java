package com.valentinalee.bms.web.servlet.student;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.valentinalee.bms.bll.StudentService;
import com.valentinalee.bms.bll.impl.StudentServiceImpl;
import com.valentinalee.bms.exception.ThisAppException;
import com.valentinalee.bms.util.ValidateUtil;
import com.valentinalee.bms.vo.StudentVO;

public class ShowServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
			req.setCharacterEncoding("utf-8");
			String id=ValidateUtil.throwIfNone(req.getParameter("id"),"id不能为空");
			StudentService service=new StudentServiceImpl();
			StudentVO vo=service.getStudentById(id);
			req.setAttribute("student", vo);
		}catch(ThisAppException e){
			req.setAttribute("message", e.getMessage());
		}catch(Exception e){
			req.setAttribute("message", "网络繁忙,请稍候再试");
			e.printStackTrace();
		}
		req.getRequestDispatcher("/jsp/student/update.jsp").forward(req, resp);
	}
}
