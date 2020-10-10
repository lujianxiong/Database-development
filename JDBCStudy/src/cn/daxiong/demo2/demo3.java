package cn.daxiong.demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class demo3 {
	public static void query() throws Exception{
		Connection conn = null;  //定义引用
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//一、进行数据库连接
			String driverClassName = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/mydb3";
			String username = "root";
			String password = "123";
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);   //实例化
	
			//二、执行查询操作
			stmt = conn.createStatement();
			String sql = "SELECT * FROM emp";
			rs = stmt.executeQuery(sql);
			rs.last();   //将光标移动到最后一行
			System.out.println(rs.getRow());  //获取当前光标所在的行数，因为是行数是从1开始的，所以最后一行的行数就是整个结果集的行数
			rs.beforeFirst();
			
			int count = rs.getMetaData().getColumnCount();
			while(rs.next()) {  //遍历行
				for (int i = 1; i <= count; i++) {  //遍历列
					System.out.print(rs.getObject(i));
					if (i < count ) {
						System.out.print(",");
					}
				}
				System.out.println();
			}
			
			
//			//三、循环遍历rs，打印其中的数据
//			//这里面getString和getObject几乎是通用的，Object什么类型都可以接收，String也都可以将其他类型转为String类型
//			while(rs.next()) {
//				System.out.println(rs.getObject(1)+"、"+rs.getString(2)+"、"+rs.getDouble("sal")); 
//			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//关闭资源
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

}
