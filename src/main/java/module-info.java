module com.example.projectpoofx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.projectpoofx to javafx.fxml;
    exports com.example.projectpoofx;
}