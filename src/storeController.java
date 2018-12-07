import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.crypto.spec.IvParameterSpec;
import java.net.PortUnreachableException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TreeMap;
import java.util.stream.Collector;

public class storeController implements Initializable {

    @FXML private ListView<Product> listView;

    @FXML private ImageView imageView;

    @FXML private ComboBox<TreeMap> categoryComboBox;

    @FXML private RadioButton pricehtl;

    @FXML private RadioButton pricelth;

    @FXML private RadioButton productatz;

    @FXML private RadioButton productzta;

    public void initialize(URL location, ResourceBundle resources) {
        listView.getItems().addAll(Inventory.getAllProducts());
        categoryComboBox.getItems().addAll(Inventory.getAllCategories());


        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Product>() {
            @Override
            public void changed(ObservableValue<? extends Product> observable, Product oldValue, Product newValue) {
                imageView.setImage(listView.getSelectionModel().getSelectedItem().getImage());
            }
        });

        categoryComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeMap>() {
            @Override
            public void changed(ObservableValue<? extends TreeMap> observable, TreeMap oldValue, TreeMap newValue) {
                listView.getItems().addAll(Inventory.getProductFromCategory(categoryComboBox.getSelectionModel().selectedItemProperty().getName()));
            }
        });


                listView.getSelectionModel().select(0);




    }


}
