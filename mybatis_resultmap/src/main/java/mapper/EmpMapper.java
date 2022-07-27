package mapper;

import pojo.Employee;

import java.util.List;


/*
    1.当实体类中的属性名和sql表中的字段名不一致时，有三种解决方案
        (1)在sql语句中为字段名起别名
        (2)全局配置，将下划线转化为驼峰
        <settings>
            <setting name="mapUnderscoreToCamelCase" value="true"/>
        </settings>
        (3)在映射文件中通过ResultMap设置自定义的映射关系
        <!--
        resultMap的属性：
        id:该映射的唯一标识
        type：处理映射关系的实体类的类型。

        内部标签：
        id：处理主键和实体类属性的映射关系
        result：处理普通字段和实体类属性的映射关系
                column:字段名   property:映射的属性名

        <resultMap id="empResultMap" type="pojo.Employee">
            <id column="emp_id" property="empId"></id>
            <result column="emp_name" property="empName"></result>
        </resultMap>


     2.多对一查询:第一张表中的一条记录只能对应第二张表的一条记录，第一张表中的多条记录可能对应了第二张表的同一条记录
        (1)级联
        (2)使用association处理多对一的查询映射关系
        (3)同样是使用association进行处理，但是使用分步查询

     3.一对多查询:第一张表中的一条记录可能对应第二张表的多条记录
        (1)使用collection标签处理多对一
        (2)使用分步查询
*/

public interface EmpMapper {

    /**
     * 查寻所有员工
     */
    List<Employee> getAllEmp();

    /**
     * 查询所以员工及其部门编号(使用级联的方式)
     */
    List<Employee> getAllEmpAndDeptOne();

    /**
     * 查询所以员工及其部门编号(在ResultMap中使用association标签)
     */
    List<Employee> getAllEmpAndDeptTwo();

    /**
     * 查询所有员工及其部门编号(使用分布查询的方式)
     */
    List<Employee> getAllEmpAndDeptByStep();

    /**
     * 查询指定部门的员工
     */
    List<Employee> getEmpByDept();
}
