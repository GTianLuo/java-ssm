import mapper.SelectMapper;
import mapper.SpecialSqlMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import utils.SqlSessionUtils;

import java.util.List;

public class SpecialSqlTest {
    @Test
    public void testdeleteUserMore(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialSqlMapper specialSqlMapper = sqlSession.getMapper(SpecialSqlMapper.class);
        specialSqlMapper.deleteMoreUser("1,2");
    }

    @Test
    public void testGetUserList(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialSqlMapper specialSqlMapper = sqlSession.getMapper(SpecialSqlMapper.class);
        List<User> userList = specialSqlMapper.getUserList("t_user");
        userList.forEach(System.out::println);
    }


    @Test
    public void testAddUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialSqlMapper specialSqlMapper = sqlSession.getMapper(SpecialSqlMapper.class);
        User user = new User(null,"张三","12345678",21,"男","2985496686@qq.com");
        specialSqlMapper.addUser(user);
        System.out.println(user);
    }
}
