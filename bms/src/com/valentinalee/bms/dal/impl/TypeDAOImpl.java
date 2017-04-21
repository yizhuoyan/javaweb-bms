package com.valentinalee.bms.dal.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.valentinalee.bms.dal.TypeDAO;
import com.valentinalee.bms.util.DBUtil;
import com.valentinalee.bms.vo.TypeVO;

public class TypeDAOImpl implements TypeDAO {
	
	public List<TypeVO> queryType() throws Exception {
		List<TypeVO> vos=new ArrayList<TypeVO>();
		Connection con=DBUtil.getConnection();
		String sql="select cid,cname from sys_type";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				TypeVO vo=new TypeVO();
				vo.setId(rs.getString("cid"));
				vo.setType(rs.getString("cname"));
				vos.add(vo);
			}
		}finally{
			DBUtil.close(con);
		}
		return vos;
	}

}
