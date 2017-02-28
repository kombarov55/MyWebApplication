package spring.desserts.classes;

import org.springframework.stereotype.Component;
import spring.desserts.annotations.Cold;
import spring.desserts.annotations.Creamy;

/**
 * Created by nikolaykombarov on 23.01.17.
 */

@Component
@Cold
@Creamy
public class IceCream implements Dessert {
}
