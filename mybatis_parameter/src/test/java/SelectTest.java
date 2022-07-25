import mapper.SelectMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.SqlSessionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectTest {
    @Test
    public void testgetCount(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        int count = selectMapper.getCount();
        System.out.println(count);
    }


    @Test
    public void testSelectNameAndEmail(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        List<Map<String, Object>> nameAndEmail = selectMapper.getNameAndEmail();
        for(Map<String,Object> map:nameAndEmail){
            System.out.println(map);
        }
    }



    @Test
    public void testSelectNameAndEmail1(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> nameAndEmail = selectMapper.getNameAndEmail1();
        for(Map.Entry entry :nameAndEmail.entrySet()){
            System.out.println(entry.getKey() + ":  "+ entry.getValue());
        }
    }
}
