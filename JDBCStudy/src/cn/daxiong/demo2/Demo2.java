package cn.daxiong.demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo2 {

	public static void main(String[] args) throws Exception{
		//一、进行数据库连接
		// 1、准备四大参数
		String driverClassName = "com.mysql.jdbc.Driver";
		//jdbc协议格式：jdbc:数据库厂商的名称：子协议(由厂商来规定的)
		//mysql子协议格式：//主机：端口号/数据库名称    【不同的数据库格式不一样】
		String url = "jdbc:mysql://localhost:3306/mydb3";    
		String username = "root";
		String password = "123";
		// 2、加载驱动类
		Class.forName(driverClassName);
		// 3、得到Connection
		Connection conn = DriverManager.getConnection(url, username, password);
		
		//二、对数据库进行增、删、改
		//1、通过Connecion对象创建Statement  （Statement：语句的发送器，它的功能就是向数据库发送sql语句）
		Statement stmt = conn.createStatement();
		//2、通过Statement发送sql语句     (executeUpdate)
//		String sql = "INSERT INTOstu VALUES('ITCAST_0010','Daxiong',100,'male')";
//		String sql = "UPDATE stu SET name='baba',age=30,gender='female' WHERE number='ITCAST_0004'";
//		String sql = "DELETE FROM stu";
//		int r = stmt.executeUpdate(sql);
//		System.out.println(r);
		
		//三、查询
		//1、创建Statement
		Statement stat = conn.createStatement();
		//2、发送select语句  (executeQuery)  返回一个结果集
		ResultSet rs = stat.executeQuery("SELECT * FROM emp");
		//3、对ResultSet“表格”进行解析
		// 1)把行光标移动到第一行
		while (rs.next()) {  //光标下移并判断下一行是否存在
			int empno = rs.getInt(1);  //通过列编号获取该列的值
			String ename = rs.getString("ename");  //通过列名称来获取列的值
			double sal = rs.getDouble("sal");
			System.out.println(empno+"、"+ename+"、"+sal);
		}
		
		//四、关闭资源（倒关）
		rs.close();
		stat.close();
		conn.close();   //这个必须要关，这个不关就会出现软病，就是以后用的时候时好时坏。时间长了会导致资源耗尽。
		
	}
}
