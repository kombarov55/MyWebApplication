package spring.callback;

/**
 * Created by nikolaykombarov on 24.01.17.
 */
public class Service {
    
    public void doService(Callback callback) {
        ServiceConsumer consumer = (ServiceConsumer) callback;
    }
}
