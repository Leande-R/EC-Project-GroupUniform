module org.example.uniformfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.uniformfx to javafx.fxml;
    exports org.example.uniformfx;
}