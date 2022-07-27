import mapper.DeptMapper;
import mapper.EmpMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Dept;
import pojo.Employee;
import utils.SqlSessionUtils;

import java.util.List;


public class ResultMapTest {

    @Test
    public void testGetAllEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Employee> employeeList = empMapper.getAllEmp();
        employeeList.forEach(System.out::println);
    }

    @Test
    public void testGetAllEmpAndDeptOne(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Employee> employeeList = empMapper.getAllEmpAndDeptOne();
        employeeList.forEach(System.out::println);
    }

    @Test
    public void testGetAllEmpAndDeptTwo(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Employee> employeeList = empMapper.getAllEmpAndDeptTwo();
        employeeList.forEach(System.out::println);
    }

    @Test
    public void testGetAllEmpAndDeptByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Employee> employeeList = empMapper.getAllEmpAndDeptByStep();
        employeeList.forEach((Employee employee) ->{
            System.out.println(employee.getEmpName());
        });
    }


    @Test
    public void testGetAllDeptAndEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        List<Dept> allDeptAndEmp = deptMapper.getAllDeptAndEmp();
        allDeptAndEmp.forEach(System.out::println);
    }

    @Test
    public void testGetAllDeptAndEmpByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        List<Dept> allDeptAndEmp = deptMapper.getAllDeptAndEmpByStep();
        allDeptAndEmp.forEach(System.out::println);
    }
}
