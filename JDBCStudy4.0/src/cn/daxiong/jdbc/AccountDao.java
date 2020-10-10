package cn.daxiong.jdbc;

import org.apache.commons.dbutils.QueryRunner;

public class AccountDao {
	public void update(String name,double money) throws Exception{
		QueryRunner qr = new TxQueryRunner();
		String sql = "UPDATE account SET balance=balance+? WHERE name=?";
		Object[] params = {money,name};
		qr.update(sql,params);
	}

}
