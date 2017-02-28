package spring.simpleproxy;

/**
 * Created by nikolaykombarov on 24.01.17.
 */
public class SimpleProxy {


    public static void main(String[] args) {
     HelloWorld helloWorld = new HelloWorld();

     IHelloWorld clueless = helloWorld.getProxy();

     clueless.greetings();
    }
}
