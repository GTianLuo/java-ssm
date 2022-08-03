package annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect//表示这个是一个切面类
@Order(1)//设置切面的优先级，默认为Integer的最大值，当有多个切面时，优先级越小，切面的执行执行顺序越靠前
public class LogAspect {


    //切入点表达式的重用
    @Pointcut("execution(* annotation.CalculatorImp.*(..))")
    public void pointCut(){}




    //@Before("execution(public int annotation.Calculator.add(int,int))")
    //@Before("execution(* annotation.CalculatorImp.*(..))")
    @Before("pointCut()")//利用公共的切入点表达式
    /**
     * @ Before： 前置通知：表示在目标方法执行前执行，在该注释的括号里面要写上切入点表达式
     *execution: 里面写切入点表达式，该表达式要写十分完整，要包括访问控制修饰符，返回类型，类的全类名，还有参数列表的类型。
     *            其中，除开参数列表外，都可以用*表示任意一个，参数列表可以用 .. 表示任意多个参数
     *joinPoint.getSignature():返回切入点对应方法的签名信息（声明信息）
     *
     * joinPoint.getArgs():返回切入点对应方法的参数列表
     */
    public void beforeAdvice(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();

        Object[] args = joinPoint.getArgs();
        System.out.println("在执行"+methodName +"方法前，参数为:" + Arrays.toString(args));
    }


    /**
     * @ After: 后置通知，表示在目标方法执行后执行，相当于在finally子句中执行
     */
    @After("pointCut()")
    public void afterAdvice(){
        System.out.println("该方法执行结束！");
    }


    /**
     * @ AfterReturnAdvice: 返回通知，表示在目标方法返回值之后执行。
     *在此处可以获取方法的返回值，通过在属性中加上returning = "result"，表示将返回结果放到方法的result参数里
     */
    @AfterReturning(value = "pointCut()",returning = "result")
    public void beforeReturnAdvice(Object result){
        System.out.println("执行结果为：" + result);
    }


    /**
     * @ AfterThrow: 异常通知，当对于catch子句中执行的方法
     * 我们可以通过注释的属性throwing来将通知方法的某个参数赋值为出现的异常
     */
    @AfterThrowing(value = "pointCut()",throwing = "ex")
    public void afterThrowingAdvice(JoinPoint joinPoint,Exception ex){
        System.out.println(joinPoint.getSignature().getName() + "异常：" + ex);
    }


    /**
     * @ Around ：环绕通知，和动态代理十分相似，在这里面可以设置上面四种通知，并且目标方法的执行必须手动
     */
    @Around("pointCut()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        Object result = null;
        try {
            System.out.println("前置通知：");
            //执行目标方法
            result = proceedingJoinPoint.proceed();
            System.out.println("返回通知：");
        } catch (Throwable throwable) {
            System.out.println("异常通知：");
            throwable.printStackTrace();
        }finally {
            System.out.println("后置通知：");
        }
        return result;
    }
}
