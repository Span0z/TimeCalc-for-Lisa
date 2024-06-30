module com.example.timeprog {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.timeprog to javafx.fxml;
    exports com.example.timeprog;
}