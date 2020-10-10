package cn.daxiong.demo3;
//PreparedStatement  SQL攻击!!!
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Demo3 {
	public static void main(String[] args) throws Exception{
		String username = "a' or 'a'='a";
		String password = "a' or 'a'='a";
		boolean bool = login2(username, password);
		System.out.println(bool);
	}
	
	public static boolean login2(String user,String pwd) throws Exception{
		//一、得到Connection
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mydb3?useServerPrepStmts=true&cachePrepStmts=true";
		String username = "root";
		String password = "123";
		Class.forName(driverClassName);
		Connection conn = DriverManager.getConnection(url, username, password);
		
		////////////////////////////////////////////////////////////////////////////////////
		
		//得到PreparedStatement
		//1、给出sql模板：所有的参数使用占位符?来替代
		//?表示的必然是参数的值，它永远不可能跟sql语句构成一个sql片段来组合，它只能作为值
		String sql = "SELECT * FROM t_user WHERE username=? AND password=?"; 
		
		//2、调用Connection，得到PreparedStatement
		PreparedStatement psmt = conn.prepareStatement(sql);
		
		//3、为参数赋值
		psmt.setString(1, user);  //给第一个?赋值，值为user
		psmt.setString(2, pwd);  //给第二个?赋值，值为pwd
		
		//4、调用excuteQuery或executeUpdate
		ResultSet rs = psmt.executeQuery();
		return rs.next();
		
	}
	
	
	
	/**
	 * 登录方法
	 * 使用usename和password去查询数据
	 * @param username
	 * @param password
	 * @return 查询到数据，返回true，查不到，返回false
	 */
	public static boolean login(String user,String pwd) throws Exception{
		//一、得到Connection
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mydb3";
		String username = "root";
		String password = "123";
		Class.forName(driverClassName);
		Connection conn = DriverManager.getConnection(url, username, password);
		
		//二、得到Statement
		Statement stmt = conn.createStatement();
	
		//三、得到ResultSet
		String sql = "SELECT * FROM t_user WHERE username='"+user+"' AND password='"+pwd+"'";
		System.out.println(sql);
		ResultSet rs = stmt.executeQuery(sql);
		
		//四、rs.next()返回的是什么，我们就返回什么
		return rs.next();  //因为next方法返回的就是boolean值，有值就返回true，没有就false
		
	}
}
