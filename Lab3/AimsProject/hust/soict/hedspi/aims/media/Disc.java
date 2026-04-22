package hust.soict.hedspi.aims.media;

public class Disc extends Media {

    private String director;
    private int length;

    public Disc() {
        super();
    }

    public Disc(String director, String category, String title, float cost) {
        super();
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
