package com.daxiong.jdbc.demo;
//演示JDBC基本流程
//注意：我们在整个操作过程中导的包都是java.sql包（千万不要导错包）
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo01 {
	public static void main(String[] args) {
		Connection conn = null; //连接对象
		PreparedStatement psmt = null;  //Statement对象  执行sql语句
		ResultSet rs = null;  //执行select后的结果
	
		try {
			//1、加载驱动（反射）
			Class.forName("com.mysql.jdbc.Driver");    //不同的驱动包路径是不一样的（找自己导入的驱动包中的com.sql.jdbc，以jdbc结尾的包下的Driver.class）
			
			//2、获取连接对象
			/**
			 * DriverManager.getConnection(url,user,password)
			 * url:不同的数据库的url是不同的
			 * user:用户名：超级管理员 root
			 * password:mysql数据库的密码
			 * jdbc:mysql://localhost:3306/mydb1 
			 * 协议        数据库            本机地址             端口号    数据库名
			 */
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1","root","123");  
			if(conn != null) {
				System.out.println("连接成功！");
			}
			
			//3、执行查询语句
			String sql = "select empno,ename,job,sal from emp";  //sql语句
			psmt = conn.prepareStatement(sql);  //初始化Statement对象
			rs = psmt.executeQuery();  //执行select查询 （executeQuery()）
			//如果是执行insert、delete、update,就使用executeUpdate()
			
			//4、解析结果集
			//如果有查询结果，那么re.next()为true
			while(rs.next()) {
				//从查询的封装结果中获取字段
				//结合表中的字符的数据类型，用不同的方法
				//每个方法中的参数就是查询结果中字段的索引
				int empno = rs.getInt(1);
				String ename = rs.getString(2);
				String job = rs.getString(3);
				double sal = rs.getDouble(4);
				System.out.println(empno+"\t"+ename+"\t"+job+"\t"+sal);   //t表示制表符，“\”表示转义
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//5、 关闭资源
			//注意：关闭多个资源的时候是先开后关
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
