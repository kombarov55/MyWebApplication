package spring.desserts.classes;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Created by nikolaykombarov on 23.01.17.
 */

@Component
@Qualifier("soft")
public class Cake implements Dessert {

    private Cake() {

    }
}
