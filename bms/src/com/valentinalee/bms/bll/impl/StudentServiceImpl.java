package com.valentinalee.bms.bll.impl;

import java.util.Calendar;
import java.util.List;

import com.valentinalee.bms.bll.StudentService;
import com.valentinalee.bms.dal.StudentDAO;
import com.valentinalee.bms.dal.impl.StudentDAOImpl;
import com.valentinalee.bms.exception.ThisAppException;
import com.valentinalee.bms.vo.StudentVO;

public class StudentServiceImpl implements StudentService {

	public StudentVO addStudent(StudentVO vo) throws Exception {
		//1 验证参数是否合法
		//2 逻辑判断执行--dao
				
		StudentDAO dao = new StudentDAOImpl();
		// 得到学号

		// 计算毕业时间
		Calendar cal = Calendar.getInstance();
		cal.setTime(vo.getEnterDay());
		cal.add(Calendar.YEAR, 3);
		vo.setGraduateDay(cal.getTime());
		if (dao.isExsitNo(vo.getNo())) { // 判断学号是否存在
			throw new ThisAppException("学号[" + vo.getNo() + "]已存在!");
		}
		
		// 保存
		return dao.add(vo);
	}

	public int queryStudentByKey(String key, int pageSize, int pageNo,
			List<StudentVO> pageData) throws Exception {
		// 参数验证
		// 查询总记录数
		StudentDAO dao = new StudentDAOImpl();
		
		for (int i = 0; i < 10; i++) {
			pageData.add(new StudentVO());
		}
		return 10;
	}

	public int deleteStudentById(String... ids) throws Exception {
		int count = 0;
		StudentDAO dao = new StudentDAOImpl();
		for (int i = 0; i < ids.length; i++) {
			dao.deleteById(ids[i]);
			count++;
		}
		return count;
	}

	public void updateStudentById(String id, StudentVO vo) throws Exception {

		// 1 验证属性
		
		StudentDAO dao = new StudentDAOImpl();
		StudentVO oldVo = dao.getById(id);
		if (oldVo == null) {
			throw new ThisAppException("学生记录已被删除或不存在");
		}
		if (!oldVo.getNo().equals(vo.getNo())) {
			if (dao.isExsitNo(vo.getNo())) { // 判断学号是否存在
				throw new ThisAppException("学号[" + vo.getNo() + "]已存在!");
			}
		}
		if (!oldVo.getEnterDay().equals(vo.getEnterDay())) {
			// 计算毕业时间
			Calendar cal = Calendar.getInstance();
			cal.setTime(vo.getEnterDay());
			cal.add(Calendar.YEAR, 3);
			oldVo.setGraduateDay(cal.getTime());
		}
		vo.setId(id);
		vo.setGraduateDay(oldVo.getGraduateDay());
		// 保存
		dao.update(vo);
	}

	public StudentVO getStudentById(String id) throws Exception {
		StudentDAO dao = new StudentDAOImpl();
		return dao.getById(id);
	}

}
