package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class newGame {
    public TextField Username;
    public PasswordField Password;
    public Button SubmitButton;
    public MenuItem newGame;
    public MenuItem openGame;
    public MenuItem saveGame;
    public MenuItem exitGame;
    public SeparatorMenuItem separator;
    public ImageView soundButton;
    public ImageView soundButtonOff;
    public Button challengeAccepted;
    boolean playing = Main.mediaPlayer.getStatus().equals(MediaPlayer.Status.PLAYING);


    public void initialize(){
        if (!playing) {
            soundButton.setOpacity(0.0);
            soundButtonOff.setOpacity(100.0);
            Music.playSong("src/media/communitythemeextended.mp3",347,"MUTE");
        } else {
            soundButton.setOpacity(100.0);
            soundButtonOff.setOpacity(0.0);
            Main.mediaPlayer.pause();
            Music.playSong("src/media/communitythemeextended.mp3",347,"");
        }

    }

    public void New(){
    }
    public void Save(){
    }
    public void Open(){
    }
    public void Back() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("selectMode.fxml"));
        Stage primaryStage = Main.getPrimaryStage();
        primaryStage.setTitle("KROGG The Destroyer - Mode Select");
        primaryStage.setScene(new Scene(root, 640, 400));
    }
    public void NewGame(){

    }

    public void characterChooser() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("characterChooser.fxml"));
        Stage primaryStage = Main.getPrimaryStage();
        primaryStage.setTitle("KROGG The Destroyer - Choose Your Character");
        primaryStage.setScene(new Scene(root, 640, 400));

    }

    public void ContinueGame() {

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