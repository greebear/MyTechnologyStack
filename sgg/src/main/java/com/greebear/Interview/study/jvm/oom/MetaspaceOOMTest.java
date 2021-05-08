//package com.atguigu.Interview.study.jvm.oom;
//
//import org.springframework.cglib.proxy.Enhancer;
//import org.springframework.cglib.proxy.MethodInterceptor;
//import org.springframework.cglib.proxy.MethodProxy;
//
//import java.lang.reflect.Method;
//
///*
//* -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=8m
//*
//* */
//public class MetaspaceOOMTest {
//
//    // 静态类
//    static class OOMTest {
//
//    }
//
//    public static void main(final String[] args)
//    {
//        // 模拟计数多少次以后发生异常
//        int i = 0;
//        try {
//            while (true) {
//                i++;
//                // 使用Spring的动态字节码技术
//                Enhancer enhancer = new Enhancer();
//                enhancer.setSuperclass(OOMTest.class);
//                enhancer.setUseCache(false);
//                enhancer.setCallback(new MethodInterceptor()
//                {
//                    @Override
//                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable
//                    {
//                        return methodProxy.invokeSuper(o, args);
//                    }
//                });
//            }
//        } catch (Throwable e) {
//
//            e.printStackTrace();
//        }
//    }
//}