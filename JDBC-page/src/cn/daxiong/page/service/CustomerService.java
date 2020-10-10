package cn.daxiong.page.service;
//业务层
public class CustomerService {
	private CustomerDao customerDao = new CustomerDao();
	
	//添加用户
	public void add(Customer c) {
		customerDao.add(c);
	}
	
	//查询所有
	public PageBean<Customer> findAll(int pc,int ps){
		return customerDao.findAll(pc,ps);
	}
	
	//加载客户
	public CustomerService load(String cid) {
		return customerDao.load(cid);
	}
	
	//编辑客户
	public void edit(Customer c) {
		customerDao.edit(c);
	}
	
}
