package com.daxiong.jdbc.dao;
//数据访问层接口（接口设计）
import java.util.List;
import com.daxiong.jdbc.entity.Emp;

public interface EmpDAO {
	
	List<Emp> findAll();  //查询所有员工信息
	
	List<Emp> findEmpByDept(int deptno);  //根据部门编号进行查询
	
	int updateEmp(Emp emp);    //输入新的员工的信息，返回受影响的行数
	
	//作业1：查询员工中所有张姓员工
	List<Emp> findEmpByName(String name);
	
	//作业2：删除指定编号编号的员工信息
	int deleteEmp(int empno);
	
	//作业3：新增一条员工记录
	int addEmp(Emp emp);
	
	//作业4：查询指定页码的员工信息(默认一页5条记录，控制台输入2，显示第二项记录，提示limit)
	List<Emp> findEmpByPage(int page);

}
