package mybatis;

import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.User;
import utils.SqlSessionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
        //SqlSession sqlSession = factory.openSession(true);设置自动提交事务
        //还有一种写法，可以直接通过SqlSession对象来执行sql语句，所以写法如下：
        //sqlSession.insert("mapper.UserMapper.insertUser");需要提sql的唯一标识，即映射文件的namespace + id，这种方式就不再需要UserMapper接口了
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

    @Test
    public void testDelete(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser();
        sqlSession.close();
    }

    @Test
    public  void testSelectById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById();
        System.out.println(user);
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getAll();
        for(User user:userList){
            System.out.println(user);
        }
    }
}
