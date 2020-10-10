package cn.daxiong.dbutils;
//ResultSetHandler接口下的多个子类
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.daxiong.jdbc.JdbcUtils;

public class Demo4 {

	public static void main(String[] args) throws Exception{
		
		//BeanListHandler的应用      【多行处理器】
//		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
//		String sql = "SELECT * FROM stu";
//		List<Stu> stuList = qr.query(sql, new BeanListHandler<Stu>(Stu.class));
//		System.out.println(stuList);
		
		//MapHandler的应用      【单行处理器】
//		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
//		String sql = "SELECT * FROM stu WHERE sid=?";
//		Object[] params = {10001};
//		Map map = qr.query(sql, new MapHandler(),params);
//		System.out.println(map);
		
		//MapListHandler的应用      【多行处理器】
//		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
//		String sql = "SELECT * FROM stu";
//		List<Map<String,Object>> maplist = qr.query(sql, new MapListHandler());
//		System.out.println(maplist);
		
		//ScalarHandler处理器      【单行单列时使用最为合适】
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "SELECT COUNT(*) FROM stu";
		Number cnt = (Number)qr.query(sql, new ScalarHandler());
		long c = cnt.longValue();
		System.out.println(c);
		
	}

}
