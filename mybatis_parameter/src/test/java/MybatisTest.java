import mapper.SelectMapper;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import utils.SqlSessionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {
    @Test
    public void testSelectByName(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.selectByName("Joke");
        for(User user:list){
            System.out.println(user);
        }
    }

    @Test
    public void testLogin(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.login("Joke1","111111");
        sqlSession.close();
    }


    @Test
    public void testLoginByMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("username","Joke1");
        map.put("password","111111");
        User user = userMapper.loginByMap(map);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testAddUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.addUser(new User(null,"Mark","111111",22,"M","6699904401@qq.com"));
        sqlSession.close();
    }

    @Test
    public void testLoginByParam(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.loginByParam("Mark","111111");
        System.out.println(user);
        sqlSession.close();
    }


}
