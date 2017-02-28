package com.vk.kombarov_nikolay.model;

import org.apache.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by nikolaykombarov on 25.01.17.
 */
public class GenericTracer<T> implements InvocationHandler {

    private T delegate;

    private Logger logger;

    public GenericTracer(T delegate) {
        this.delegate = delegate;
        logger = Logger.getLogger(delegate.getClass());
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("toString"))
            return method.invoke(delegate, args);

        StringBuilder sb = new StringBuilder(method.getName() + "(");
        if (args != null)
            sb.append(listArguments(args));
        sb.append(")");
        logger.trace(sb);
        Object ret = null;
        try {
            ret = method.invoke(delegate, args);
        } catch (Exception e) {
            logger.trace("Exception was thrown");
            throw e;
        } finally {
            return ret;
        }
    }

    public T getTracer() {
        ClassLoader cl = delegate.getClass().getClassLoader();
        Class[] interfaces = delegate.getClass().getInterfaces();
         return (T) Proxy.newProxyInstance(cl, interfaces, this);
    }


    private String listArguments(Object[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            if (i != 0)
                sb.append(", ");
            sb.append("(");
            sb.append(args[i].getClass().getSimpleName());
            sb.append(") ");
            sb.append(args[i].toString());
        }
        return sb.toString();
    }
}
