package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.Aims;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class StoreController {

    @FXML
    private GridPane gridPane;

    private Store store;

    public void setStore(Store store) {
        this.store = store;
        loadItems();
    }

    private void loadItems() {
        gridPane.getChildren().clear();

        final String ITEM_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Item.fxml";

        int column = 0;
        int row = 0;

        for (Media media : store.getItemsInStore()) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(ITEM_FXML_FILE_PATH));

                VBox itemBox = fxmlLoader.load();
                ItemController itemController = fxmlLoader.getController();
                itemController.setData(media);

                gridPane.add(itemBox, column, row);
                GridPane.setMargin(itemBox, new Insets(10));

                column++;
                if (column == 3) {
                    column = 0;
                    row++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void viewCart() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(
                    "/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml"));
            javafx.scene.Parent root = fxmlLoader.load();

            CartController cartController = fxmlLoader.getController();
            cartController.setCart(Aims.getCart());

            Stage cartStage = new Stage();
            cartStage.setTitle("Cart");
            cartStage.setScene(new Scene(root));
            cartStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}