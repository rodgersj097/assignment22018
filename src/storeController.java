import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class storeController implements Initializable {

    @FXML private ListView<TreeMap> listView;

    @FXML private ImageView imageView;

    @FXML private ComboBox<TreeMap> categoryComboBox;

    public void initialize(URL location, ResourceBundle resources) {
    listView.getItems().addAll(Inventory.getAllProducts());
    }
}
