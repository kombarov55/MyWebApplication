package spring.simpleproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by nikolaykombarov on 24.01.17.
 */
class IHelloWorldLog implements InvocationHandler {

    private IHelloWorld helloWorld;

    public IHelloWorldLog(IHelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object ret = method.invoke(helloWorld, args);
        System.out.println("After");
        return ret;
    }
}