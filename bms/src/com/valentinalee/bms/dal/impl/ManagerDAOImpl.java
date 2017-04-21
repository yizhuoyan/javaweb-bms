package com.valentinalee.bms.dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.valentinalee.bms.dal.ManagerDAO;
import com.valentinalee.bms.util.DBUtil;
import com.valentinalee.bms.vo.ManagerVO;

public class ManagerDAOImpl implements ManagerDAO {
	
	public ManagerVO getById(String id) throws SQLException {

		Connection con=DBUtil.getConnection();
		
		String sql="select * from sys_manager where cid=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				ManagerVO vo=new ManagerVO();
				vo.setId(rs.getString("cid"));
				vo.setAccount(rs.getString("caccount"));
				vo.setCreateTime(rs.getDate("createtime"));
				vo.setName(rs.getString("cname"));
				vo.setPassword(rs.getString("cpassword"));
				
				return vo;
			}
		}finally{
			DBUtil.close(con);
		}
		return null;
	}


	public ManagerVO queryByAccount(String account) throws SQLException {

		Connection con=DBUtil.getConnection();
		
		String sql="select * from sys_manager where caccount=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, account);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				ManagerVO vo=new ManagerVO();
				vo.setId(rs.getString("cid"));
				vo.setAccount(rs.getString("caccount"));
				vo.setCreateTime(rs.getDate("createtime"));
				vo.setName(rs.getString("cname"));
				vo.setPassword(rs.getString("cpassword"));
				
				return vo;
			}
		}finally{
			DBUtil.close(con);
		}
		return null;
	}

	public void updatePassword(String id, String newPassword)
			throws Exception {
		Connection con=DBUtil.getConnection();
		String sql="update sys_manager set cpassword=? where cid=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setString(2, id);
			ps.executeUpdate();
			con.commit();
		}catch(SQLException e){
			con.rollback();
			throw e;
		}finally{
			DBUtil.close(con);
		}
	}

}
