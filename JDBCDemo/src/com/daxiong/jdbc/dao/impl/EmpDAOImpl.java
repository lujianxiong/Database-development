package com.daxiong.jdbc.dao.impl;
//数据访问层实现类
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.daxiong.jdbc.dao.EmpDAO;
import com.daxiong.jdbc.entity.Emp;
import com.daxiong.jdbc.util.JDBCUtil;

public class EmpDAOImpl implements EmpDAO{
	private Connection connection = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	List<Emp> emps = new ArrayList<>();

	@Override
	public List<Emp> findAll() {
		try {
			//利用JDBCUtil获取连接对象
			connection = JDBCUtil.getConnection();
			String sql = "select empno,ename,job,sal from emp";
			//执行SQL语句
			psmt = connection.prepareStatement(sql);
			rs = psmt.executeQuery();
			//解析结果
			while(rs.next()) {
				int empno = rs.getInt(1);
				String ename = rs.getString(2);
				String job = rs.getString(3);
				double sal = rs.getDouble(4);
				//每循环一次，new一个新的对象
				Emp emp = new Emp(empno,ename,job,sal);  //new一个Emp对象并将上面的属性赋值
				//往集合中添加元素
				emps.add(emp);
			}
			return emps;    //返回集合
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				JDBCUtil.close(rs,psmt,connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;   //如果上面语句正常执行就返回了emps，如果出了异常就返回null
	}

	
	@Override
	public List<Emp> findEmpByDept(int deptno) {
		try {
			connection = JDBCUtil.getConnection();
			//使用？占位符进行传参
			String sql = "select empno,ename,job,sal from emp where deptno=?";    //注意：“=”前面不能有空格，并且“?”是英文的，切记
			psmt = connection.prepareStatement(sql);
			//替换占位符
			psmt.setInt(1, deptno);  //第一个参数是占位符的索引；第二个参数是我们真实传的参数值
			rs = psmt.executeQuery();

			while(rs.next()) {
				int empno = rs.getInt(1);
				String ename = rs.getString(2);
				String job = rs.getString(3);
				double sal = rs.getDouble(4);
				
				Emp emp = new Emp(empno,ename,job,sal); 
				emps.add(emp);
			}
			return emps; 
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				JDBCUtil.close(rs,psmt,connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;  
  }


	//更新操作：insert delete update
	@Override
	public int updateEmp(Emp emp) {
		try {
			connection = JDBCUtil.getConnection();
			String sql = "update emp set ename=?,job=?,sal=? where empno=?";    //根据编号去更新名字、职位、薪水
			psmt = connection.prepareStatement(sql);
			//替换占位符
			psmt.setString(1, emp.getEname());
			psmt.setString(2, emp.getJob());
			psmt.setDouble(3, emp.getSal());
			psmt.setInt(4, emp.getEmpno());
			return psmt.executeUpdate();  // 更新操作使用 executeUpdate();   这个操作返回的操作的行数
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JDBCUtil.close(null, psmt, connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}


	@Override
	public List<Emp> findEmpByName(String name) {
		try {
			connection = JDBCUtil.getConnection();
			String nameTempString = "%"+name+"%";  //模糊查询
			String sql = "select * from emp where ename like ?";
			psmt = connection.prepareStatement(sql);
			psmt.setString(1, nameTempString);
			rs = psmt.executeQuery();
			while(rs.next()) {
				emps.add(getEmpFromDB(rs));
			}
			return emps;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JDBCUtil.close(rs, psmt, connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	private Emp getEmpFromDB(ResultSet rs) throws SQLException {
        int empno=rs.getInt(1);
        String ename=rs.getString(2);
        String job=rs.getString(3);
        int mgr=rs.getInt(4);
        Date hiredate=rs.getDate(5);
        double sal=rs.getDouble(6);
        double comm=rs.getDouble(7);
        int depno=rs.getInt(8);
        Emp emp=new Emp(empno,ename,job,mgr,hiredate,sal,comm,depno);
        return emp;
    }


	@Override
	public int deleteEmp(int empno) {
        try {
        	connection=JDBCUtil.getConnection();
            String sql="delete from emp where empno=?";
            psmt=connection.prepareStatement(sql);
            psmt.setInt(1,empno);
            return psmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
				JDBCUtil.close(null,psmt,connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return 0;
	}


	@Override
	public int addEmp(Emp emp) {
        try {
        	connection=JDBCUtil.getConnection();
            String sql="insert into emp values(?,?,?,?,?,?,?,?)";
            psmt=connection.prepareStatement(sql);
            psmt.setInt(1,emp.getEmpno());
            psmt.setString(2,emp.getEname());
            psmt.setString(3,emp.getJob());
            psmt.setInt(4,emp.getMgr());
            psmt.setDate(5,(java.sql.Date) emp.getHiredate());
            psmt.setDouble(6,emp.getSal());
            psmt.setDouble(7,emp.getComm());
            psmt.setInt(8,emp.getDepno());
            return psmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
				JDBCUtil.close(rs,psmt,connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return 0;
	}


	@Override
	public List<Emp> findEmpByPage(int page) {
        try {
        	connection=JDBCUtil.getConnection();
            String sql="select * from emp limit ?,?";
            psmt=connection.prepareStatement(sql);
            psmt.setInt(1,5*(page-1));
            psmt.setInt(2,5);
            rs=psmt.executeQuery();
            while (rs.next()){
                emps.add(getEmpFromDB(rs));
            }
            return emps;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
				JDBCUtil.close(rs,psmt,connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return null;
	}
}
