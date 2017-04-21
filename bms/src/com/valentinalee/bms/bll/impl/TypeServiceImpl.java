package com.valentinalee.bms.bll.impl;

import java.util.List;

import com.valentinalee.bms.bll.TypeService;
import com.valentinalee.bms.dal.TypeDAO;
import com.valentinalee.bms.dal.impl.TypeDAOImpl;
import com.valentinalee.bms.vo.TypeVO;

public class TypeServiceImpl implements TypeService {

	public List<TypeVO> queryType() throws Exception {
		TypeDAO dao=new TypeDAOImpl();
		return dao.queryType();
	}

}
