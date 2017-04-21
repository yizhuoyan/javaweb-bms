package com.valentinalee.bms.web.servlet.borrow;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.valentinalee.bms.bll.StudentService;
import com.valentinalee.bms.bll.impl.StudentServiceImpl;
import com.valentinalee.bms.exception.ThisAppException;
import com.valentinalee.bms.util.ThisAppUtil;
import com.valentinalee.bms.vo.StudentVO;

public class QueryStudentServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
			req.setCharacterEncoding("utf-8");
			String key=req.getParameter("key");
			String pageSizeStr=req.getParameter("pageSize");
			if(ThisAppUtil.isNone(pageSizeStr)){
				pageSizeStr="10";
			}
			int pageSize=Integer.parseInt(pageSizeStr);
			String pageNoStr=req.getParameter("pageNo");
			if(ThisAppUtil.isNone(pageNoStr)){
				pageNoStr="1";
			}
			int pageNo=Integer.parseInt(pageNoStr);
			StudentService service=new StudentServiceImpl();
			List<StudentVO> pageData=new ArrayList<StudentVO>(pageSize);
			int totalCount=service.queryStudentByKey(key, pageSize, pageNo, pageData);
			req.setAttribute("key", key);
			req.setAttribute("pageSize", pageSize);
			req.setAttribute("currentPageNo", pageNo);
			req.setAttribute("pageData", pageData);
			int totalNo=totalCount/pageSize;
			if(totalCount%pageSize!=0){
				totalNo++;
		}
		req.setAttribute("totalNo", totalNo);
	}catch(ThisAppException e){
		req.setAttribute("message", e.getMessage());
	}catch(Exception e){
		req.setAttribute("message", "网络繁忙,请稍候再试");
		e.printStackTrace();
	}
		req.getRequestDispatcher("/jsp/borrow/add1.jsp").forward(req, resp);
	}
}
