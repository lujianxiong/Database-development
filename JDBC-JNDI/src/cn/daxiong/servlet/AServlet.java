package cn.daxiong.servlet;
//获取JNDI资源
import java.io.IOException;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class AServlet
 */
@WebServlet("/AServlet")
public class AServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1、创建JNDI的上下文对象
			Context cxt = new InitialContext();
//			//2、查找出入口
//			Context envContext = (Context) cxt.lookup("java:comp/env");
//			//3、进行二次查找，找到我们的资源
//			//使用的名称与<Resource>元素的name对应
//			DataSource dataSource = (DataSource) envContext.lookup("jdbc/dataSource");
			
			//2、3、将两次查询放在一起
			DataSource dataSource = (DataSource)cxt.lookup("java:comp/env/jdbc/dataSource");
			
			//4、通过资源配置文件来连接数据库，获取Connection
			Connection con = dataSource.getConnection();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
