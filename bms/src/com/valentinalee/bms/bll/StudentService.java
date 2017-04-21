package com.valentinalee.bms.bll;


import java.util.List;

import com.valentinalee.bms.vo.StudentVO;

/**
 * 学生相关业务接口
 * @author valentinalee
 *
 */
public interface StudentService {

	/**
	 * 添加学生
	 * @param vo 学生对象
	 * @return 
	 * @throws Exception
	 */
	public StudentVO addStudent(StudentVO vo) throws Exception;
	
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
	 * 根据id删除学生信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteStudentById(String... ids) throws Exception;
	
	/**
	 * 修改学生信息
	 * @param id
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public void updateStudentById(String id,StudentVO vo) throws Exception;
	
	
	public StudentVO getStudentById(String id) throws Exception;
	
	
}
