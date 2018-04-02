package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Controller {
    public Label ReturningUser;
    public Label NewUser;
    public Button LogInButton;
    public Button SignUpButton;
    public MenuItem newGame;
    public MenuItem openGame;
    public MenuItem saveGame;
    public MenuItem exitGame;
    public ImageView soundButton;
    public ImageView soundButtonOff;
    public int soundCount = 1;


    public void LogInScreen() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage primaryStage = Main.getPrimaryStage();
        primaryStage.setTitle("KROGG The Destroyer - Login");
        primaryStage.setScene(new Scene(root, 640, 400));
    }

    public void SignUpScreen() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Signup.fxml"));
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

    public void Sound() {
        boolean playing = Main.mediaPlayer.getStatus().equals(MediaPlayer.Status.PLAYING);
        if (!playing) {
            Main.mediaPlayer.play();
            soundButton.setOpacity(100.0);
            soundButtonOff.setOpacity(0.0);
        } else {
            Main.mediaPlayer.pause();
            soundButton.setOpacity(0.0);
            soundButtonOff.setOpacity(100.0);
        }
    }

    public void Exit(){
        System.exit(0);
    }
}