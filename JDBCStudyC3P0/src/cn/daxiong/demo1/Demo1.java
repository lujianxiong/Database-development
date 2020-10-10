package cn.daxiong.demo1;
//手动配置C3P0数据库连接池
import java.sql.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Demo1 {

	public static void main(String[] args) throws Exception{
		//创建连接池对象
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		//对池进行四大参数配置
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mydb3");
		dataSource.setUser("root");
		dataSource.setPassword("123");
		//池配置
		dataSource.setAcquireIncrement(5);
		dataSource.setInitialPoolSize(20);
		dataSource.setMinPoolSize(2);
		dataSource.setMaxPoolSize(50);
		//获得Connection对象
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
		conn.close();
	}
}
