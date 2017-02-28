package spring.callback;

/**
 * Created by nikolaykombarov on 24.01.17.
 */
public class ServiceConsumer implements Callback {
    
    @Override
    public void doCallback() {
        
    }
    
    {
        Service service = new Service();
        service.doService(this);
    }
}
