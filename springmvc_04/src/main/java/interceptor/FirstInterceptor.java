package interceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器不关心请求对应的控制器方法是否存在，只要是浏览器发来的请求被DispatcherServlet处理后都会执行拦截器方法，
 * 解释：拦截器方法的执行是由DispatcherServlet调用执行的，所以拦截器方法的执行只与该servlet有关，与请求是否有对应的控制器方法无关
 * 并且只要preHandle放行，那么postHandle和afterCompletion都会执行
 *
 *
 *当有多个拦截器时，效果如下：
 * 1. 如果全部放行，此时多个拦截器的执行顺序和拦截器在SpringMVC的配置文件的配置顺序有关：
 *    preHandle()会按照配置的顺序执行，而postHandle()和afterCompletion()会按照配置的反序执行
 *
 * 如：
 * FirstInterceptor------>preHandle执行！1
 * FirstInterceptor------>preHandle执行！2
 * FirstInterceptor------>preHandle执行！3
 * FirstInterceptor--------->postHandle执行！3
 * FirstInterceptor--------->postHandle执行！2
 * FirstInterceptor--------->postHandle执行！1
 * FirstInterceptor--------->afterHandle执行！3
 * FirstInterceptor--------->afterHandle执行！2
 * FirstInterceptor--------->afterHandle执行！1
 *
 *
 * 2.preHandle()返回false和它之前的拦截器的preHandle()都会执行，postHandle()都不执行，返回false
 * 的拦截器之前的拦截器的afterCompletion()会执行
 *
 *如：
 * FirstInterceptor------>preHandle执行！1
 * FirstInterceptor------>preHandle执行！2
 * FirstInterceptor--------->afterHandle执行！1
 */
public class FirstInterceptor  implements HandlerInterceptor {
    //在控制器方法执行前执行，返回值类型表示是否拦截，返回true表示放行，false表示拦截，控制器方法不会执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("FirstInterceptor------>preHandle执行！1");
        return true;
    }

    //在控制方法执行结束后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("FirstInterceptor--------->postHandle执行！1");
    }

    //在处理完视图之后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("FirstInterceptor--------->afterHandle执行！1");
    }
}
