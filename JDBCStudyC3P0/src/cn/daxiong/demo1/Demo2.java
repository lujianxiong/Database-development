package cn.daxiong.demo1;
//配置文件默认配置C3P0数据库连接池
import java.sql.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Demo2 {

	public static void main(String[] args) throws Exception{
		//在创建连接池对象的时候，这个对象会自动加载配置文件！(不用我们来指定)
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
		conn.close();
	}
}
