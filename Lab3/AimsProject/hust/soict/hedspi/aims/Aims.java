package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;
import java.util.ArrayList;
import java.util.Scanner;

public class Aims {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Store store = new Store();
    private static final Cart cart = new Cart();

    public static void main(String[] args) {
        initializeSampleData();
        System.out.println("=== AIMS APPLICATION STARTED ===");

        int choice;
        do {
            showMenu();
            choice = Integer.parseInt(scanner.nextLine().trim());

            switch (choice) {
                case 1 -> viewStore();
                case 2 -> updateStore();
                case 3 -> seeCurrentCart();
                case 0 -> System.out.println("Thank you for using AIMS. Goodbye!");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void initializeSampleData() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        Book book1 = new Book();
        book1.setTitle("Clean Code");
        book1.setCategory("Programming");
        book1.setCost(35.5f);
        book1.addAuthor("Robert C. Martin");

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book1);
    }

    public static void showMenu() {
        System.out.println("\nAIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void viewStore() {
        System.out.println("\n=== STORE ITEMS ===");
        for (Media m : store.getItemsInStore()) {
            System.out.println(m.toString());
        }
        storeMenu();
    }

    public static void storeMenu() {
        System.out.println("\nOptions:");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");

        int choice = Integer.parseInt(scanner.nextLine().trim());
        switch (choice) {
            case 1 -> seeMediaDetails();
            case 2 -> addMediaToCart();
            case 3 -> playMedia();
            case 4 -> seeCurrentCart();
            case 0 -> {}
            default -> System.out.println("Invalid choice!");
        }
    }

    private static void seeMediaDetails() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine().trim();
        Media found = null;
        for (Media m : store.getItemsInStore()) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                found = m;
                break;
            }
        }
        if (found != null) {
            System.out.println("\n" + found.toString());
            mediaDetailsMenu(found);
        } else {
            System.out.println("Media not found!");
        }
    }

    private static void mediaDetailsMenu(Media media) {
        System.out.println("\nOptions:");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        if (media instanceof Playable) System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");

        int choice = Integer.parseInt(scanner.nextLine().trim());
        if (choice == 1) cart.addMedia(media);
        else if (choice == 2 && media instanceof Playable) ((Playable) media).play();
    }

    private static void addMediaToCart() {
        System.out.print("Enter media title to add: ");
        String title = scanner.nextLine().trim();
        for (Media m : store.getItemsInStore()) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                cart.addMedia(m);
                return;
            }
        }
        System.out.println("Media not found!");
    }

    private static void playMedia() {
        System.out.print("Enter media title to play: ");
        String title = scanner.nextLine().trim();
        for (Media m : store.getItemsInStore()) {
            if (m.getTitle().equalsIgnoreCase(title) && m instanceof Playable) {
                ((Playable) m).play();
                return;
            }
        }
        System.out.println("Media not found or cannot be played!");
    }

    public static void seeCurrentCart() {
        cart.print();
        cartMenu();
    }

    public static void cartMenu() {
        System.out.println("\nOptions:");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");

        int choice = Integer.parseInt(scanner.nextLine().trim());
        switch (choice) {
            case 1 -> filterMediaInCart();
            case 2 -> sortMediaInCart();
            case 3 -> removeMediaFromCart();
            case 4 -> playMediaFromCart();
            case 5 -> placeOrder();
            case 0 -> {}
            default -> System.out.println("Invalid choice!");
        }
    }

    private static void filterMediaInCart() {
        System.out.println("1. By ID");
        System.out.println("2. By Title");
        System.out.print("Choose: ");
        int type = Integer.parseInt(scanner.nextLine().trim());
        if (type == 1) {
            System.out.print("Enter ID: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            cart.searchById(id);
        } else {
            System.out.print("Enter title: ");
            String title = scanner.nextLine().trim();
            cart.searchByTitle(title);
        }
    }

    private static void sortMediaInCart() {
        System.out.println("1. Sort by Title then Cost");
        System.out.println("2. Sort by Cost then Title");
        System.out.print("Choose: ");
        int type = Integer.parseInt(scanner.nextLine().trim());
        if (type == 1) cart.sortByTitleCost();
        else if (type == 2) cart.sortByCostTitle();
    }

    private static void removeMediaFromCart() {
        System.out.print("Enter media title to remove: ");
        String title = scanner.nextLine().trim();
        for (Media m : new ArrayList<>(cart.getItemsOrdered())) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                cart.removeMedia(m);
                return;
            }
        }
        System.out.println("Media not found in cart!");
    }

    private static void playMediaFromCart() {
        System.out.print("Enter media title to play: ");
        String title = scanner.nextLine().trim();
        for (Media m : cart.getItemsOrdered()) {
            if (m.getTitle().equalsIgnoreCase(title) && m instanceof Playable) {
                ((Playable) m).play();
                return;
            }
        }
        System.out.println("Media not found or cannot be played!");
    }

    private static void placeOrder() {
        System.out.println("Order placed successfully! Total cost: " + cart.totalCost() + " $");
        // cart.getItemsOrdered().clear(); // uncomment nếu muốn xóa giỏ hàng
    }
    public static void updateStore() {
        System.out.println("Update store function - will be implemented later");
    }
}