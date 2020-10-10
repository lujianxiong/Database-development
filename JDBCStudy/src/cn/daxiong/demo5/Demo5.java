package cn.daxiong.demo5;

import java.sql.Connection;
import java.sql.PreparedStatement;

import cn.daxiong.jdbcUtils.JdbcUtils;

//批处理
public class Demo5 {

	public static void main(String[] args) throws Exception{
		Connection conn = JdbcUtils.getConnection();
		String sql = "INSERT INTO stu VALUES(?,?,?,?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		//1、用循环疯狂向psmt中添加sql参数
		for (int i = 0; i < 10000; i++) {
			psmt.setInt(1, i+1);
			psmt.setString(2, "stu_"+i);
			psmt.setInt(3, i);
			psmt.setString(4, i%2==0?"男":"女");
			psmt.addBatch();  //添加批，这一组参数就保存到集合中
		}
		
		long start = System.currentTimeMillis();
		//2、执行批，向数据库发送
		psmt.executeBatch();
		long end = System.currentTimeMillis();
		System.out.println(end-start);  //37924毫秒 = 37秒
	}

}
