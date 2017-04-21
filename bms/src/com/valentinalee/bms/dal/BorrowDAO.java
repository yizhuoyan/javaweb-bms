package com.valentinalee.bms.dal;

import java.util.List;

import com.valentinalee.bms.vo.BorrowVO;

/**
 * 提供借阅的数据访问
 * @author valentinalee
 *
 */
public interface BorrowDAO {

	/**
	 * 新增借阅
	 * @param vo 
	 * @return 
	 * @throws Exception
	 */
	BorrowVO addBorrow(BorrowVO borrowVO) throws Exception;
	
	/**
	 * 根据学生Id得到该生未归还图书记录
	 * @param studentId
	 * @return
	 * @throws Exception
	 */
	List<BorrowVO> queryStudentNoGiveBackBooksPageData(String studentId)throws Exception;
	
	/**
	 * 根据学生Id得到该生为归还图书数量
	 * @param studentId
	 * @return
	 * @throws Exception
	 */
	int queryStudentNoGiveBackBooks(String studentId)throws Exception;

	/**
	 *  查找所有学生借阅未归还信息
	 * @param pageSize
	 * @param pageNo
	 * @param pageData
	 * @return
	 * @throws Exception
	 */
	int queryAllBorrowNoGiveBack(int pageSize, int pageNo,List<BorrowVO> pageData) throws Exception;
}
