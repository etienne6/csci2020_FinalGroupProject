package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;



public class Main extends Application {
    public static MediaPlayer mediaPlayer;

    private static Stage primaryStage;

    private void setPrimaryStage(Stage stage) {
        Main.primaryStage = stage;
    }

    static public Stage getPrimaryStage() {
        return Main.primaryStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        setPrimaryStage(primaryStage);
        Parent root = FXMLLoader.load(getClass().getResource("greeting.fxml"));

        Image icon = new Image(getClass().getResourceAsStream("../media/kroggicon.png"));

        String communitySong = "src/media/communitytheme.mp3";
        Music.playSong(communitySong,25,"");

        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("KROGG The Destroyer - Welcome");
        primaryStage.setScene(new Scene(root, 640, 400));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

