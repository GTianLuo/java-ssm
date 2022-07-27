package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Dept;

import java.util.List;

public interface DeptMapper {
    /**
     * 通过dept_id来查询某个部门的信息
     */
    Dept getDeptById(@Param("deptId") int deptId);

    /**
     * 查询所有部门信息以及部门下的员工信息(使用collection标签)
     */
    List<Dept> getAllDeptAndEmp();

    /**
     * 查询所有部门信息以及部门下的员工信息(使用分步查询)
     */
    List<Dept> getAllDeptAndEmpByStep();


}
