package cn.daxiong.demo;
//事务
import java.sql.Connection;
import java.sql.PreparedStatement;

import cn.daxiong.util.JdbcUtils;

public class AccountDao {
	//修改指定用户的余额
	public void updateBalance(Connection conn,String name,double balance) {
		try {
			//2、给出sql模板，创建psmt
			String sql = "UPDATE account SET balance=balance+? WHERE name=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			//3、对参数进行赋值
			psmt.setDouble(1, balance);
			psmt.setString(2, name);
			//4、执行
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
