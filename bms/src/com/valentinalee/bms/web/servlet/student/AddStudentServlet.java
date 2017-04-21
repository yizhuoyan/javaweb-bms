package com.valentinalee.bms.web.servlet.student;


import java.io.IOException;

import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.valentinalee.bms.bll.StudentService;
import com.valentinalee.bms.bll.impl.StudentServiceImpl;
import com.valentinalee.bms.exception.ThisAppException;
import com.valentinalee.bms.util.ThisAppUtil;
import com.valentinalee.bms.util.ValidateUtil;
import com.valentinalee.bms.vo.StudentVO;

public class AddStudentServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
			StudentVO vo=new StudentVO();
			req.setCharacterEncoding("utf-8");
			String no=ValidateUtil.throwIfNone(req.getParameter("no"),"学号不能为空");
			vo.setNo(no);
			String name=ValidateUtil.throwIfNone(req.getParameter("name"),"姓名不能为空");
			vo.setName(name);
			String sex=req.getParameter("sex");
			vo.setSex(sex);
			String enterDayStr=ValidateUtil.throwIfNone(req.getParameter("enterDay"),"入学时间不能为空");
			Date enterDay;
			try{
				enterDay=ThisAppUtil.parseDate(enterDayStr, "yyyy-MM-dd");
				vo.setEnterDay(enterDay);
			}catch(ParseException e){
				throw new ThisAppException("入学时间格式为[yyyy-MM-dd],如:2008-08-08");
			}
			//调用业务层方法来处理请求
			StudentService service=new StudentServiceImpl();
			service.addStudent(vo);
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/student/query.do").forward(req, resp);
			return;
		}catch(ThisAppException e){
			req.setAttribute("message", e.getMessage());
		}catch(Exception e){
			req.setAttribute("message", "网络繁忙,请稍候再试");
			e.printStackTrace();
		}
		req.getRequestDispatcher("/jsp/student/add.jsp").forward(req, resp);
		
	}
}
