package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.Aims;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {

    @FXML
    private Label lblTitle;
    @FXML
    private Label lblCost;
    @FXML
    private Button btnAddToCart;
    @FXML
    private Button btnPlay;

    private Media media;

    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");

        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }

    @FXML
    private void btnAddToCartClicked() {
        Aims.getCart().addMedia(media);
        System.out.println("Added to cart: " + media.getTitle());
    }

    @FXML
    private void btnPlayClicked() {
        if (media instanceof Playable) {
            ((Playable) media).play();
        }
    }
}