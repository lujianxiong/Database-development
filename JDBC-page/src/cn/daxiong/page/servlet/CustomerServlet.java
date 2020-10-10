package cn.daxiong.page.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.daxiong.page.entity.PageBean;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CustomerService customerService = new CustomerService();
	
	//添加客户
	public String add(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		
	}
	
	//查询所有
	public String findAll(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		//1、获取页面传递的pc
		//如果pc参数不存在，则pc=1
		//如果pc参数存在，需要转换成int类型
		int pc = getPc(request);    //得到pc
		//2、给定ps的值
		int ps = 10;    //每页10行记录
		//3、调用service方法，传参pc和ps，得到PageBean，保存到request域
		PageBean<Customer> pb = customerService.findAll(pc,ps);
		//4、转发到list.jsp
		 request.setAttribute("pb", pb);    //将service方法返回的PageBean保存到request域中
		 return "";  //转发到list.jsp
	}
	
	//获取pc
	private int getPc(HttpServletRequest request) {
		String value = request.getParameter("pc");
		if (value == null || value.trim().isEmpty()) {
			return 1;
		}
		return Integer.parseInt(value);
	}
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
