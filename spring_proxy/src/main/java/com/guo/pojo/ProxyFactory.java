package com.guo.pojo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory{

    CalculatorImp target;

    public ProxyFactory(CalculatorImp target) {
        this.target = target;
    }

    public Object getProxy(){
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("[日志:]" + "执行"+ method.getName());
                Object o = method.invoke(target, args);
                return o;
            }
        };
        Object o = Proxy.newProxyInstance(classLoader, interfaces, handler);
        return o;
    }
}
