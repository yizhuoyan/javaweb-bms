package com.valentinalee.bms.bll;


import java.util.List;


import com.valentinalee.bms.vo.PublisherVO;

/**
 * 图书出版社相关业务接口
 * @author valentinalee
 *
 */
public interface PublisherService {

	/**
	 * 查询图书类型
	 * @return
	 * @throws Exception
	 */
	List<PublisherVO> queryPublisher() throws Exception;
	
}
