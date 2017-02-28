package spring.soundsystem.classes.discs;

import org.springframework.stereotype.Component;

/**
 * Created by nikolaykombarov on 22.01.17.
 */

@Component
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt. Pepper's Lonely Hearts Club Band";

    private String artist = "The Beatles";

    SgtPeppers() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String play() {
        return String.format("Playing %s by %s", title, artist);
    }
}
