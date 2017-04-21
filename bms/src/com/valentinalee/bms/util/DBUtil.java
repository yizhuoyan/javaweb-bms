package com.valentinalee.bms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class DBUtil {
	
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String	URL			= "jdbc:mysql://127.0.0.1:3306/bms";
	private static final String USERNAME="root";
	private static final String PASSWORD="root";
	
	static{
		try{
			Class.forName(DRIVER);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public static final Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		// 是否自动提交
		con.setAutoCommit(false);

		return con;
	}
	

	
	public static final  void close(ResultSet rs) throws SQLException{
		if(rs!=null){
			rs.close();
		}
	}
	public static final  void close(PreparedStatement ps)throws SQLException{
		if(ps!=null){
			ps.close();
		}
	}
	public static final  void close(Connection con)throws SQLException{
		if(con!=null){
			con.close();
		}
	}
	/**
	 * 随机生成一个32位的全球唯一id
	 * @return uuid
	 */
	public static final String uuid(){
		String uuid=UUID.randomUUID().toString();
		char[] chars=new char[32];
		char temp=0;
		for (int i =uuid.length(),j=chars.length; i-->0;) {
			if((temp=uuid.charAt(i))!='-'){
				chars[--j]=temp;	
			}
		}
		return new String(chars);
	}
}
