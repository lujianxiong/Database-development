package cn.daxiong.dbutils;

import java.sql.ResultSet;

import cn.daxiong.jdbc.JdbcUtils;

public class Demo2 {

	public static void main(String[] args) {
		Stu stu = new Stu(10001, "宋妍霏",1,"女");
		addStu(stu);
		
//		Stu stu = selcetStu(10001);
//		System.out.println(stu);
	}
	
	public static void addStu(Stu stu) {
		@SuppressWarnings("rawtypes")
		QR qr = new QR(JdbcUtils.getDataSource());    //创建时给出连接池
		String sql = "INSERT INTO stu VALUES(?,?,?,?)";    //给出sql模板
		Object[] params = {stu.getSid(),stu.getSname(),stu.getAge(),stu.getGender()};    //给出参数
		qr.update(sql, params);    //调用update，执行增、删、改
	}


	@SuppressWarnings("unchecked")
	public static Stu selcetStu(int sid) {
		@SuppressWarnings("rawtypes")
		QR qr = new QR(JdbcUtils.getDataSource());     //创建时给出连接池
		String sql = "SELECT * from stu WHERE sid=?";    //给出sql模板
		Object[] params = {sid};
		
		RsHandler<Stu> rh = new RsHandler<Stu>() {
			public Stu handle(ResultSet rs) throws Exception{
				if(!rs.next()) return null;
				Stu stu = new Stu();
				stu.setSid(rs.getInt("sid"));
				stu.setSname(rs.getString("sname"));
				stu.setAge(rs.getInt("age"));
				stu.setGender(rs.getString("gender"));
				return stu;
			}
		};
		return (Stu)qr.query(sql, rh, params);
	}
}
