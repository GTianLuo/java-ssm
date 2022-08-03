import controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx_annotation.xml")
public class TestAnnotation {

    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook(){
        bookController.CheckOut(1,new int[]{1,1});
    }
}
