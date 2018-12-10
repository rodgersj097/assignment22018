
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;


public class storeController implements Initializable {

    @FXML
    private ListView<Product> listView;

    @FXML
    private ImageView imageView;

    @FXML
    private ComboBox<String> categoryComboBox;

    @FXML
    private RadioButton pricehtl;

    @FXML
    private RadioButton pricelth;

    @FXML
    private RadioButton productatz;

    @FXML
    private RadioButton productzta;

    @FXML
    private Label invTotal;

    @FXML
    private Label catTotal;

    @FXML
    private Button sellButton;

    public void initialize(URL location, ResourceBundle resources) {
        //load the listview and combo box with data
        listView.getItems().addAll(Inventory.getAllProducts());
        categoryComboBox.getItems().addAll(Inventory.getAllCategories());

        //set up the radio buttons it a toggle group
        ToggleGroup tgroup = new ToggleGroup();
        pricehtl.setToggleGroup(tgroup);
        pricelth.setToggleGroup(tgroup);
        productatz.setToggleGroup(tgroup);
        productzta.setToggleGroup(tgroup);

        //initialize first object selected
        listView.getSelectionModel().select(0);

        //loads image of the selected listview item
        listView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue ,  newValue) -> {
                    if (newValue != null) {
                        imageView.setImage(newValue.getImage());
                    }
                });
        //logic for radio buttons to sort listview from price high to low, price low to high, product a to z and product z to a
        //price high to low
        pricehtl.selectedProperty().addListener(
                (Observable, oldValue, newValue) -> {
                        Collections.sort(listView.getItems(), (p1, p2) -> p1.getPrice().compareTo(p2.getPrice()));

                }
        );
        //price low to high
        pricelth.selectedProperty().addListener(
                (Observable, oldValue, newValue) -> {
                    Collections.sort(listView.getItems(), (p1, p2) -> p2.getPrice().compareTo(p1.getPrice()));
                }
        );
        //product z to a
        productzta.selectedProperty().addListener(
                (Observable, oldValue, newValue) -> {
                    Collections.sort(listView.getItems(), (p1, p2) -> p2.getMake().compareTo(p1.getMake()));
                }
        );
        //product a to z
        productatz.selectedProperty().addListener(
                (Observable, oldValue, newValue) -> {
                    Collections.sort(listView.getItems(), (p1, p2) -> p1.getPrice().compareTo(p2.getPrice()));
                }
        );

        //use product.SellProduct to sell item
        sellButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listView.getSelectionModel().getSelectedItem().sellProduct();

            }
        });

        //run methods on initialize
        getCatTotal();
        getInvTotal();
        loadProductByCategory();

    }

    /**
     * runs through listview for the category and sums price * quantity for each item witha stream
     */
    public void getCatTotal(){
        catTotal.setText(String.valueOf(listView.getItems().stream().map(
                p-> {
                    return p.getQuantity() * p.getPrice();
                }).collect(Collectors.summingDouble(p -> p))) );
    }
    /**
     * runs through the entire listview and sums price * quantity for each item witha stream
     */
    public void getInvTotal() {
        invTotal.setText(String.valueOf(listView.getItems().stream().map(
                p -> {
                    return p.getQuantity() * p.getPrice();
                }).collect(Collectors.summingDouble(p -> p))));
    }

    /**
     *  load listview with category products when combobox is selected
     */
    public void loadProductByCategory(){
        categoryComboBox.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        listView.getItems().clear();
                        listView.getItems().addAll(Inventory.getProductFromCategory(newValue));
                        getCatTotal();
                        listView.getSelectionModel().select(0);
                    }
                }
        );
    }

}










