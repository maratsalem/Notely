module com.example.notely {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.notely to javafx.fxml;
    exports com.example.notely;
}