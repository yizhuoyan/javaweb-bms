package com.valentinalee.bms.bll;

import java.util.List;

import com.valentinalee.bms.vo.BorrowVO;
import com.valentinalee.bms.vo.ManagerVO;
import com.valentinalee.bms.vo.StudentVO;

/**
 * 借阅的相关接口
 * @author valentinalee
 *
 */
public interface BorrowService {

	/**
	 * 新增借阅
	 * @param vo 
	 * @return 
	 * @throws Exception
	 */
	void registerBorrow(String studentId,ManagerVO managerVO,String... isbn) throws Exception;
	
	/**
	 * 通过关键字查询学生数据 
	 * @param key 查询关键字
	 * @param pageSize 每页大小
	 * @param pageNo 页码
	 * @param pageData 分页数据
	 * @return 总记录数
	 * @throws Exception 
	 */
	public int queryStudentByKey(String key,int pageSize,int pageNo,List<StudentVO> pageData) throws Exception;
	
	/**
	 * 根据学生Id得到该生为归还图书记录
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
