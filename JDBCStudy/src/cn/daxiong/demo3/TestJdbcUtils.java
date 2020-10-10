package cn.daxiong.demo3;

import java.sql.Connection;

import cn.daxiong.jdbcUtils.JdbcUtils;

public class TestJdbcUtils {

	public static void main(String[] args) throws Exception{
		Connection conn = JdbcUtils.getConnection();
		System.out.println(conn);
		Connection conn2 = JdbcUtils.getConnection();
		System.out.println(conn2);
	}

}
