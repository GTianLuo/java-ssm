package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtils {
    public static SqlSession getSqlSession(){
        //获取核心配置的输入流
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            //创建SqlSession工厂对象的builder对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //获取工厂对象
            SqlSessionFactory factory = builder.build(is);
            //获取sqlSession对象
            SqlSession sqlSession = factory.openSession(true);
            return sqlSession;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  null;

    }
}
