package cn.daxiong.dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class QR<T> {
	private DataSource dataSource;
	
	public QR() {
		super();
	}
	public QR(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	//进行insert、update、delete
	public int update(String sql,Object... params) {
		Connection con = null;
		PreparedStatement psmt = null;
		try {
			con = dataSource.getConnection();    //通过连接池得到连接对象
			psmt = con.prepareStatement(sql);    //传sql创建psmt
			initParams(psmt,params);    //设置参数
			return psmt.executeUpdate();    //执行，并返回影响的行数
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			try {
				if (psmt !=null) psmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
	}
	
	//给参数赋值
	private void initParams(PreparedStatement psmt,Object...params) throws Exception{
		for (int i = 0; i < params.length; i++) {
			psmt.setObject(i+1, params[i]);
		}
	}
	
	
	//进行select查询
	public T query(String sql,RsHandler<T> rh,Object... params) {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();    //通过连接池得到连接对象
			psmt = con.prepareStatement(sql);    //传sql创建psmt
			initParams(psmt,params);    //设置参数
			rs = psmt.executeQuery();    //执行，并返回结果集
			return rh.handle(rs);   
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			try {
				if (psmt !=null) psmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
	}
}

//用来把结果集转换成需要的类型！
interface RsHandler<T>{
	public T handle(ResultSet rs) throws Exception;
}
