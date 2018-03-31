package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import sample.Main;

import java.io.File;

public class Music {
    static void playSong(String songName, int duration,String Mute) {
        Media song = new Media(new File(songName).toURI().toString());
        Main.mediaPlayer = new MediaPlayer(song);

        Main.mediaPlayer.setOnEndOfMedia(new Runnable() {
            public void run() {
                Main.mediaPlayer.seek(Duration.ZERO);
                Timeline timeline = new Timeline(
                        new KeyFrame(Duration.seconds(duration),
                                new KeyValue(Main.mediaPlayer.volumeProperty(), 0)));
                timeline.play();
            }
        });
        if (Mute=="MUTE"){
            Main.mediaPlayer.play();
            Main.mediaPlayer.pause();
        } else {
            Main.mediaPlayer.play();
        }
    }
}