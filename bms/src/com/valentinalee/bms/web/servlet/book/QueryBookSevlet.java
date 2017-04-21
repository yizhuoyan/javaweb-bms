package com.valentinalee.bms.web.servlet.book;


import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.valentinalee.bms.bll.BookService;
import com.valentinalee.bms.bll.impl.BookServiceImpl;
import com.valentinalee.bms.exception.ThisAppException;
import com.valentinalee.bms.util.ThisAppUtil;
import com.valentinalee.bms.vo.BookVO;

public class QueryBookSevlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
			req.setCharacterEncoding("utf-8");
			String name=req.getParameter("name");
			String isbn=req.getParameter("isbn");
			String author=req.getParameter("author");
			String publisher=req.getParameter("publisher");
			String minStoreAmountStr=req.getParameter("minStoreAmount");
			
			String[] checkedTypes=req.getParameterValues("checkedTypes");
			BookService service=new BookServiceImpl();
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
			List<BookVO> pageData=new ArrayList<BookVO>(pageSize);
			Map<String, Object> map=new HashMap<String, Object>();
			if(!ThisAppUtil.isNone(minStoreAmountStr)){
				int minStoreAmount=Integer.parseInt(minStoreAmountStr);
				map.put("minStoreAmount", minStoreAmount);
				req.setAttribute("minStoreAmount", minStoreAmount);
			}
			String maxStoreAmountStr=req.getParameter("maxStoreAmount");
			if(!ThisAppUtil.isNone(maxStoreAmountStr)){
				int maxStoreAmount=Integer.parseInt(maxStoreAmountStr);
				map.put("maxStoreAmount", maxStoreAmount);
				req.setAttribute("maxStoreAmount", maxStoreAmount);
			}
			map.put("name", name);
			map.put("isbn", isbn);
			map.put("author", author);
			map.put("publisher", publisher);
			map.put("checkedTypes", checkedTypes);
			int totalCount=service.queryBookByKey(map, pageSize, pageNo, pageData);
			req.setAttribute("pageData", pageData);
			req.setAttribute("pageSize", pageSize);
			req.setAttribute("currentPageNo", pageNo);
			int totalNo=totalCount/pageSize;
			if(totalCount%pageSize!=0){
				totalNo++;
			}
			req.setAttribute("totalNo", totalNo);
			req.setAttribute("name", name);
			req.setAttribute("isbn", isbn);
			req.setAttribute("author", author);
			req.setAttribute("publisher", publisher);
			req.setAttribute("checkedTypes", checkedTypes);
		}catch(ThisAppException e){
			req.setAttribute("message", e.getMessage());
		}catch(Exception e){
			req.setAttribute("message", "网络繁忙,请稍候再试");
			e.printStackTrace();
		}
		req.getRequestDispatcher("/book/showQuery.do").forward(req, resp);
	}
}
