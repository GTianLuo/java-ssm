import mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Employee;
import utils.SqlSessionUtils;

import java.util.ArrayList;
import java.util.List;

public class DynamicMapperTest {

    @Test
    public void TestIf(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee emp = new Employee();
        emp.setAge(21);
        List<Employee> empList = employeeMapper.getEmpDynamicSql(emp);
        empList.forEach(System.out::println);
    }
    @Test
    public void  TestAddEmpList(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(null,"编号2",32,"男"));
        list.add(new Employee(null,"编号3",32,"男"));
        list.add(new Employee(null,"编号4",32,"男"));
        employeeMapper.addEmpList(list);
    }

    @Test
    public void TestDelEmpByIdArray(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        employeeMapper.delEmpByIdArray(new Integer[]{5,6,7});
    }
}
