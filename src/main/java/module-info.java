module de.bkhennef {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens de.bkhennef to javafx.fxml;
    exports de.bkhennef;
}