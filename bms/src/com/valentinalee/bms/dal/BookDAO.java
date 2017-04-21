package com.valentinalee.bms.dal;

import java.sql.SQLException;

import java.util.List;
import java.util.Map;

import com.valentinalee.bms.vo.BookVO;

/**
 * 提供图书对象的数据访问
 * @author valentinalee
 *
 */
public interface BookDAO {
	
	/**
	 * 根据id得到图书对象
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	BookVO getById(String id)throws SQLException;
	
	/**
	 * 根据isbn得到图书对象
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	BookVO getByISBN(String isbn)throws SQLException;
	
	/**
	 * 验证图书ISBN号是否存在
	 * @param isbn 图书ISBN号
	 * @return 
	 * @throws SQLException
	 */
	boolean isExsitISBN(String isbn)throws SQLException;

	/**
	 * 添加图书
	 * @param vo 图书对象
	 * @return 对象
	 * @throws Exception
	 */
	BookVO addBook(BookVO vo) throws Exception;
	
	/**
	 * 修改图书信息
	 * @param student 图书对象
	 */
	void update(BookVO vo) throws SQLException ;
	
	/**
	 * 删除图书
	 * @param id
	 * @return
	 */
	int deleteBook(String id) throws Exception;
	
	/**
	 * 通过关键字查询图书数据
	 * @param fieldsMap 查询条件
	 * @param pageSize 每页大小
	 * @param pageNo 页码
	 * @param pageData 分页数据
	 * @return 总记录数
	 * @throws Exception
	 */
	int queryBookByKey(Map<String,Object> fieldsMap, int pageSize, int pageNo,List<BookVO> pageData) throws Exception;
}

