import annotation.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation {

    @Test
    public void testAdd(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("annotation/aop-annotation.xml");
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.add(1,1);
        calculator.div(2,1);
    }
}
