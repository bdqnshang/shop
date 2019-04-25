package bdqn.ssm.dao.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import bdqn.ssm.dao.UserDao;

public class UserDaoImpl implements UserDao{
    //1.加载配置文件  -->原材料
	//2.创建工厂       -->产品加工工厂
	//3.获取会话session-->一次生产事件
	@Override
	public int getUserCount() {
		int rel=0;
		String mybaticfile="mybatis_config.xml";
	    InputStream is;
	    SqlSession session=null;
		try {
			is = (InputStream)Resources.getResourceAsStream(mybaticfile);
			 SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
			 session=factory.openSession();
			 rel=session.selectOne("bdqn.mybatis.example.userMapper.getUserCount");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		return rel;
	}
}