package com.valentinalee.bms.dal.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.valentinalee.bms.dal.BookDAO;
import com.valentinalee.bms.dal.BorrowDAO;
import com.valentinalee.bms.dal.ManagerDAO;
import com.valentinalee.bms.dal.StudentDAO;
import com.valentinalee.bms.util.DBUtil;
import com.valentinalee.bms.vo.BookVO;
import com.valentinalee.bms.vo.BorrowVO;
import com.valentinalee.bms.vo.ManagerVO;
import com.valentinalee.bms.vo.StudentVO;

public class BorrowDAOImpl implements BorrowDAO {
	
	public int queryAllBorrowNoGiveBack(int pageSize, int pageNo,List<BorrowVO> pageData) throws Exception{
		Connection con=DBUtil.getConnection();
		int totalCount=0;
		String countSQL="select count(*) from log_borrow where givebacktime=?";
		PreparedStatement ps=con.prepareStatement(countSQL);
		ps.setString(1, "");
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			if((totalCount=rs.getInt(1))==0){
				return 0;
			}
		}
		ps.close();
		StringBuilder selectSQL=new StringBuilder();
		selectSQL.append("select * from log_borrow where givebacktime=''");
		selectSQL.append(" limit ").append((pageNo-1)*pageSize).append(",")
		.append(pageSize);
		try{
			ps=con.prepareStatement(selectSQL.toString());
			rs=ps.executeQuery();
			if(rs.next()){
				BorrowVO borrowVO=new BorrowVO();
				BookDAO bookDAO=new BookDAOImpl();
				BookVO	bookVO=bookDAO.getById(rs.getString("cbook_id"));
				borrowVO.setBook(bookVO);
				StudentDAO studentDAO=new StudentDAOImpl();
				StudentVO	studentVO=studentDAO.getById(rs.getString("cstudent_id"));
				borrowVO.setStudent(studentVO);
				ManagerDAO managerDAO=new ManagerDAOImpl();
				ManagerVO managerOut=managerDAO.getById(rs.getString("borrowoutmanager_id"));
				ManagerVO managerBack=managerDAO.getById(rs.getString("givebackmanager_id"));
				borrowVO.setBorrowOutManager(managerOut);
				borrowVO.setGiveBackManager(managerBack);
				borrowVO.setBorrowDay(rs.getInt("iborrowday"));
				borrowVO.setBorrowOutTime(rs.getDate("BorrowOuttime"));
				borrowVO.setGiveBackErrorType(rs.getString("igivebackerrortype"));
				borrowVO.setGiveBackTime(rs.getDate("givebacktime"));
				borrowVO.setId(rs.getString("cid"));
				borrowVO.setMustGiveBackTime(rs.getDate("mustgivebacktime"));
				borrowVO.setRemark(rs.getString("cremark"));
				pageData.add(borrowVO);
			}
		}finally{
			DBUtil.close(con);
		}
		return totalCount;	
	}

	public List<BorrowVO> queryStudentNoGiveBackBooksPageData(String studentId)
			throws Exception {
		Connection con=DBUtil.getConnection();
		List<BorrowVO> borrowVOs=new ArrayList<BorrowVO>();
		String sql="select * from log_borrow where cstudent_id=? and givebacktime=''";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, studentId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				BorrowVO borrowVO=new BorrowVO();
				BookDAO bookDAO=new BookDAOImpl();
				BookVO	bookVO=bookDAO.getById(rs.getString("cbook_id"));
				borrowVO.setBook(bookVO);
				StudentDAO studentDAO=new StudentDAOImpl();
				StudentVO	studentVO=studentDAO.getById(rs.getString("cstudent_id"));
				borrowVO.setStudent(studentVO);
				ManagerDAO managerDAO=new ManagerDAOImpl();
				ManagerVO managerOut=managerDAO.getById(rs.getString("borrowoutmanager_id"));
				ManagerVO managerBack=managerDAO.getById(rs.getString("givebackmanager_id"));
				borrowVO.setBorrowOutManager(managerOut);
				borrowVO.setGiveBackManager(managerBack);
				borrowVO.setBorrowDay(rs.getInt("iborrowday"));
				borrowVO.setBorrowOutTime(rs.getDate("BorrowOuttime"));
				borrowVO.setGiveBackErrorType(rs.getString("igivebackerrortype"));
				borrowVO.setGiveBackTime(rs.getDate("givebacktime"));
				borrowVO.setId(rs.getString("cid"));
				borrowVO.setMustGiveBackTime(rs.getDate("mustgivebacktime"));
				borrowVO.setRemark(rs.getString("cremark"));
				borrowVOs.add(borrowVO);
			}
		}finally{
			DBUtil.close(con);
		}
		return borrowVOs;
	}
	
	public int queryStudentNoGiveBackBooks(String studentId) throws Exception {
		Connection con=DBUtil.getConnection();
		int count=0;
		String sql="select cid from log_borrow where cstudent_id=? and givebacktime=''";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, studentId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				count++;
			}
		}finally{
			DBUtil.close(con);
		}
		return count;
	}

	public BorrowVO addBorrow(BorrowVO borrowVO) throws Exception {
		Connection con=DBUtil.getConnection();
		String sql="insert into log_borrow(cid,cstudent_id,cbook_id,BorrowOuttime,iborrowday,mustgivebacktime,borrowoutmanager_id) values(?,?,?,?,?,?,?)";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			int i=1;
			borrowVO.setId(DBUtil.uuid());
			ps.setString(i++,borrowVO.getStudent().getId());
			ps.setString(i++, borrowVO.getBook().getId());
			ps.setDate(i++, new Date(new java.util.Date().getTime()));
			ps.setInt(i++, borrowVO.getBorrowDay());
			ps.setDate(i++, new Date(borrowVO.getMustGiveBackTime().getTime()));
			ps.setString(i++, borrowVO.getBorrowOutManager().getId());
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
		return borrowVO;
	}

}
