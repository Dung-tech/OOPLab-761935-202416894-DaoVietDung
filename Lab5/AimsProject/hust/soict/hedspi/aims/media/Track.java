package hust.soict.hedspi.aims.media;
import hust.soict.hedspi.aims.exception.PlayerException;

public class Track implements Playable {

    private String title;
    private int length;

    public Track() {
        super();
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Track track = (Track) obj;
        return length == track.length &&
                title != null &&
                title.equalsIgnoreCase(track.title);
    }
}
