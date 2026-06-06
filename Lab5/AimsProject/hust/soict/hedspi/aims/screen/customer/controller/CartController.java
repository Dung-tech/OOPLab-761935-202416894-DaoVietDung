package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.Aims;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartController {

    @FXML private TableView<Media> tblMedia;
    @FXML private TableColumn<Media, Integer> colMediaId;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediaCategory;
    @FXML private TableColumn<Media, Float> colMediaCost;

    @FXML private Button btnPlay;
    @FXML private Button btnRemove;
    @FXML private Label lblTotalCost;
    @FXML private TextField tfFilter;
    @FXML private RadioButton radioBtnFilterId;
    @FXML private RadioButton radioBtnFilterTitle;

    private Cart cart;
    private FilteredList<Media> filteredData;

    public void setCart(Cart cart) {
        this.cart = cart;
        initializeTable();
    }

    private void initializeTable() {
        colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        filteredData = new FilteredList<>(cart.getItemsOrdered(), p -> true);
        tblMedia.setItems(filteredData);

        updateTotalCost();

        // Ẩn nút ban đầu
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        // Lắng nghe chọn item
        tblMedia.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                btnRemove.setVisible(true);
                btnPlay.setVisible(newVal instanceof Playable);
            } else {
                btnPlay.setVisible(false);
                btnRemove.setVisible(false);
            }
        });

        // Filter
        tfFilter.textProperty().addListener((obs, oldVal, newVal) -> applyFilter(newVal));
    }

    private void applyFilter(String keyword) {
        filteredData.setPredicate(media -> {
            if (keyword == null || keyword.isEmpty()) return true;
            String lowerKeyword = keyword.toLowerCase();

            if (radioBtnFilterId.isSelected()) {
                return String.valueOf(media.getId()).contains(lowerKeyword);
            } else {
                return media.getTitle().toLowerCase().contains(lowerKeyword);
            }
        });
    }

    private void updateTotalCost() {
        lblTotalCost.setText(cart.totalCost() + " $");
    }

    @FXML
    private void btnRemovePressed() {
        Media selected = tblMedia.getSelectionModel().getSelectedItem();
        if (selected != null) {
            cart.removeMedia(selected);
            updateTotalCost();
        }
    }

    @FXML
    private void btnPlayPressed() {
        Media selected = tblMedia.getSelectionModel().getSelectedItem();
        if (selected instanceof Playable) {
            ((Playable) selected).play();
        }
    }

    @FXML
    private void btnViewStorePressed() {
        // Đóng cửa sổ Cart hiện tại
        tblMedia.getScene().getWindow().hide();
    }
    @FXML
    private void btnPlaceOrderPressed() {
        if (cart.getItemsOrdered().isEmpty()) {
            showAlert("Giỏ hàng trống", "Không có sản phẩm nào để đặt hàng.");
            return;
        }

        // Hiển thị thông báo đặt hàng thành công
        showAlert("Đặt hàng thành công",
                "Cảm ơn bạn đã mua hàng!\nTổng tiền: " + cart.totalCost() + " $");
        cart.getItemsOrdered().clear();
        tblMedia.setItems(null);
        lblTotalCost.setText("0 $");
    }

    private void showAlert(String title, String content) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(
                javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}