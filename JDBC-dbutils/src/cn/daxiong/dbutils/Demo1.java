package cn.daxiong.dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;

import cn.daxiong.jdbc.JdbcUtils;

//commons-dbutils是用来简化jdbc代码的！
public class Demo1 {

	public static void main(String[] args) {
		
	}
	
	public static void addStu(Stu stu) {
		Connection con = null;
		PreparedStatement psmt = null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "UINSERT INTO stu VALUES(?,?,?,?)";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, stu.getSid());
			psmt.setString(2, stu.getSname());
			psmt.setInt(3, stu.getAge());
			psmt.setString(4, stu.getGender());
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//进行关闭
			
		}
	}

}
