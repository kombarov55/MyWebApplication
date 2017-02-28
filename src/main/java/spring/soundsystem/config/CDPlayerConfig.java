package spring.soundsystem.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//import spring.soundsystem.classes.cdplayers.CDPlayer;

/**
 * Created by nikolaykombarov on 22.01.17.
 */

@Configuration
@ComponentScan(basePackageClasses = {spring.soundsystem.classes.cdplayers.CDPlayer.class, spring.soundsystem.classes.discs.SgtPeppers.class})
public class CDPlayerConfig {


}
