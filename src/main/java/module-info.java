module app.menuapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens app.menuapp to javafx.fxml;
    exports app.menuapp;
}