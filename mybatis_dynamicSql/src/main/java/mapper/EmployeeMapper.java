package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Employee;

import java.util.List;

public interface EmployeeMapper {

    /**
     * 根据年龄和性别进查询用户
     */
    List<Employee> getEmpDynamicSql(Employee emp);

    /**
     * 批量添加
     */
    void addEmpList(@Param("emps") List<Employee> emps);


    /**
     * 实现批量删除
     */
    void delEmpByIdArray(@Param("empIds") Integer[] empIds);

}
