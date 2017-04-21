package com.valentinalee.bms.bll;


import com.valentinalee.bms.vo.ManagerVO;

/**
 * 管理员相关业务接口
 * @author valentinalee
 *
 */
public interface ManagerService {

	/**
	 * 管理员登录
	 * @param account 账号
	 * @param password 密码
	 * @return
	 */
	public ManagerVO login(String account,String password) throws Exception;
	
	/**
	 * 管理员修改密码
	 * @param id 编号
	 * @param newPassword 新密码
	 * @throws Exception
	 */
	public void updatePassword(String id,String newPassword) throws Exception;
}
