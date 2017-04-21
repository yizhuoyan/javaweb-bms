package com.valentinalee.bms.dal.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.valentinalee.bms.util.DBUtil;
import com.valentinalee.bms.vo.PublisherVO;

public class PublisherDAOImpl implements PublisherDAO {

	public List<PublisherVO> queryPublisher() throws Exception {
		List<PublisherVO> vos=new ArrayList<PublisherVO>();
		Connection con=DBUtil.getConnection();
		String sql="select * from sys_publisher";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				PublisherVO vo=new PublisherVO();
				vo.setId(rs.getString("cid"));
				vo.setPublisher(rs.getString("cname"));
				vos.add(vo);
			}
		}finally{
			DBUtil.close(con);
		}
		return vos;
	}

}
