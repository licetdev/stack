module ec.edu.espoch.stackfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espoch.stackfx.controller to javafx.fxml;
    opens ec.edu.espoch.stackfx to javafx.fxml;
    exports ec.edu.espoch.stackfx;
    exports ec.edu.espoch.stackfx.controller;
    exports ec.edu.espoch.stackfx.model;
    exports ec.edu.espoch.stackfx.view;
}