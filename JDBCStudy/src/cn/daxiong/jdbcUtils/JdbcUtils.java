package cn.daxiong.jdbcUtils;
//v1.0
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JdbcUtils {
	private static Properties props = null;
	
	//静态代码块中的内容只在JdbcUtils类被加载的时候执行一次！
	static {
		try {
			// 1、加载配置文件
			InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("dbconfig.properties"); // 将配置文件中的内容加载到流中
			props = new Properties();
			props.load(in); // 将流加载到props
			// 2、加载驱动类
			Class.forName(props.getProperty("jdbc.driver")); // 通过props.getProperty()方法传入键，获取值
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws Exception {
		// 3、得到Connection
		return DriverManager.getConnection(props.getProperty("jdbc.url"), props.getProperty("jdbc.username"),
				props.getProperty("jdbc.password"));
	}

}
