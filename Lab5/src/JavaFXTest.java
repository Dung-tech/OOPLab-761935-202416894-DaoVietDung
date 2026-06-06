import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXTest extends Application {

    @Override
    public void start(Stage stage) {
        Button btn = new Button("Click me!");
        btn.setOnAction(e -> System.out.println("JavaFX đang chạy tốt!"));

        VBox root = new VBox(20, btn);
        root.setStyle("-fx-padding: 30; -fx-alignment: center;");

        Scene scene = new Scene(root, 400, 250);
        stage.setTitle("Test JavaFX - Lab5");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        System.out.println(">>> JavaFX đang khởi động...");
        launch(args);
    }
}