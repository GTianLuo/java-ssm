package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Employee;


/*
    1.一级缓存：一级缓存是SqlSession级别的，它会将查过的数据进行缓存，当下次查询相同的数据时会直接从缓存中获取。
      一级缓存注意点：
      （1）一个SqlSession对应一个一级缓存。
      （2）两次SqlSession查询期间对表进行了增删改，一级缓存就会失效。
      （3）我们可以通过sqlSession.clearCache();手动清空缓存。

    2.二级缓存：二级缓存是SqlSessionFactory级别的，通过同一个SqlSessionFactory创建的SqlSession查询的结果会被缓存；此后若再次执行相同的查询语句，结果就会从缓存中获取
       二级缓存开启条件：
        a>在核心配置文件中，设置全局配置属性cacheEnabled="true"，默认为true，不需要设置
        b>在映射文件中设置标签<cache/>
        c>在SqlSession关闭或提交之后有效，一级缓存才能转换为二级缓存
        d>查询的数据所转换的实体类类型必须实现序列化的接口
        使二级缓存失效的情况：
        两次查询之间执行了任意的增删改，会使一级和二级缓存同时失效

        二级缓存的相关配置
        在mapper配置文件中添加的cache标签可以设置一些属性：
        ①eviction属性：缓存回收策略，默认的是 LRU。
            LRU（Least Recently Used） – 最近最少使用的：移除最长时间不被使用的对象。
            FIFO（First in First out） – 先进先出：按对象进入缓存的顺序来移除它们。
            SOFT – 软引用：移除基于垃圾回收器状态和软引用规则的对象
            WEAK – 弱引用：更积极地移除基于垃圾收集器状态和弱引用规则的对象。

        ②flushInterval属性：刷新间隔，单位毫秒
            默认情况是不设置，也就是没有刷新间隔，缓存仅仅调用语句时刷新

        ③size属性：引用数目，正整数
            代表缓存最多可以存储多少个对象，太大容易导致内存溢出

        ④readOnly属性：只读， true/false
            true：只读缓存；会给所有调用者返回缓存对象的相同实例。因此这些对象不能被修改。这提供了 很重要的性能优势。
            false：读写缓存；会返回缓存对象的拷贝（通过序列化）。这会慢一些，但是安全，因此默认是false。


         Mybatis缓存查询顺序
            先查询二级缓存，因为二级缓存中可能会有其他程序已经查出来的数据，可以拿来直接使用。
            如果二级缓存没有命中，再查询一级缓存
            如果一级缓存也没有命中，则查询数据库
            SqlSession关闭之后，一级缓存中的数据会写入二级缓存

 */
public interface CatchMapper {
    /**
     * 通过id查询用户信息(用来验证一级缓存)
     */
    Employee getEmpById(@Param("empId")int empId);
}
