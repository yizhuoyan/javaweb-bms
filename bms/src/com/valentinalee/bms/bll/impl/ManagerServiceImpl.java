package com.valentinalee.bms.bll.impl;

import com.valentinalee.bms.bll.ManagerService;
import com.valentinalee.bms.dal.ManagerDAO;
import com.valentinalee.bms.dal.impl.ManagerDAOImpl;
import com.valentinalee.bms.exception.ThisAppException;
import com.valentinalee.bms.util.ThisAppUtil;
import com.valentinalee.bms.vo.ManagerVO;

public class ManagerServiceImpl implements ManagerService {
	

	public ManagerVO login(String account, String password)
			throws Exception {
		
			//1 验证参数
			ManagerDAO dao=new ManagerDAOImpl();
			ManagerVO vo=dao.queryByAccount(account);
			//2 逻辑判断
			//账号是否存在
			if(vo==null){
				throw new ThisAppException("你输入的账号不存在");
			}
			//密码是否匹配
			if(!vo.getPassword().equals(password)){
				throw new ThisAppException("你输入的密码有误");
			}
			
		
		return vo;
	}

	public void updatePassword(String id, String newPassword)
			throws Exception {
		if(ThisAppUtil.isNone(id)){
			throw new ThisAppException("待修改的管理员不存在");
		}
	}

}
