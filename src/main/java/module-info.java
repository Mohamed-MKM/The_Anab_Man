module com.example.mainmenu2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.mainmenu2 to javafx.fxml;
    exports com.example.mainmenu2;
}