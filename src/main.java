import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
       Inventory.loadProducts();
        Parent root = FXMLLoader.load(getClass().getResource("store.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        List list = Inventory.getProductFromCategory("Phones");

        System.out.println(Inventory.getProductFromCategory("Cameras"));






    }


}
