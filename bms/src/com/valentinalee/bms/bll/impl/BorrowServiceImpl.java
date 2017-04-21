package com.valentinalee.bms.bll.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.valentinalee.bms.bll.BorrowService;
import com.valentinalee.bms.bll.StudentService;
import com.valentinalee.bms.dal.BookDAO;
import com.valentinalee.bms.dal.BorrowDAO;
import com.valentinalee.bms.dal.StudentDAO;
import com.valentinalee.bms.dal.impl.BookDAOImpl;
import com.valentinalee.bms.dal.impl.BorrowDAOImpl;
import com.valentinalee.bms.dal.impl.StudentDAOImpl;
import com.valentinalee.bms.exception.ThisAppException;
import com.valentinalee.bms.vo.BookVO;
import com.valentinalee.bms.vo.BorrowVO;
import com.valentinalee.bms.vo.ManagerVO;
import com.valentinalee.bms.vo.StudentVO;

public class BorrowServiceImpl implements BorrowService {
	
	public int queryAllBorrowNoGiveBack(int pageSize, int pageNo,List<BorrowVO> pageData) throws Exception{
		BorrowDAO borrowDAO=new BorrowDAOImpl();
		return borrowDAO.queryAllBorrowNoGiveBack(pageSize, pageNo, pageData);
	}
	
	public List<BorrowVO> queryStudentNoGiveBackBooksPageData(String studentId)
			throws Exception {
		BorrowDAO borrowDAO=new BorrowDAOImpl();
		return borrowDAO.queryStudentNoGiveBackBooksPageData(studentId);
	}
	
	public int queryStudentNoGiveBackBooks(String studentId) throws Exception {
		BorrowDAO borrowDAO=new BorrowDAOImpl();
		return borrowDAO.queryStudentNoGiveBackBooks(studentId);
	}
	
	public int queryStudentByKey(String key, int pageSize, int pageNo,
			List<StudentVO> pageData) throws Exception {
		// 参数验证
		// 查询总记录数
		StudentDAO dao = new StudentDAOImpl();
		return dao.queryByKey(key, pageSize, pageNo, pageData);
	}

	public void registerBorrow(String studentId, ManagerVO managerVO,
			String... isbns) throws Exception {
		StudentService studentService=new StudentServiceImpl();
		StudentVO studentVO=studentService.getStudentById(studentId);
		if(studentVO==null){
			throw new ThisAppException("学生不存在");
		}
		BorrowDAO borrowDAO=new BorrowDAOImpl();
		BookDAO bookDAO=new BookDAOImpl();
		for (String isbn : isbns) {
			BookVO book=bookDAO.getByISBN(isbn);
			if(book==null){
				throw new ThisAppException("book不存在");
			}
			BorrowVO borrowVO=new BorrowVO();
			borrowVO.setBook(book);
			borrowVO.setBorrowDay(7);
			borrowVO.setBorrowOutManager(managerVO);
			borrowVO.setBorrowOutTime(new Date());
			Calendar cal = Calendar.getInstance();
			cal.setTime(borrowVO.getBorrowOutTime());
			cal.add(Calendar.DAY_OF_YEAR, 7);
			borrowVO.setMustGiveBackTime(cal.getTime());
			borrowVO.setStudent(studentVO);
			borrowDAO.addBorrow(borrowVO);
		}
	}
}
