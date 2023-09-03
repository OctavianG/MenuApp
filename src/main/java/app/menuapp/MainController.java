package app.menuapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {


    @FXML
    private TableView tableFood;
    @FXML
    private TableColumn colFoodName;
    @FXML
    private TableColumn colFoodCategory;
    @FXML
    private TableColumn colWeightG;
    @FXML
    private TableColumn colCalories;
    @FXML
    private TextField txtFoodName;
    @FXML
    private ComboBox<String> comboCategory;
    @FXML
    private TextField txtWeight;
    @FXML
    private TextField txtCalories;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        comboCategory.getItems().addAll("Dairy products", "Meat and fish",
                "Fruits and vegetables", "Other");

    }
}