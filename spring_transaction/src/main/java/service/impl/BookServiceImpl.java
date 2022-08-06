package service.impl;

import dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service.BookService;



@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private  BookDao bookDao;


    /*
    通过@ Transaction标记的公共非静态的方法才会开启事务，如果通过@ Transaction标记的类，表示类中所有的公共非静态方法被事务管理
    事务的属性：
        1.readonly：设置为只读，就能够明确告诉数据库，这个操作不涉及写操作。这样数据库就能够针对查询操作来进行优化。
        2.timeout: 设置超时时间，在指定时间内事务未完成，那么自动结束并回滚。默认为-1，表示不超时
        3.事务的回滚策略：默认是遇到任何运行时异常都会回滚，我们可以设置因为哪些异常回滚和因为哪些异常不回滚
        4.设置事务的隔离级别，默认使用数据库的默认隔离级别
        5.事务的传播机制：
           通过propagation属性设置事务的传播机制
           REQUIRES ：当前方法所在线程已经开启了事务，那么该方法的事务机制不会开启
           REQUIRES_NEW：当前方法所在线程已经开启事务，当前方法在执行时仍然会开启一个新的事务，外部事务的回滚不会影响到该事务。
                         注意：如果在一个开启事务的方法中调用同一个类中有事务机制的方法，那么REQUEST_NEW是不生效的。
     */
    @Transactional(
            propagation = Propagation.REQUIRES_NEW
            //rollbackFor = ArithmeticException.class
            //noRollbackFor =
            //isolation = Isolation.DEFAULT,
    )
    public void buyBook(int userId, int bookId) {

        //查询图书价格
        int price = bookDao.getPriceByBookId(bookId);
        //更新图书库存
        bookDao.upDateStock(bookId);
        //更新用户余额
        bookDao.upDateBalance(userId,price);
    }

    @Transactional
    public void checkOut(int userId, int[] bookIds) {
        for(Integer bookId: bookIds){
            this.buyBook(userId,bookId);
        }
    }

}
