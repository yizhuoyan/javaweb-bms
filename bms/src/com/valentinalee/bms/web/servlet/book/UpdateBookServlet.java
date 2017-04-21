package com.valentinalee.bms.web.servlet.book;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.valentinalee.bms.bll.BookService;
import com.valentinalee.bms.bll.impl.BookServiceImpl;
import com.valentinalee.bms.exception.ThisAppException;
import com.valentinalee.bms.util.ThisAppUtil;
import com.valentinalee.bms.util.ValidateUtil;
import com.valentinalee.bms.vo.BookVO;


public class UpdateBookServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
			req.setCharacterEncoding("utf-8");
			String id=ValidateUtil.throwIfNone(req.getParameter("id"),"id不能为空");
			BookVO vo=new BookVO();
			String name=ValidateUtil.throwIfNone(req.getParameter("name"),"图书名不能为空");
			vo.setName(name);
			String isbn=req.getParameter("isbn");
				vo.setISBN(isbn);
			String author=req.getParameter("author");
				vo.setAuthor(author);
			String publisher=req.getParameter("publisher");
				vo.setPublisher(publisher);
			String bookType=req.getParameter("bookType");
				vo.setBookType(bookType);
			String priceStr=req.getParameter("price");
			if(ThisAppUtil.isNone(priceStr)){
				priceStr="0";
			}
			double price=0;
			try{
				price=Double.parseDouble(priceStr);
			}catch(Exception e){
				throw new ThisAppException("价格字段必须是数字");
			}
			vo.setPrice(price);
			
			String storeAmount=req.getParameter("storeAmount");
			if(!ThisAppUtil.isNone(storeAmount)){
				vo.setStoreAmount(Integer.parseInt(storeAmount));
			}
			String leftAmount =req.getParameter("leftAmount");
			if(!ThisAppUtil.isNone(leftAmount)){
				vo.setLeftAmount(Integer.parseInt(leftAmount));
			}
			//调用业务层方法来处理请求
			BookService service=new BookServiceImpl();
			service.updateBookById(id, vo);
			req.setAttribute("message", "修改成功");
			resp.sendRedirect(getServletContext().getContextPath()+"/book/query.do");
			return;
		}catch(ThisAppException e){
			req.setAttribute("message", e.getMessage());
		}catch(Exception e){
			req.setAttribute("message", "网络繁忙,请稍候再试");
			e.printStackTrace();
		}
		req.getRequestDispatcher("/book/show.do").forward(req, resp);
	}
}
