package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;
import java.util.Map;

/**
 * mybatis获取参数有两种方式#{}和${}
 * #{}：本质是占位符传值
 * ${}：本质是字符串拼接
 * 1.当mapper接口中的参数为单个字面量可以通过这两种方式获取参数
 *    #{}和${}都可以以任意内容接受参数，但是要注意的是${}要加单引号，并且里面不要加数字
 *
 * 2.当mapper接口有多个字面量参数时，{}内的内容不能继续随意写了，mybatis会将参数保存在map集合当中,有以下两种方式
 * (1)以(arg0,arg1,arg2......)为key，以参数值为value
 * (2)以(param1,param2,param3......)为key，以参数值为value
 *
 * 3.当mapper接口有多个字面量参数时，mybatis会将参数放到map集合中，同样的我们也可以手动将参数放到map集合中，然后将map集合作为参数传入
 *
 * 4.当mapper接口的参数值为实体类时，我们任然可以直接根据#{}和${}来访问实体类中的属性(有get方法的成员变量)
 *
 *5.我们可以使用mapper接口的参数上使用Param注解，此时mybatis会将参数放到map集合中，并且会以两种形式来存储
 * (1)以Param注解中的value作为键，以参数做为value放入map集合
 * (2)以Param1，Param2......作为键，以参数作为value放入map集合
 *
 */
public interface UserMapper {
    /**
     * 通过名字查询用户信息
     * @return
     */
    List<User> selectByName(String username);

    /**
     * 通过用户名和密码查询登录是否成功
     */
    User login(String username, String password);

    /**
     * 通过自己创建的map来进行登录
     */
    User loginByMap(Map<String,Object> map);

    /**
     * 增加一个新的用户
     */
    void addUser(User user);


    /**
     *利用注解来添加一个新用户
     */
    User  loginByParam(@Param("username")String username,@Param("password") String password);
}
