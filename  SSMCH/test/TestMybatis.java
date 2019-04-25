import org.junit.Test;

import bdqn.ssm.dao.UserDao;

import bdqn.ssm.dao.impl.UserDaoImpl;

public class TestMybatis {
	@Test
	public void testGetUserCount(){
		UserDao userDao=new UserDaoImpl();
		int count=userDao.getUserCount();
		System.out.println(count);		
	}
}
