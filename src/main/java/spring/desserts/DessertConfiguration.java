package spring.desserts;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by nikolaykombarov on 23.01.17.
 */

@Configuration
@ComponentScan(basePackageClasses={
        spring.desserts.classes.Cake.class
})
public class DessertConfiguration {
}
