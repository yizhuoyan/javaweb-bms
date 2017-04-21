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

public class AddBookServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
			req.setCharacterEncoding("utf-8");
			BookVO vo=new BookVO();
			req.setAttribute("vo", vo);
			String name=ValidateUtil.throwIfNone(req.getParameter("name"),"书名不能为空");
			vo.setName(name);
			req.setAttribute("name", name);
			String isbn=req.getParameter("isbn");
			if(ThisAppUtil.isNone(isbn)){
				vo.setISBN(isbn);
			}
			String author=req.getParameter("author");
			if(ThisAppUtil.isNone(author)){
				vo.setAuthor(author);
			}
			String publisher=req.getParameter("publisher");
			if(ThisAppUtil.isNone(publisher)){
				vo.setPublisher(publisher);
			}
			String type=req.getParameter("type");
			if(ThisAppUtil.isNone(type)){
				vo.setBookType(type);
			}
			String price=req.getParameter("price");
			if(ThisAppUtil.isNone(price)){
				vo.setPrice(Double.parseDouble(price));
			}
			String storeAmount=req.getParameter("storeAmount");
			if(ThisAppUtil.isNone(storeAmount)){
				vo.setStoreAmount(Integer.parseInt(storeAmount));
			}
			String leftAmount=req.getParameter("leftAmount");
			if(ThisAppUtil.isNone(leftAmount)){
				vo.setLeftAmount(Integer.parseInt(leftAmount));
			}
			
			BookService service=new BookServiceImpl();
			service.addBook(vo);
			
			
			req.getRequestDispatcher("/book/query.do").forward(req, resp);
			return;
		}catch(ThisAppException e){
			req.setAttribute("message", e.getMessage());
		}catch(Exception e){
			req.setAttribute("message", "网络繁忙,请稍候再试");
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("/jsp/book/add.jsp").forward(req, resp);
	}
}

