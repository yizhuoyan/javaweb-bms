package com.valentinalee.bms.bll;


import java.util.List;

import com.valentinalee.bms.vo.TypeVO;

/**
 * 图书类型相关业务接口
 * @author valentinalee
 *
 */
public interface TypeService {

	/**
	 * 查询图书类型
	 * @return
	 * @throws Exception
	 */
	List<TypeVO> queryType() throws Exception;
	
}
