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
import sample.model.*;

public class kroggVsBoss {
    public Button AttackButton;
    public Button PotionButton;
    public MenuItem newGame;
    public MenuItem openGame;
    public MenuItem saveGame;
    public MenuItem exitGame;
    public SeparatorMenuItem separator;
    public ImageView soundButton;
    public ImageView soundButtonOff;
    boolean playing = Main.mediaPlayer.getStatus().equals(MediaPlayer.Status.PLAYING);
    public TextField yourMove;
    public TextField moveAnnouncer;
    public TextField damageAnnouncer;
    public TextField Boss1HP;
    public TextField Boss1Speed;
    public TextField Boss1Dodge;
    public TextField Boss1Attack;
    public TextField Boss1Defense;
    public TextField KroggHP;
    public TextField KroggSpeed;
    public TextField KroggDodge;
    public TextField KroggAttack;
    public TextField KroggDefense;
    int turnNumber = 0;

    public void initialize(){
        if (!playing) {
            soundButton.setOpacity(0.0);
            soundButtonOff.setOpacity(100.0);
        } else {
            soundButton.setOpacity(100.0);
            soundButtonOff.setOpacity(0.0);
        }
        Battle_Simulation.run();
        runBoss1();
        runKrogg();
        turn();


   }

    public void New() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("selectMode.fxml"));
        Stage primaryStage = Main.getPrimaryStage();
        primaryStage.setTitle("KROGG The Destroyer - Select Mode");
        primaryStage.setScene(new Scene(root, 640, 400));
    }
    public void Save(){ SaveGame.SaveGame();}
    public void Open(){ OpenGame.OpenGame();}

    public void usePotion() {}
    public void useAttack() {}

    public void turn(){
        if ((turnNumber%2)==0){
            yourMove.setText("Your Move!");
            AttackButton.setDisable(false);
            PotionButton.setDisable(false);
            turnNumber++;
        } else {
            yourMove.setText("Boss's Move!");
            AttackButton.setDisable(true);
            PotionButton.setDisable(true);
            turnNumber++;
        }
    }

    public void runBoss1(){

        Boss1 boss1 = new Boss1();
        Boss1HP.setText(String.valueOf(boss1.getHP()));
        Boss1Speed.setText(String.valueOf(boss1.getSpeed()));
        Boss1Dodge.setText(String.valueOf(boss1.getDodge()));
        Boss1Attack.setText(String.valueOf(boss1.getAttack()));
        Boss1Defense.setText(String.valueOf(boss1.getDefense()));
    }

    public void runKrogg(){
        Krogg krogg = new Krogg();
        KroggHP.setText(String.valueOf(krogg.getHP()));
        KroggSpeed.setText(String.valueOf(krogg.getSpeed()));
        KroggDodge.setText(String.valueOf(krogg.getDodge()));
        KroggAttack.setText(String.valueOf(krogg.getAttack()));
        KroggDefense.setText(String.valueOf(krogg.getDefense()));
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