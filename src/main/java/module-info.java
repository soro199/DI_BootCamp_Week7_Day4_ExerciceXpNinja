module com.example.exercice_xp_ninja {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.exercice_xp_ninja to javafx.fxml;
    exports com.example.exercice_xp_ninja;
}