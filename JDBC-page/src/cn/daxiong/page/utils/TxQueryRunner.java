package cn.daxiong.page.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

//这个类中的方法，自己来处理连接问题
//通过JdbcUtils.getConnection()得到连接!有可能是事务连接，有可能是普通的连接！
//JdbcUtils.releaseConnection()完成对连接的释放，如果是普通连接就关闭！
public class TxQueryRunner extends QueryRunner {

	@Override
	public int[] batch(String sql, Object[][] params) throws SQLException {
		//1、得到连接
		Connection con;
		try {
			con = JdbcUtils.getConnection();
			int[] results = super.batch(con,sql, params);
			//3、释放连接
			JdbcUtils.releaseConnection(con);
			//4、返回值
			return results;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2、执行父类方法,传递连接对象
		return null;
	}

	@Override
	public <T> T query(String sql, Object param, ResultSetHandler<T> rsh) throws SQLException {
		// 1、得到连接
		Connection con;
		try {
			con = JdbcUtils.getConnection();
			// 2、执行父类方法,传递连接对象
			T results = super.query(con, sql, param, rsh);
			// 3、释放连接
			JdbcUtils.releaseConnection(con);
			// 4、返回值
			return results;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public <T> T query(String sql, Object[] params, ResultSetHandler<T> rsh) throws SQLException {
		// 1、得到连接
		Connection con;
		try {
			con = JdbcUtils.getConnection();
			// 2、执行父类方法,传递连接对象
			T results = super.query(con, sql, params, rsh);
			// 3、释放连接
			JdbcUtils.releaseConnection(con);
			// 4、返回值
			return results;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
		// 1、得到连接
		Connection con;
		try {
			con = JdbcUtils.getConnection();
			// 2、执行父类方法,传递连接对象
			T results = super.query(con, sql, rsh, params);
			// 3、释放连接
			JdbcUtils.releaseConnection(con);
			// 4、返回值
			return results;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
		// 1、得到连接
		Connection con;
		try {
			con = JdbcUtils.getConnection();
			// 2、执行父类方法,传递连接对象
			T results = super.query(con, sql, rsh);
			// 3、释放连接
			JdbcUtils.releaseConnection(con);
			// 4、返回值
			return results;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int update(String sql, Object... params) throws SQLException {
		// 1、得到连接
		Connection con;
		try {
			con = JdbcUtils.getConnection();
			// 2、执行父类方法,传递连接对象
			int results = super.update(con, sql, params);
			// 3、释放连接
			JdbcUtils.releaseConnection(con);
			// 4、返回值
			return results;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(String sql, Object param) throws SQLException {
		// 1、得到连接
		Connection con;
		try {
			con = JdbcUtils.getConnection();
			// 2、执行父类方法,传递连接对象
			int results = super.update(con, sql, param);
			// 3、释放连接
			JdbcUtils.releaseConnection(con);
			// 4、返回值
			return results;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(String sql) throws SQLException {
		// 1、得到连接
		Connection con;
		try {
			con = JdbcUtils.getConnection();
			// 2、执行父类方法,传递连接对象
			int results = super.update(con, sql);
			// 3、释放连接
			JdbcUtils.releaseConnection(con);
			// 4、返回值
			return results;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
