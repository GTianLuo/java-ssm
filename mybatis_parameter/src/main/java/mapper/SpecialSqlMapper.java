package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;



/*
    1.批量删除方式如下：
       delete from t_user where id in (${ids}) 这里的${}不用加引号，因为这里的是按id删除，id是Integer类型
       上面删除语句样例编译之后转化为：delete from t_user where id in (1,2)
       注：这里不能使用#{}，因为#{}会自动加引号

    2.动态设置表名，这里不能使用#{}，因为表名不能加引号的。

    3.添加用户时获取自增的主键
    <!-- void addUser(User  user);-->
    <!--
         useGeneratedKeys:是否使用了自增的主键
         keyProperty：将自增主键的value放到哪个实例类型的哪个属性
    -->
    <insert id="addUser" useGeneratedKeys="true" keyProperty="id">
        insert into t_user values(null,#{username},#{password},#{age},#{gender},#{email});
    </insert>

 */
public interface SpecialSqlMapper {
    /**
     * 通过id进行批量删除
     * @param ids
     */
    void deleteMoreUser(String ids);


    /**
     * 动态设置表名进行查询
     */
    List<User> getUserList(@Param("tableName") String tableName);


    /**
     * 添加用户并且获取自增的主键
     */
    void addUser(User  user);
}
