package GUIProject.hust.soict.hedspi.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML private Pane drawingAreaPane;
    @FXML private RadioButton penRadioButton;
    @FXML private RadioButton eraserRadioButton;

    @FXML
    void clearButtonPressed(javafx.event.ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Color color = (eraserRadioButton != null && eraserRadioButton.isSelected())
                ? Color.WHITE : Color.BLACK;

        Circle circle = new Circle(event.getX(), event.getY(), 4, color);
        drawingAreaPane.getChildren().add(circle);
    }
}