package com.valentinalee.bms.dal.impl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.valentinalee.bms.dal.BookDAO;
import com.valentinalee.bms.util.DBUtil;
import com.valentinalee.bms.util.ThisAppUtil;
import com.valentinalee.bms.vo.BookVO;

public class BookDAOImpl implements BookDAO {
	
	public BookVO getByISBN(String isbn) throws SQLException {
		Connection con=DBUtil.getConnection();
		String sql="select * from sys_book where cisbn=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, isbn);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				BookVO vo=new BookVO();
				vo.setAuthor(rs.getString("cauthor"));
				vo.setBookType(rs.getString("cbooktype"));
				vo.setISBN(rs.getString("cisbn"));
				vo.setLeftAmount(rs.getInt("iLeftamount"));
				vo.setName(rs.getString("cname"));
				vo.setPrice(rs.getDouble("fprice"));
				vo.setPublisher(rs.getString("cpublisher"));
				vo.setStoreAmount(rs.getInt("iStoreamount"));
				vo.setId(rs.getString("cid"));
				return vo;
			}
		}finally{
			DBUtil.close(con);
		}
		return null;
	}

	
	public BookVO getById(String id) throws SQLException {
		Connection con=DBUtil.getConnection();
		String sql="select * from sys_book where cid=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				BookVO vo=new BookVO();
				vo.setAuthor(rs.getString("cauthor"));
				vo.setBookType(rs.getString("cbooktype"));
				vo.setISBN(rs.getString("cisbn"));
				vo.setLeftAmount(rs.getInt("iLeftamount"));
				vo.setName(rs.getString("cname"));
				vo.setPrice(rs.getDouble("fprice"));
				vo.setPublisher(rs.getString("cpublisher"));
				vo.setStoreAmount(rs.getInt("iStoreamount"));
				vo.setId(rs.getString("cid"));
				return vo;
			}
		}finally{
			DBUtil.close(con);
		}
		return null;
	}
	
	public boolean isExsitISBN(String isbn) throws SQLException {
		Connection con=DBUtil.getConnection();
		String sql="select cisbn from sys_book where cisbn=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, isbn);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				return true;
			}
		}finally{
			DBUtil.close(con);
		}
		return false;
	}


	public BookVO addBook(BookVO vo) throws Exception {
		Connection con=DBUtil.getConnection();
		String sql="insert into sys_book(cid,cname,cisbn,cauthor," +
				"cpublisher,cbooktype,fprice,iStoreamount,iLeftamount) " +
				"values(?,?,?,?,?,?,?,?,?)";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			int i=1;
			vo.setId(DBUtil.uuid());
			ps.setString(i++,vo.getId());
			ps.setString(i++, vo.getName());
			ps.setString(i++, vo.getISBN());
			ps.setString(i++, vo.getAuthor());
			ps.setString(i++, vo.getPublisher());
			ps.setString(i++, vo.getBookType());
			ps.setDouble(i++, vo.getPrice());
			ps.setInt(i++, vo.getStoreAmount());
			ps.setInt(i++, vo.getLeftAmount());
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

	public int deleteBook(String id) throws Exception{
		int n=0;
		Connection con=DBUtil.getConnection();
		String sql="delete from sys_book where cid=?";
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

	public int queryBookByKey(Map<String,Object> fieldsMap, int pageSize, int pageNo,
			List<BookVO> pageData) throws Exception {
		int totalCount=0;
		Connection con=DBUtil.getConnection();
		StringBuilder whereSQL=new StringBuilder();
		whereSQL.append(" from sys_book where 1=1 ");
		String name=(String)fieldsMap.get("name");
		if(!ThisAppUtil.isNone(name)){
			whereSQL.append(" and cname like '%").append(name).append("%'");
		}
		String isbn=(String)fieldsMap.get("isbn");
		if(!ThisAppUtil.isNone(isbn)){
			whereSQL.append(" and cisbn like '%").append(isbn).append("%'");
		}
		String author=(String)fieldsMap.get("author");
		if(!ThisAppUtil.isNone(author)){
			whereSQL.append(" and cauthor like '%").append(author).append("%'");
		}
		String publisher=(String)fieldsMap.get("publisher");
		if(!ThisAppUtil.isNone(publisher)){
			whereSQL.append(" and cpublisher = '").append(publisher).append("'");
		}
		String[] types=(String[])fieldsMap.get("checkedTypes");
		if(types!=null&&types.length!=0){
			whereSQL.append(" and (");	
			for (int i = 0; i < types.length; i++) {
				if(i!=0){
					whereSQL.append("  or ");
				}
				whereSQL.append(" cbooktype ='").append(types[i])
				.append("'");
			}
			whereSQL.append(")");
		}
		Integer minStoreAmount=(Integer)fieldsMap.get("minStoreAmount");
		Integer maxStoreAmount=(Integer)fieldsMap.get("maxStoreAmount");
		if(minStoreAmount!=null&&maxStoreAmount!=null){
			whereSQL.append(" and (iStoreAmount>="+minStoreAmount+" and iStoreAmount<"+maxStoreAmount+")");
		}else if(minStoreAmount!=null&&maxStoreAmount==null){
			whereSQL.append(" and iStoreAmount>="+minStoreAmount);
		}else if(minStoreAmount==null&&maxStoreAmount!=null){
			whereSQL.append(" and iStoreAmount<"+maxStoreAmount);
		}
		PreparedStatement ps=con.prepareStatement("select count(*) "+whereSQL.toString());
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			if((totalCount=rs.getInt(1))==0){
				return 0;
			}
		}
		ps.close();
		StringBuilder selectSQL=new StringBuilder();
		selectSQL.append("select * ").append(whereSQL);
		selectSQL.append(" limit ").append((pageNo-1)*pageSize).append(",")
		.append(pageSize);
		try{
			
			ps=con.prepareStatement(selectSQL.toString());
			rs=ps.executeQuery();
			while(rs.next()){
				BookVO vo=new BookVO();
				vo.setAuthor(rs.getString("cauthor"));
				vo.setBookType(rs.getString("cbooktype"));
				vo.setISBN(rs.getString("cisbn"));
				vo.setName(rs.getString("cname"));
				vo.setPublisher(rs.getString("cpublisher"));
				vo.setId(rs.getString("cid"));
				vo.setLeftAmount(rs.getInt("iLeftamount"));
				vo.setPrice(rs.getDouble("fprice"));
				vo.setStoreAmount(rs.getInt("iStoreamount"));
				pageData.add(vo);
			}
		}finally{
			DBUtil.close(con);
		}
		return totalCount;
	}


	public void update(BookVO vo) throws SQLException {
		Connection con=DBUtil.getConnection();
		String sql="update sys_book set cname=?,cisbn=?,cauthor=?,cpublisher=?,cbooktype=?,fprice=?,iStoreamount=?,iLeftamount=? where cid=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			int i=1;
			ps.setString(i++, vo.getName());
			ps.setString(i++, vo.getISBN());
			ps.setString(i++, vo.getAuthor());
			ps.setString(i++, vo.getPublisher());
			ps.setString(i++, vo.getBookType());
			ps.setDouble(i++, vo.getPrice());
			ps.setInt(i++, vo.getLeftAmount());
			ps.setInt(i++, vo.getLeftAmount());
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

	
	
}
