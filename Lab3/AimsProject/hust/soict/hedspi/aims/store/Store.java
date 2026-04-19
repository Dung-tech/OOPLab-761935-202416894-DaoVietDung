package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class Store {
    public static final int MAX_NUMBERS_ITEMS_IN_STORE = 100;
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_NUMBERS_ITEMS_IN_STORE];
    private int qtyInStore = 0;

    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < MAX_NUMBERS_ITEMS_IN_STORE) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("The disc \"" + dvd.getTitle() + "\" has been added to the store.");
        } else {
            System.out.println("The store is full. Cannot add more discs.");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        if (dvd == null) {
            System.out.println("No disc to remove.");
            return;
        }

        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                found = true;
                System.out.println("The disc \"" + dvd.getTitle() + "\" has been removed from the store.");
                break;
            }
        }
        if (!found) {
            System.out.println("The disc is not in the store.");
        }
    }
    public int getQtyInStore() {
        return qtyInStore;
    }
}
