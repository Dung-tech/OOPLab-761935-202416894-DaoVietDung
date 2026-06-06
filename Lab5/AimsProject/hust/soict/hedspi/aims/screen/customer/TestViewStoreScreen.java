package hust.soict.hedspi.aims.screen.customer;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.customer.controller.StoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {

    private static Store store;

    @Override
    public void start(Stage primaryStage) throws Exception {

        final String STORE_FXML_FILE_PATH =
                "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));

        Parent root = fxmlLoader.load();

        StoreController storeController = fxmlLoader.getController();
        storeController.setStore(store);

        primaryStage.setTitle("AIMS Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();

        // Thêm dữ liệu mẫu
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        Book book1 = new Book("Clean Code", "Programming", 35.5f);
        book1.addAuthor("Robert C. Martin");

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book1);

        launch(args);
    }
}