package com.valentinalee.bms.dal;

import java.sql.SQLException;

import com.valentinalee.bms.vo.ManagerVO;

/**
 * 提供管理员对象的数据访问
 * @author valentinalee
 *
 */
public interface ManagerDAO {
	
	/**
	 * 通过id查找唯一的管理员对象
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	ManagerVO getById(String id) throws SQLException;

	/**
	 * 通过账号查找
	 * 唯一的管理员对象
	 * @param account 账号
	 * @return 管理员对象
	 * @throws SQLException 
	 */
	ManagerVO queryByAccount(String account) throws SQLException;
	
	/**
	 * 管理员修改密码
	 * @param id 编号
	 * @param newPassword 新密码
	 * @throws Exception
	 */
	void updatePassword(String id,String newPassword) throws Exception;
}
