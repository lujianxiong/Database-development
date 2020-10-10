package cn.daxiong.jdbc;
//DBCP连接池
import java.sql.Connection;

import org.apache.commons.dbcp.BasicDataSource;


public class Demo1 {
	public static void main(String[] args) throws Exception{
		//1、创建连接池对象
		BasicDataSource dataSource = new BasicDataSource();
		//2、配置四大参数
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mydb3");
		dataSource.setUsername("root");
		dataSource.setPassword("123");
		//3、配置池参数    【像池参数，都是有默认配置的，不设置也没事】
		dataSource.setMaxActive(20);  //设置最大活动连接数
		dataSource.setMinIdle(3);  //设置最小空闲连接
		dataSource.setMaxWait(1000);  //设置最大等待时间
		//4、得到连接对象
		Connection conn = dataSource.getConnection();
		System.out.println(conn.getClass().getName());
		
		/**
		 * 连接池内部使用四大参数创建了四大参数，即mysql驱动提供的connection
		 * 连接池对mysql的连接对象进行了装饰，对close方法进行了增强！！
		 * 装饰之后的connection的close()方法，会把当前的连接归还给连接池！！
		 */
		conn.close();  //把连接归还给连接池
	}

}
