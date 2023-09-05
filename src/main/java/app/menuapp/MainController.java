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

import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

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

        food = FXCollections.observableArrayList(readFile());

        tableFood.setItems(food);
    }

    public void addFood(ActionEvent actionEvent) {
        if (txtFoodName.getText().equals("") ||
            comboCategory.getSelectionModel().getSelectedIndex() < 0 ||
            txtWeight.getText().equals("") || txtCalories.getText().equals("")) {

            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setTitle("Error");
            dialog.setHeaderText("Error adding data");
            dialog.setContentText("No field can be empty");
            dialog.showAndWait();
        } else {
            food.add(new Food(txtFoodName.getText(), comboCategory.getSelectionModel().getSelectedItem(),
                    Integer.parseInt(txtWeight.getText()), Integer.parseInt(txtCalories.getText())));
            saveFile(food);
        }

    }

    // saves food table file
    private static void saveFile(List<Food> food) {
        try (PrintWriter pw = new PrintWriter("food.txt")) {
            food.stream().forEach(f -> pw.println(f.toString()));
        } catch (Exception e) {}
    }

    // read food table file
    private static List<Food> readFile() {
        try {
            return Files.lines(Paths.get("food.txt"))
                    .map(line -> new Food(line.split(";")[0], line.split(";")[1],
            Integer.parseInt(line.split(";")[2]), Double.parseDouble(line.split(";")[3])))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            return null;
        }
    }


}