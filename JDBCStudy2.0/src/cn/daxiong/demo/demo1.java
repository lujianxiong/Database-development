package cn.daxiong.demo;
//事务
import java.sql.Connection;
import java.sql.SQLException;

import cn.daxiong.util.JdbcUtils;

//演示转账
public class demo1 {

	public static void main(String[] args) {
		zhuanzhang("zs", "ls", 100);

	}
	
	//转账
	public static void zhuanzhang(String from,String to,double money){
		//对同一事务的所有操作必须是同一个Connection对象
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			//开启事务
			conn.setAutoCommit(false);
			AccountDao dao = new AccountDao();
			dao.updateBalance(conn,from, -money);    //给from减去相应的金额
			dao.updateBalance(conn,to, money);    //给to加上相应的金额
			//提交事务
			conn.commit();
			conn.close();
		} catch (Exception e) {
			//回滚事务
			try {
				conn.rollback();
				conn.close();
			} catch (Exception e1) {
				e.printStackTrace();
			}
		}
	}

}
