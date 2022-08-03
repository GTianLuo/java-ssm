import com.guo.pojo.Calculator;
import com.guo.pojo.CalculatorImp;
import com.guo.pojo.ProxyFactory;
import org.junit.Test;

public class ProxyTest {

    @Test
    public void test(){
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImp());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(1,2);
    }

}
