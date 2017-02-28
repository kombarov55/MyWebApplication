package spring.desserts.annotations;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by nikolaykombarov on 24.01.17.
 */
@Qualifier
@Target(value={
        ElementType.TYPE,
        ElementType.CONSTRUCTOR,
        ElementType.FIELD,
        ElementType.METHOD
})
@Retention(value= RetentionPolicy.RUNTIME)
public @interface Frutty {
}
