module de.bkhennef {
    requires javafx.controls;
    requires javafx.fxml;

    opens de.bkhennef to javafx.fxml;
    exports de.bkhennef;
}