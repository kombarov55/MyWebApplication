package spring.soundsystem.classes.cdplayers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.soundsystem.classes.discs.CompactDisc;

/**
 * Created by nikolaykombarov on 22.01.17.
 */

@Component
public class CDPlayer {

    @Autowired
    private CompactDisc cd;

    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    public String play() {
        return cd.play();
    }
}
