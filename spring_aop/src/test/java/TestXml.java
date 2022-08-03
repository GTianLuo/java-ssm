import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xml.Calculator;

public class TestXml {
    @Test
    public void testXml(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("xml/aop-xml.xml");
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.add(2,3);
    }
}
