import mapper.CatchMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.Employee;
import utils.SqlSessionUtils;

import java.io.IOException;
import java.io.InputStream;

public class CatchTest {
    @Test
    public void TestFirstLevelCatch(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CatchMapper catchMapper = sqlSession.getMapper(CatchMapper.class);
        Employee employee1 = catchMapper.getEmpById(2);
        System.out.println(employee1);
        sqlSession.clearCache();
        Employee employee2 = catchMapper.getEmpById(2);
        System.out.println(employee2);

    }


    @Test
    public void TestSecondLevelCatch() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory factory = builder.build(is);
        SqlSession sqlSession1 = factory.openSession(true);
        CatchMapper catchMapper1 = sqlSession1.getMapper(CatchMapper.class);
        Employee emp1 = catchMapper1.getEmpById(3);
        System.out.println(emp1);
        sqlSession1.close();

        SqlSession sqlSession2 = factory.openSession(true);
        CatchMapper catchMapper2 = sqlSession2.getMapper(CatchMapper.class);
        Employee emp2 = catchMapper2.getEmpById(3);
        System.out.println(emp2);
        sqlSession2.close();
    }


    public static void add(Integer x,String y,StringBuffer z){
        x = x+1;
        y = y+"x";
        z = z.append('x');
    }

    public static void main(String[] args) {
        Integer x = 1;
        String y = "1";
        StringBuffer z = new StringBuffer("1");
        add(x,y,z);
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }
}
