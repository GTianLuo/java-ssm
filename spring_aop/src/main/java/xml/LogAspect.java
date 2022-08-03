package xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class LogAspect {

    public void beforeAdvice(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();

        Object[] args = joinPoint.getArgs();
        System.out.println("在执行"+methodName +"方法前，参数为:" + Arrays.toString(args));
    }


    public void afterAdvice(){
        System.out.println("该方法执行结束！");
    }


    public void afterReturnAdvice(Object result){
        System.out.println("执行结果为：" + result);
    }


    public void ThrowingAdvice(JoinPoint joinPoint,Exception ex){
        System.out.println(joinPoint.getSignature().getName() + "异常：" + ex);
    }

}
