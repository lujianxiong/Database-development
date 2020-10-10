package com.daxiong.jdbc.client;

import java.sql.Date;
import java.util.List;
import com.daxiong.jdbc.dao.EmpDAO;
import com.daxiong.jdbc.dao.impl.EmpDAOImpl;
import com.daxiong.jdbc.entity.Emp;

//客户端（main方法入口）
public class Client {
	public static void main(String[] args) {
		EmpDAO empDAO = new EmpDAOImpl();
		
		//输出所有的emp的信息
		//List<Emp> list = empDAO.findAll();
		
		//查询10号部门的信息
//		List<Emp> list = empDAO.findEmpByDept(10);  
//		for (Emp emp : list) {
//			System.out.println(emp);  //自动调用我们覆写的Emp类中的toString()方法
//		}
		//System.out.println(empDAO.updateEmp(new Emp(7937,"张三丰","Java开发工程师",10000))>0?"更新成功":"更新失败");
		
//作业1：查询员工中所有张姓员工
//        List<Emp> listByName=empDAO.findEmpByName("张");
//        for(Emp emp:listByName){
//            System.out.println(emp);
//        }
        
//作业2：删除指定编号编号的员工信息        
//		if(empDAO.deleteEmp(369)>0){
//            System.out.println("删除成功");
//        }else
//            System.out.println("删除失败");
        

//作业3：新增一条员工记录		
//		if (empDAO.addEmp(new Emp(369, "名字", "CLEARK", 7709, new Date(System.currentTimeMillis()), 1000, 0, 20)) > 0) {
//            System.out.println("添加成功");
//        } else {
//            System.out.println("添加失败");
//        }
		
//作业4：查询指定页码的员工信息(默认一页5条记录，控制台输入2，显示第二项记录，提示limit)		
//		List<Emp> listByPage=empDAO.findEmpByPage(2);
//        for(Emp emp:listByPage){
//            System.out.println(emp);
//        }
		
	}
}
