package spring.simpleproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by nikolaykombarov on 24.01.17.
 */
class HelloWorld implements IHelloWorld {
    @Override
    public void greetings() {
        System.out.println("Hello world");
    }

    public IHelloWorld getProxy() {
        InvocationHandler handler = new IHelloWorldLog(this);
        return (IHelloWorld) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{IHelloWorld.class}, handler);
    }

}
