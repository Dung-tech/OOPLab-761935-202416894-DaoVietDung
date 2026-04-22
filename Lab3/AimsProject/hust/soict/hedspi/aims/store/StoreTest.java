package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        // Test addDVD
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        System.out.println("Number of DVDs in store: " + store.getQtyInStore());

        // Test removeDVD
        store.removeMedia(dvd2);
        System.out.println("Number of DVDs in store after remove: " + store.getQtyInStore());

        // Test remove DVD không tồn tại
        store.removeMedia(new DigitalVideoDisc("Non-exist", "Unknown", 10.0f));
    }
}
