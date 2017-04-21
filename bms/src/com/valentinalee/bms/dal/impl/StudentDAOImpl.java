package com.valentinalee.bms.dal.impl;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.valentinalee.bms.dal.StudentDAO;
import com.valentinalee.bms.util.DBUtil;
import com.valentinalee.bms.util.ThisAppUtil;
import com.valentinalee.bms.vo.StudentVO;

public class StudentDAOImpl implements StudentDAO {

	public StudentVO getById(String id) throws SQLException {
		Connection con=DBUtil.getConnection();
		String sql="select * from sys_student where cid=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				StudentVO vo=new StudentVO();
				vo.setEnterDay(rs.getDate("enterday"));
				vo.setGraduateDay(rs.getDate("graduateday"));
				vo.setName(rs.getString("cname"));
				vo.setNo(rs.getString("cno"));
				vo.setSex(rs.getString("csex"));
				vo.setId(rs.getString("cid"));
				return vo;
			}
		}finally{
			DBUtil.close(con);
		}
		return null;
	}

	public StudentVO add(StudentVO vo) throws SQLException {
		
		Connection con=DBUtil.getConnection();
		String sql="insert into sys_student(cid,cno,cname,csex,enterday,graduateday) values(?,?,?,?,?,?)";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			int i=1;
			vo.setId(DBUtil.uuid());
			ps.setString(i++,vo.getId());
			ps.setString(i++, vo.getNo());
			ps.setString(i++, vo.getName());
			ps.setString(i++, vo.getSex());
			ps.setDate(i++, new Date(vo.getEnterDay().getTime()));
			ps.setDate(i++, new Date(vo.getGraduateDay().getTime()));
			ps.executeUpdate();
			//提交事务
			con.commit();
		}catch(SQLException e){
			//事务回滚
			con.rollback();
			throw e;
		}finally{
			DBUtil.close(con);
		}
		return vo;
	}

	public boolean isExsitNo(String no)throws SQLException {
		Connection con=DBUtil.getConnection();
		String sql="select cno from sys_student where cno=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, no);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				return true;
			}
		}finally{
			DBUtil.close(con);
		}
		return false;
	}
	

	public int  queryByKey(String key, int pageSize, int pageNo,List<StudentVO> pageData)
			throws SQLException {
		int totalCount=0;
		Connection con=DBUtil.getConnection();
		StringBuilder countSQL=new StringBuilder();
		countSQL.append("select count(*) from sys_student ");
		if(!ThisAppUtil.isNone(key)){
			countSQL.append(" where ")
			.append(" cno like ? or ")
			.append(" cname like ?  ");
		}
		PreparedStatement ps=con.prepareStatement(countSQL.toString());
		if(!ThisAppUtil.isNone(key)){
			key="%"+key+"%";
			ps.setString(1, key);
			ps.setString(2, key);
		}
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			if((totalCount=rs.getInt(1))==0){
				return 0;
			}
		}
		ps.close();
		StringBuilder selectSQL=new StringBuilder();
		selectSQL.append("select * from ")
		.append("sys_student");
		if(!ThisAppUtil.isNone(key)){
			selectSQL.append(" where ")
			.append(" cno like ? or ")
			.append(" cname like ?  ");
		}
		selectSQL.append(" limit ").append((pageNo-1)*pageSize).append(",")
		.append(pageSize);
		try{
			ps=con.prepareStatement(selectSQL.toString());
			if(!ThisAppUtil.isNone(key)){
				key="%"+key+"%";
				ps.setString(1, key);
				ps.setString(2, key);
			}
			rs=ps.executeQuery();
			
			while(rs.next()){
				StudentVO vo=new StudentVO();
				vo.setEnterDay(rs.getDate("enterday"));
				vo.setGraduateDay(rs.getDate("graduateday"));
				vo.setName(rs.getString("cname"));
				vo.setNo(rs.getString("cno"));
				vo.setSex(rs.getString("csex"));
				vo.setId(rs.getString("cid"));
				pageData.add(vo);
			}
		}finally{
			DBUtil.close(con);
		}
		return totalCount;
	}
	


	public int deleteById(String id) throws SQLException {
		int n=0;
		Connection con=DBUtil.getConnection();
		String sql="delete from sys_student where cid=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, id);
			n=ps.executeUpdate();
			con.commit();
		}catch(SQLException e){
			con.rollback();
			throw e;
		}finally{
			DBUtil.close(con);
		}
		return n;
	}

	public void update(StudentVO vo) throws SQLException {
		Connection con=DBUtil.getConnection();
		String sql="update sys_student set cno=?,cname=?,csex=?,enterday=?,graduateday=? where cid=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			int i=1;
			ps.setString(i++, vo.getNo());
			ps.setString(i++, vo.getName());
			ps.setString(i++, vo.getSex());
			ps.setDate(i++, new Date(vo.getEnterDay().getTime()));
			ps.setDate(i++, new Date(vo.getGraduateDay().getTime()));
			ps.setString(i++,vo.getId());
			ps.executeUpdate();
			//提交事务
			con.commit();
		}catch(SQLException e){
			//事务回滚
			con.rollback();
			throw e;
		}finally{
			DBUtil.close(con);
		}
	}

	public int getMaxNo() throws SQLException {
		int maxNo=0;
		Connection con=DBUtil.getConnection();
		String sql="select max(cno) from sys_student";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				String str=rs.getString(1);
				maxNo=str==null?100000:Integer.parseInt(str);
			}
		}finally{
			DBUtil.close(con);
		}
		return maxNo+1;
	}

}
