package com.valentinalee.bms.bll;

import java.util.List;

import java.util.Map;

import com.valentinalee.bms.vo.BookVO;

/**
 * 图书相关业务接口
 * @author valentinalee
 *
 */
public interface BookService {
	
	public BookVO getBookById(String id) throws Exception;

	/**
	 * 添加图书
	 * @param vo 图书对象
	 * @return 对象
	 * @throws Exception
	 */
	BookVO addBook(BookVO vo) throws Exception;
	
	/**
	 * 删除图书
	 * @param id
	 * @return
	 */
	int deleteBook(String... ids) throws Exception;
	
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

	/**
	 * 修改图书信息
	 * @param id
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public void updateBookById(String id,BookVO vo) throws Exception;
}
