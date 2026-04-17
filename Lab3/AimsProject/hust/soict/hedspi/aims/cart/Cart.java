package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered;
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered < MAX_NUMBERS_ORDERED){
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added.");
        }
        else{
            System.out.println("The cart is full.");
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered++;
                System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
            } else {
                System.out.println("The cart is full. Cannot add: " + disc.getTitle());
                break;
            }
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered + 2 <= MAX_NUMBERS_ORDERED) {
            addDigitalVideoDisc(dvd1);
            addDigitalVideoDisc(dvd2);
        } else {
            System.out.println("The cart is almost full. Cannot add both discs.");
        }
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        int index = -1;
        for(int i = 0; i < qtyOrdered;i++){
            if(itemsOrdered[i] == disc) {
                index = i;
                break;
            }
        }
        if(index == -1) {
            System.out.println("There curently no ordered for this disc.");
        }
        else{
            for(int i = index + 1; i < qtyOrdered;i++) itemsOrdered[i - 1] = itemsOrdered[i];
            itemsOrdered[qtyOrdered-1] = null;
            qtyOrdered--;
            System.out.println("The disc has been removed.");
        }
    }
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". DVD - " + itemsOrdered[i].getTitle() +
                    " - " + itemsOrdered[i].getCategory() +
                    " - " + itemsOrdered[i].getDirector() +
                    " - " + itemsOrdered[i].getLength() +
                    ": " + itemsOrdered[i].getCost() + " $");
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }
}
