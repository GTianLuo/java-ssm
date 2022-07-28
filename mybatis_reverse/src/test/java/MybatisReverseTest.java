import com.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.EmployeeMapper;
import com.pojo.Employee;
import com.pojo.EmployeeExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisReverseTest {
    /**
     * 根据条件查询
     */
    @Test
    public void testExample() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        EmployeeExample example = new EmployeeExample();

        //根据条件查询
        example.createCriteria().andAgeBetween(20,25);
        //or可以拼接查询条件
        example.or().andGenderEqualTo("男");
        List<Employee> employees = employeeMapper.selectByExample(example);
        System.out.println(employees);

        //普通的根据主键修改
        //普通修改如果遇见null的话会直接拿null覆盖掉原数据
        Employee employee = new Employee(3,"张三",23,null,null);
        employeeMapper.updateByPrimaryKey(employee);


        //选择性修改
        employee = new Employee(4,null,33,null,null);
        employeeMapper.updateByPrimaryKeySelective(employee);
    }



    @Test
    public void TestPageHelper() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        //在查询之前创建，它就会拦截待执行sql，并对sql进行重写
        Page<Object> page = PageHelper.startPage(1, 4);
        List<Employee> employees = employeeMapper.selectByExample(null);
        PageInfo pageInfo = new PageInfo(employees,3);
        System.out.println(pageInfo);

    }
}
