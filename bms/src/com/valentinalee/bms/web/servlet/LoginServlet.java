package com.valentinalee.bms.web.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.valentinalee.bms.bll.ManagerService;
import com.valentinalee.bms.bll.impl.ManagerServiceImpl;
import com.valentinalee.bms.exception.ThisAppException;
import com.valentinalee.bms.util.ThisAppUtil;
import com.valentinalee.bms.vo.ManagerVO;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
			//设置tomcat解析请求参数的字符编码,只能处理post请求
			req.setCharacterEncoding("utf-8");
			//1 获取请求参数
			String account=req.getParameter("account");
			String password=req.getParameter("password");
			//2 验证参数
			if(ThisAppUtil.isNone(account)){
				throw new ThisAppException("账号不能为空");
			}
			if(ThisAppUtil.isNone(password)){
				throw new ThisAppException("密码不能为空");
			}
			
			//3 调用业务对象的方法来处理请求
			ManagerService service=new ManagerServiceImpl();
			ManagerVO vo=service.login(account.trim(), password.trim());
			//4 把业务层返回的对象展示给用户  进行页面跳转
			req.getSession().setAttribute("currentManager", vo);
			req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
			return;
		}catch(ThisAppException e){
			req.setAttribute("message", e.getMessage());
		}catch(Exception e){
			req.setAttribute("message", "网络繁忙,请稍候再试");
		}
		
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
}
