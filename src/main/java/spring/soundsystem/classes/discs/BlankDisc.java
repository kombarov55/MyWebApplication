package spring.soundsystem.classes.discs;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.List;

public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;
    private List<String> tracks;

    public BlankDisc(String title, String artist) {
        this.title = title;
        this.artist = artist;

        tracks = Collections.EMPTY_LIST;
    }

    public BlankDisc(String title, String artist, List<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public List<String> getTracks() {
        return tracks;
    }

    @Override
    public String play() {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        pw.printf("Playing %s by %s", title, artist);

        for (String track : tracks) {
            tracks.add(track + ",  ");
        }
        return sw.toString();
    }
}
