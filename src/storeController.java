import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class storeController implements Initializable {

    @FXML private ListView<Product> listView;

    @FXML private ImageView imageView;

    @FXML private ComboBox<TreeMap> categoryComboBox;

    public void initialize(URL location, ResourceBundle resources) {
        listView.getItems().addAll(Inventory.getAllProducts());
        categoryComboBox.getItems().addAll(Inventory.getAllCategories());
        listView.getSelectionModel().select(0);
       // imageView.setImage(listView.getSelectionModel().getSelectedItem().getImage());
    }
}
