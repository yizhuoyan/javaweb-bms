package com.valentinalee.bms.web.servlet.student;


import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.valentinalee.bms.bll.StudentService;
import com.valentinalee.bms.bll.impl.StudentServiceImpl;
import com.valentinalee.bms.exception.ThisAppException;
import com.valentinalee.bms.util.ValidateUtil;

public class DeleteStudentServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
			req.setCharacterEncoding("utf-8");
			String[] ids=req.getParameterValues("studentId");
			if(ids==null||ids.length==0){
				throw new ThisAppException("未选择任何学生");
			}
			StudentService service=new StudentServiceImpl();
			int n=service.deleteStudentById(ids);
			req.setAttribute("message", "已成功删除"+n+"个学生记录");
		}catch(ThisAppException e){
			req.setAttribute("message", e.getMessage());
		}catch(Exception e){
			req.setAttribute("message", "网络繁忙,请稍候再试");
			e.printStackTrace();
		}
		req.getRequestDispatcher("/student/query.do").forward(req, resp);
	}
}
