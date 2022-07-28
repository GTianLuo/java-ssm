package mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;
import java.util.Map;

/*
    1.当查询结果有多条时，不能拿实体类来接收。mybatis会将多条查询结果放到list集合中，我们需要拿List集合来接收

    2.当查询结果不是实体类的时候我们可以拿Map作为返回类型,一条记录对应一个Map对象。字段名为key，查询结果为value

    3.当查询结果不是实体类并且查询结果有多条时我们有两种处理方式
        (1)将每一条记录作为一个Map集合，然后将Map集合放到List集合中返回。
        (2)将每一条记录作为一个Map集合，然后通过注解@Mapkey将查询的某个字段作为key，将每条记录的对应map集合放到一个更大的集合中。
           注：这里当作key的字段必须是查询结果的某一字段

    4.模糊查询是不能直接使用#{}，可以直接使用${}
        select *from t_user where name like '%#{x}%';会被编译成select *from t_user where name like '%?%';这里的？在引号里面，不能当作占位符处理
        select * from t_user where username like '%${x}%';会被编译成select * from t_user where username like '%J%'
        如果想要使用#{}我们可以使用mysql的字符串拼接函数,select * from t_user where username like concat('%',#{x},'%')
        我们也可以直接拼接：select *from t_user where username like "%"#{x}"%" 这里必须使用双引号

 */
public interface SelectMapper {
    /**
     * 查询某一字段的count
     */
    int getCount();

    /**
     * 查询所有用户的名字和邮箱
     */
    List<Map<String,Object>> getNameAndEmail();

    /**
     * 查询所有用户的名字和邮箱
     */
    @MapKey("id")
    Map<String,Object> getNameAndEmail1();


    /**
     * 使用模糊查询，查询名字中有含有某一字符的用户
     */
    List<User> getNameVague(@Param("x") char x);
}

