module com.mycompany.mavenproject1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.base;
    
    opens com.mycompany.mavenproject1 to javafx.fxml;
    opens modelo to javafx.base;
    exports com.mycompany.mavenproject1;
}
