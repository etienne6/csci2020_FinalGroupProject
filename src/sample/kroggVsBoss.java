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

    Boss1 boss1 = new Boss1();
    public TextField Boss1HP;
    float boss1HP = boss1.getHP();
    public TextField Boss1Speed;
    float boss1Speed = boss1.getSpeed();
    public TextField Boss1Dodge;
    float boss1Dodge = boss1.getDodge();
    public TextField Boss1Attack;
    float boss1Attack = boss1.getAttack();
    public TextField Boss1Defense;
    float boss1Defense = boss1.getDefense();

    Krogg krogg = new Krogg();
    public TextField KroggHP;
    float kroggHP = krogg.getHP();
    public TextField KroggSpeed;
    float kroggSpeed = krogg.getSpeed();
    public TextField KroggDodge;
    float kroggDodge = krogg.getDodge();
    public TextField KroggAttack;
    float kroggAttack = krogg.getAttack();
    public TextField KroggDefense;
    float kroggDefense = krogg.getDefense();




    float totalKroggToBoss1Damage = kroggAttack-boss1Defense;

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
    public void useAttack() {
        boss1HP = boss1HP - totalKroggToBoss1Damage;
        Boss1HP.setText(String.valueOf(boss1HP));
        // NEED TO IMPLEMENT A TIMER TO ERASE MESSAGE AFTER 5 SECONDS OR SO
        // moveAnnouncer.setText("");
        // damageAnnouncer.setText("");
        moveAnnouncer.setText("Krogg attacks boss!");
        String attackAnnouncement = ("It does " + totalKroggToBoss1Damage + " points of damage!");
        damageAnnouncer.setText(attackAnnouncement);
        turnNumber++;
        turn();
    }

    public void turn(){
        if ((turnNumber%2)==0){
            yourMove.setText("Your Move!");
            AttackButton.setDisable(false);
            PotionButton.setDisable(false);
        } else {
            yourMove.setText("Boss's Move!");
            AttackButton.setDisable(true);
            PotionButton.setDisable(true);
        }
    }

    public void runBoss1(){
        Boss1HP.setText(String.valueOf(boss1HP));
        Boss1Speed.setText(String.valueOf(boss1Speed));
        Boss1Dodge.setText(String.valueOf(boss1Dodge));
        Boss1Attack.setText(String.valueOf(boss1Attack));
        Boss1Defense.setText(String.valueOf(boss1Defense));
    }

    public void runKrogg(){
        KroggHP.setText(String.valueOf(kroggHP));
        KroggSpeed.setText(String.valueOf(kroggSpeed));
        KroggDodge.setText(String.valueOf(kroggDodge));
        KroggAttack.setText(String.valueOf(kroggAttack));
        KroggDefense.setText(String.valueOf(kroggDefense));
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