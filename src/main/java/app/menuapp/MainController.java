package app.menuapp;

import javafx.beans.Observable;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {


    @FXML
    private TableView<Food> tableFood;
    @FXML
    private TableColumn<Food, String> colFoodName;
    @FXML
    private TableColumn<Food, String> colFoodCategory;
    @FXML
    private TableColumn<Food, Integer> colWeightG;
    @FXML
    private TableColumn<Food, Float> colCalories;
    @FXML
    private TextField txtFoodName;
    @FXML
    private ComboBox<String> comboCategory;
    @FXML
    private TextField txtWeight;
    @FXML
    private TextField txtCalories;

    private ObservableList<Food> food;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        comboCategory.getItems().addAll("Dairy products", "Meat and fish",
                "Fruits and vegetables", "Other");

        // associate columns
        colFoodName.setCellValueFactory(new PropertyValueFactory<>("FoodName"));
        colFoodCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colWeightG.setCellValueFactory(new PropertyValueFactory<>("weight"));
        colCalories.setCellValueFactory(new PropertyValueFactory<>("calories"));

        food = FXCollections.observableArrayList(
                new Food("Bread", "Other", 350, 270));

        tableFood.setItems(food);
    }

    public void addFood(ActionEvent actionEvent) {
        if (txtFoodName.getText().equals("") ||
            comboCategory.getSelectionModel().getSelectedIndex() < 0 ||
            txtWeight.getText().equals("")) {

            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setTitle("Error");
            dialog.setHeaderText("Error adding data");
            dialog.setContentText("No field can be empty");
            dialog.showAndWait();
        } else {
            food.add(new Food(txtFoodName.getText(), comboCategory.getSelectionModel().getSelectedItem(),
                    Integer.parseInt(txtWeight.getText()),  Integer.parseInt(txtCalories.getText())));
        }

    }
}