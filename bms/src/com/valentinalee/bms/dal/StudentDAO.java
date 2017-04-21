package com.valentinalee.bms.dal;

import java.sql.SQLException;

import java.util.List;

import com.valentinalee.bms.vo.StudentVO;

/**
 * 提供学生对象的数据访问
 * @author valentinalee
 *
 */
public interface StudentDAO {
	
	/**
	 * 根据id得到学生对象
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	StudentVO getById(String id)throws SQLException;
	/**
	 * 验证学号是否存在
	 * @param no 学号
	 * @return 是否存在
	 * @throws SQLException
	 */
	boolean isExsitNo(String no)throws SQLException;

	/**
	 * 添加学生
	 * @param students
	 * @return
	 */
	StudentVO add(StudentVO vo) throws SQLException;
	
	/**
	 * 得到最大学号no
	 * @return
	 * @throws SQLException
	 */
	int getMaxNo() throws SQLException;
	
	/**
	 * 删除学生
	 * @param id
	 * @return
	 */
	int deleteById(String id) throws SQLException;
	
	/**
	 * 修改学生信息
	 * @param student 学生对象
	 */
	void update(StudentVO vo) throws SQLException ;
	
	/**
	 * 通过条件查询学生数据 
	 * @param key 条件
	 * @param pageSize 每页大小
	 * @param pageNo 页码
	 * @param pageData 分页数据
	 * @return 总记录数
	 * @throws Exception 
	 */
	int queryByKey(String key,int pageSize,int pageNo,List<StudentVO> pageData) throws Exception;
}
