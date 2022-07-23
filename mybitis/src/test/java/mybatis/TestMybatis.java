package mybatis;

import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestMybatis {
    @Test
    public void testInsert() throws IOException {
        //获取核心配置文件的字节输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //创建 SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory
        SqlSessionFactory factory = builder.build(is);
        //获取sql的会话对象，mybatis提供的数据库操作对象
        SqlSession sqlSession = factory.openSession();
        //获取UserMapper的代理实例化对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //执行操作
        int i = userMapper.insertUser();
        //提交事务(这里不会自动提交，如果不提交会自动回滚)
        sqlSession.commit();
        System.out.println(i);
        is.close();
        sqlSession.close();
    }
}
