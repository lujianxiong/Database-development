package cn.daxiong.jdbc;
import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	//使用C3P0配置文件默认配置，必须给出c3p0-config.xml
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	//它是事务专用连接
	private static Connection con = null;
	
	//使用连接池返回一个连接对象
	public static Connection getConnection() throws Exception{
		//当con不等于null，说明已经调用过beginTransaction，说明开启事务了，就必须使用同一个Connection
		if(con != null) {
			return con;
		}
		return dataSource.getConnection();
	}
	
	//返回连接池对象
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	//开启事务
	//获取Connection，设置setAutoCommit(false)
	//保证dao中使用的连接是我们刚刚创建的连接
	public static void beginTransaction() throws Exception{
		//1、给con赋值
		con = getConnection();
		//2、设置con为手动提交
		con.setAutoCommit(false);
	}
	
	//提交事务
	//获取beginTransaction提供的Connection，调用commit方法  【直接使用con.commit()】
	public static void commitTransaction() throws Exception{
		con.commit();
		con.close();
	}
	
	//回滚事务
	//获取beginTransaction提供的Connection，调用rollback方法  【直接使用con.rollback()】
	public static void rollbackTransaction() throws Exception{
		con.rollback();
		con.close();
	}
	
}
