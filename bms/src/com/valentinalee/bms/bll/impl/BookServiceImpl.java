package com.valentinalee.bms.bll.impl;


import java.util.List;
import java.util.Map;

import com.valentinalee.bms.bll.BookService;
import com.valentinalee.bms.dal.BookDAO;
import com.valentinalee.bms.dal.impl.BookDAOImpl;
import com.valentinalee.bms.exception.ThisAppException;
import com.valentinalee.bms.vo.BookVO;

public class BookServiceImpl implements BookService {

	public BookVO addBook(BookVO vo) throws Exception {
		BookDAO dao=new BookDAOImpl();
		if(dao.isExsitISBN(vo.getISBN())){
			throw new ThisAppException("ISBN号[" + vo.getISBN() + "]已存在!");
		}
		return dao.addBook(vo);
	}

	public int deleteBook(String... ids) throws Exception{
		BookDAO dao=new BookDAOImpl();
		int deleted=0;
		for (int i = 0; i < ids.length; i++) {
			deleted+=dao.deleteBook(ids[i]);
		}
		return deleted;
	}

	public int queryBookByKey(Map<String, Object> fieldsMap, int pageSize,
			int pageNo, List<BookVO> pageData) throws Exception {
		BookDAO dao=new BookDAOImpl();
		return dao.queryBookByKey(fieldsMap, pageSize, pageNo, pageData);
	}

	public BookVO getBookById(String id) throws Exception {
		BookDAO dao = new BookDAOImpl();
		return dao.getById(id);
	}

	public void updateBookById(String id, BookVO vo) throws Exception {
		BookDAO dao = new BookDAOImpl();
		BookVO oldVo = dao.getById(id);
		if (oldVo == null) {
			throw new ThisAppException("图书已被删除或不存在");
		}
		String oldISBN=oldVo.getISBN();
		if (oldISBN!=null&&!oldISBN.equals(vo.getISBN())) {
			if (dao.isExsitISBN(vo.getISBN())) { // 判断图书ISBN号是否存在
				throw new ThisAppException("图书ISBN号[" + vo.getISBN() + "]已存在!");
			}
			
		}
		vo.setId(id);
		// 保存
		dao.update(vo);
	}
	
	public static void main(String[] args) throws Exception {
		while (true) {
			System.out.println("BookServiceImpl.main()");
		}
	}

}
