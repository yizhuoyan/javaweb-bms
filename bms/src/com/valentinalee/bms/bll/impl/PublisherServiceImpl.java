package com.valentinalee.bms.bll.impl;

import java.util.List;


import com.valentinalee.bms.bll.PublisherService;
import com.valentinalee.bms.dal.impl.PublisherDAO;
import com.valentinalee.bms.dal.impl.PublisherDAOImpl;
import com.valentinalee.bms.vo.PublisherVO;

public class PublisherServiceImpl implements PublisherService {

	public List<PublisherVO> queryPublisher() throws Exception {
		PublisherDAO dao=new PublisherDAOImpl();
		return dao.queryPublisher();
	}

}
