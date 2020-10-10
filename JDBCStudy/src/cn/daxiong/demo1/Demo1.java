package cn.daxiong.demo1;

import java.sql.Connection;
import java.sql.DriverManager;


public class Demo1 {
	public static void main(String[] args) throws Exception{
		//JDBC四大配置参数
		/*
		 * driverClassName: com.mysql.jdbc.Driver
		 * url: jdbc:mysql://localhost:3306/mydb3（数据库名）
		 * username: root
		 * password: 123
		 */
		//Class.forName("com.mysql.jdbc.Driver");    //加载驱动类(相当于注册驱动)
//		com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
//		DriverManager.registerDriver(driver);
		
//		String url = "jdbc:mysql://localhost:3306/mydb3";
//		String username = "root";
//		String password = "123";
//		Connection connection = DriverManager.getConnection(url, username, password);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb3", "root", "123");
		
		System.out.println(conn);
	
		
		
		
		
	}

}
