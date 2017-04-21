package com.valentinalee.bms.dal.impl;

import java.util.List;

import com.valentinalee.bms.vo.PublisherVO;

/**
 * 提供图书出版社对象的数据访问
 * @author valentinalee
 *
 */
public interface PublisherDAO {

	/**
	 * 查询图书出版社
	 * @return
	 * @throws Exception
	 */
	List<PublisherVO> queryPublisher() throws Exception;
}
