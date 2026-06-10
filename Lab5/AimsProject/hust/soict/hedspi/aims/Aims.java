package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.exception.PlayerException;
import java.util.ArrayList;
import java.util.Scanner;

public class Aims {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Store store = new Store();
    private static final Cart cart = new Cart();

    public static Store getStore() {
        return store;
    }

    public static Cart getCart() {
        return cart;
    }

    public static void main(String[] args) {
        initializeSampleData();
        launchJavaFX();
    }
    private static void launchJavaFX() {
        try {
            javafx.application.Platform.startup(() -> {
                try {
                    javafx.fxml.FXMLLoader fxmlLoader = new javafx.fxml.FXMLLoader(
                            Aims.class.getResource("/hust/soict/hedspi/aims/screen/customer/view/Store.fxml"));

                    javafx.scene.Parent root = fxmlLoader.load();

                    hust.soict.hedspi.aims.screen.customer.controller.StoreController storeController =
                            fxmlLoader.getController();
                    storeController.setStore(store);

                    javafx.stage.Stage stage = new javafx.stage.Stage();
                    stage.setTitle("AIMS Store");
                    stage.setScene(new javafx.scene.Scene(root));
                    stage.show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        System.out.println("4. Search media in store");
        System.out.println("5. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");

        int choice = Integer.parseInt(scanner.nextLine().trim());
        switch (choice) {
            case 1 -> seeMediaDetails();
            case 2 -> addMediaToCart();
            case 3 -> playMedia();
            case 4 -> searchMediaInStore();     // ← Thêm mới
            case 5 -> seeCurrentCart();
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
        else if (choice == 2 && media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
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
                try {
                    ((Playable) m).play();
                } catch (PlayerException e) {
                    System.out.println("ERROR: " + e.getMessage());
                }
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
                try {
                    ((Playable) m).play();
                } catch (PlayerException e) {
                    System.out.println("ERROR: " + e.getMessage());
                }
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
        int choice;
        do {
            System.out.println("\nUpdate Store:");
            System.out.println("--------------------------------");
            System.out.println("1. Add a media to store");
            System.out.println("2. Remove a media from store");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2: ");

            choice = Integer.parseInt(scanner.nextLine().trim());

            switch (choice) {
                case 1 -> addMediaToStore();
                case 2 -> removeMediaFromStore();
                case 0 -> {}
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }
    private static void addMediaToStore() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine().trim();
        System.out.print("Enter category: ");
        String category = scanner.nextLine().trim();
        System.out.print("Enter cost: ");
        float cost = Float.parseFloat(scanner.nextLine().trim());

        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost);
        store.addMedia(dvd);
    }

    private static void removeMediaFromStore() {
        System.out.print("Enter media title to remove: ");
        String title = scanner.nextLine().trim();

        for (Media media : new ArrayList<>(store.getItemsInStore())) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                store.removeMedia(media);
                return;
            }
        }
        System.out.println("Media not found in store!");
    }
    private static void searchMediaInStore() {
        System.out.println("\nSearch options:");
        System.out.println("1. Search by title");
        System.out.println("2. Search by category");
        System.out.println("3. Search by price");
        System.out.print("Choose search type: ");
        int type = Integer.parseInt(scanner.nextLine().trim());

        switch (type) {
            case 1 -> {
                System.out.print("Enter title keyword: ");
                String keyword = scanner.nextLine().trim();
                for (Media m : store.getItemsInStore()) {
                    if (m.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                        System.out.println(m);
                    }
                }
            }
            case 2 -> {
                System.out.print("Enter category: ");
                String category = scanner.nextLine().trim();
                for (Media m : store.getItemsInStore()) {
                    if (m.getCategory() != null && m.getCategory().equalsIgnoreCase(category)) {
                        System.out.println(m);
                    }
                }
            }
            case 3 -> {
                System.out.print("Enter min price (or press Enter for no min): ");
                String minStr = scanner.nextLine().trim();
                System.out.print("Enter max price: ");
                float max = Float.parseFloat(scanner.nextLine().trim());

                float min = minStr.isEmpty() ? 0 : Float.parseFloat(minStr);

                for (Media m : store.getItemsInStore()) {
                    if (m.getCost() >= min && m.getCost() <= max) {
                        System.out.println(m);
                    }
                }
            }
            default -> System.out.println("Invalid search type!");
        }
    }
}