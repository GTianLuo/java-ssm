import com.guo.pojo.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOne {
    @Test
    public void testAnnotation(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-annotation.xml");
        UserController controller = ioc.getBean(UserController.class);
        controller.saveUser();
    }
}
