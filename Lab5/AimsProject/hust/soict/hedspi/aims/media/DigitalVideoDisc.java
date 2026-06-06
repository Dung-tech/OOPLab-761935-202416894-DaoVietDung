package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

    private static int nbDigitalVideoDiscs = 0;
    
    public DigitalVideoDisc(String title) {
        super(null, "", title, 0.0f);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        super(null, category, title, cost);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        super(director, category, title, cost);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(director, category, title, cost);
        this.setLength(length);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory()
                + " - " + getDirector() + " - " + getLength()
                + ": " + getCost() + " $";
    }

    public boolean isMatch(String title) {
        return getTitle().toLowerCase().contains(title.toLowerCase().trim());
    }
    @Override
    public void play() {
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength());
    }
}