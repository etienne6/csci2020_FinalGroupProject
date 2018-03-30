package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    public Label ReturningUser;
    public Label NewUser;
    public Button LogInButton;
    public Button SignUpButton;
    public MenuItem newGame;
    public MenuItem openGame;
    public MenuItem saveGame;
    public MenuItem exitGame;


    public void LogInScreen() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Stage primaryStage = Main.getPrimaryStage();
        primaryStage.setTitle("KROGG The Destroyer - Login");
        primaryStage.setScene(new Scene(root, 640, 400));
    }

    public void SignUpScreen() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
        Stage primaryStage = Main.getPrimaryStage();
        primaryStage.setTitle("KROGG The Destroyer - Sign Up");
        primaryStage.setScene(new Scene(root, 640, 400));
    }

    public void New(){
    }

    public void Save(){
    }

    public void Open(){
    }

    public void Exit(){
        System.exit(0);
    }
}