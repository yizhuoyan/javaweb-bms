package com.valentinalee.bms.dal;

import java.util.List;

import com.valentinalee.bms.vo.TypeVO;

/**
 * 提供图书类型对象的数据访问
 * @author valentinalee
 *
 */
public interface TypeDAO {

	/**
	 * 查询图书类型
	 * @return
	 * @throws Exception
	 */
	List<TypeVO> queryType() throws Exception;
}
