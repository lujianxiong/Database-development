package cn.daxiong.jdbc;

public class Demo1 {
	private static AccountDao dao = new AccountDao();
	
	public static void main(String[] args) throws Exception {
		serviceMethod();
	}
	
	public static void serviceMethod() throws Exception{
		try {
			JdbcUtils.beginTransaction();
			dao.update("zs", -100);
			dao.update("ls", 100);
			JdbcUtils.commitTransaction();
		} catch (Exception e) {
			try {
				JdbcUtils.rollbackTransaction();
			} catch (Exception e2) {
				e.printStackTrace();
			}
		}
	}

}
