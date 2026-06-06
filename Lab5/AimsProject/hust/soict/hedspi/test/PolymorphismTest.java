package hust.soict.hedspi.test;

import hust.soict.hedspi.aims.media.*;
import java.util.ArrayList;
import java.util.List;

public class PolymorphismTest {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();

        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);

        Book book = new Book();
        book.setTitle("Clean Code");
        book.setCategory("Programming");
        book.setCost(35.5f);
        book.addAuthor("Robert C. Martin");

        CompactDisc cd = new CompactDisc("Michael Jackson", "Epic", "Pop", "Thriller", 25.0f);
        cd.addTrack(new Track("Billie Jean", 5));
        cd.addTrack(new Track("Beat It", 4));

        mediae.add(dvd);
        mediae.add(book);
        mediae.add(cd);

        System.out.println("=== DEMO POLYMORPHISM (toString) ===");
        for (Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}
