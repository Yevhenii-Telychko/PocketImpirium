module com.example.pocketimpirium {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    exports com.example.pocketimpirium.ui;
    opens com.example.pocketimpirium.ui to javafx.fxml;
}