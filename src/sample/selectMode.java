package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class selectMode {
    public TextField Username;
    public PasswordField Password;
    public Button SubmitButton;
    public MenuItem newGame;
    public MenuItem openGame;
    public MenuItem saveGame;
    public MenuItem exitGame;
    public SeparatorMenuItem separator;

    public void New(){
    }
    public void Save(){
    }
    public void Open(){
    }
    public void SinglePlayer()throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("singlePlayerGameSelect.fxml"));
        Stage primaryStage = Main.getPrimaryStage();
        primaryStage.setTitle("KROGG The Destroyer - Single Player: Select Game");
        primaryStage.setScene(new Scene(root, 640, 400));
    }
    public void MultiPlayer() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("multiPlayerGameSelect.fxml"));
        Stage primaryStage = Main.getPrimaryStage();
        primaryStage.setTitle("KROGG The Destroyer - Multi-Player: Select Game");
        primaryStage.setScene(new Scene(root, 640, 400));

    }
    public void Exit(){
        System.exit(0);
    }
}