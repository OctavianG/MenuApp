package app.menuapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ChartController implements Initializable {

    @FXML
    private PieChart chart;

    // get the information from the table
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        FXMLLoader loader = new FXMLLoader(MenuApp.class.getResource("main.fxml"));

        try {
            Parent root = (Parent) loader.load();
        } catch (Exception e) {}

        MainController controller = (MainController) loader.getController();

        List<Food> food = controller.getFood();

        chart.getData().clear();

        Map<String, Integer> result;
        result = food.stream()
                .collect(Collectors.groupingBy(
                f -> f.getCategory(),
                        Collectors.summingInt(f -> f.getWeight())));

        result.forEach((cat, sum) -> {
            chart.getData().add(new PieChart.Data(cat, sum));
        });
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(MenuApp.class.getResource("main.fxml"));
        Parent view1 = loader.load();
        Scene view1Scene = new Scene(view1);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(view1Scene);
        stage.show();
    }
}
