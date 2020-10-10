package cn.daxiong.dbutils;
//使用dbutils简化查询
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.daxiong.jdbc.JdbcUtils;

public class Demo3 {

	public static void main(String[] args) throws Exception{
		//插入
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "INSERT INTO stu VALUES(?,?,?,?)";
		Object[] params = {10002,"波多野结衣",30,"女优"};
		qr.update(sql,params);
		
		//查询
//		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());  //提供连接池对象
//		String sql = "SELECT * FROM stu WHERE sid=?";  //sql模板
//		Object[] params = {10002};   //设置参数
//		Stu stu = qr.query(sql, new BeanHandler<Stu>(Stu.class), params);   //执行query方法，给出结果集处理器ResultSetHandler的实现类对象：BeanHandler
//		//BeanHandler，它实现了ResultSetHandler接口的方法，传入一个类型，将rs中的数据封装到指定类型的JavaBean对象中，然后返回JavaBean对象
//		System.out.println(stu);
//		
	}

}
