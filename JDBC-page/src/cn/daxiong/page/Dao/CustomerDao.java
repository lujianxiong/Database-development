package cn.daxiong.page.Dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.daxiong.page.entity.PageBean;
import cn.daxiong.page.utils.TxQueryRunner;

public class CustomerDao {
	QueryRunner qr = new TxQueryRunner();
	
	
	
	
	//查询所有
	public PageBean<Customer> findAll(int pc,int ps){
		try {
			//1、创建PageBean对象
			PageBean<Customer> pb = new PageBean<Customer>();
			
			//2、设置pb的pc和ps
			pb.setPc(pc);
			pb.setPs(ps);
			
			//3、得到tr，设置pb的tr
			String sql = "SELECT COUNT(*) FROM customer";
			Number num = (Number)qr.query(sql,new ScalarHandler());
			int tr = num.intValue();
			pb.setTr(tr);
			
			//4、得到beanList，设置pb的beanList
			sql = "SELECT *FROM customer LIMIT ?,?";
			//如果是第三页，数据是从20开始，如果当前页是第1页，就从0开始，第2页是从11，12，13....开始
			List<Customer> beanList = qr.query(sql, new BeanListHandler<CustomerDao.class>,(pc-1)*ps,ps);
			pb.setBeanList(beanList);
			//返回pb
			return pb;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
