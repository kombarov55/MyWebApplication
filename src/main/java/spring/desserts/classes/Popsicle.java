package spring.desserts.classes;

import org.springframework.stereotype.Component;
import spring.desserts.annotations.Cold;
import spring.desserts.annotations.Frutty;

/**
 * Created by nikolaykombarov on 23.01.17.
 */

@Component
@Cold
@Frutty
public class Popsicle implements Dessert {
}
