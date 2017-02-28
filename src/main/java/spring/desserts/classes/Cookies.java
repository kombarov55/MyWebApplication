package spring.desserts.classes;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by nikolaykombarov on 23.01.17.
 */
@Component
@Qualifier("crispy")
public class Cookies implements Dessert{
}
