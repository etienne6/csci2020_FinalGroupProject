package sample;

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

import static sample.model.Battle_Simulation.chooseHero;

public class CharacterChooser {
    public TextField Username;
    public PasswordField Password;
    public MenuItem newGame;
    public MenuItem openGame;
    public MenuItem saveGame;
    public MenuItem exitGame;
    public SeparatorMenuItem separator;
    public ImageView soundButton;
    public ImageView soundButtonOff;
    boolean playing = Main.mediaPlayer.getStatus().equals(MediaPlayer.Status.PLAYING);
    public TextField LindaType;
    public TextField LindaHP;
    public TextField LindaSpeed;
    public TextField LindaDodge;
    public TextField LindaDefense;
    public TextField KroggType;
    public TextField KroggHP;
    public TextField KroggSpeed;
    public TextField KroggDodge;
    public TextField KroggDefense;
    public TextField GlenType;
    public TextField GlenHP;
    public TextField GlenSpeed;
    public TextField GlenDodge;
    public TextField GlenDefense;

    public MenuBar AttackBar;
    public Menu AttackMenu;
    public MenuItem Move1;
    public MenuItem Move2;
    public MenuItem Move3;
    public Menu ItemMenu;
    public MenuItem Item1;
    public MenuItem Item2;
    public MenuItem Item3;

    public static Base.Player userPlayer;

    private void setCharacter(Base.Player userPlayer) {
        CharacterChooser.userPlayer = userPlayer;
    }

    static public Base.Player getUserPlayer(){ return CharacterChooser.userPlayer;}

    public void initialize(){
        if (!playing) {
            soundButton.setOpacity(0.0);
            soundButtonOff.setOpacity(100.0);
        } else {
            soundButton.setOpacity(100.0);
            soundButtonOff.setOpacity(0.0);
        }
        Battle_Simulation.run();
        runLinda();
        runKrogg();
        runGlen();

    }

    public void New() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("SelectMode.fxml"));
        Stage primaryStage = Main.getPrimaryStage();
        primaryStage.setTitle("KROGG The Destroyer - Select Mode");
        primaryStage.setScene(new Scene(root, 640, 400));
    }
    public void Save(){}
    public void Open(){ OpenGame.OpenGame();}

    public void Back() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("NewGame.fxml"));
        Stage primaryStage = Main.getPrimaryStage();
        primaryStage.setTitle("KROGG The Destroyer - The Adventure Begins");
        primaryStage.setScene(new Scene(root, 640, 400));
    }

    public void pickKrogg() throws Exception{
        userPlayer = chooseHero("Krogg");
        setCharacter(userPlayer);
        Parent root = FXMLLoader.load(getClass().getResource("SinglePlayerFight.fxml"));
        Stage primaryStage = Main.getPrimaryStage();
        primaryStage.setTitle("KROGG The Destroyer - Battle");
        primaryStage.setScene(new Scene(root, 640, 400));
    }

    public void pickLinda() throws Exception{
        userPlayer = chooseHero("Linda");
        Parent root = FXMLLoader.load(getClass().getResource("SinglePlayerFight.fxml"));
        Stage primaryStage = Main.getPrimaryStage();
        primaryStage.setTitle("KROGG The Destroyer - Battle");
        primaryStage.setScene(new Scene(root, 640, 400));;
    }

    public void pickGlen() throws Exception {
        userPlayer = chooseHero("Glen");
        Parent root = FXMLLoader.load(getClass().getResource("SinglePlayerFight.fxml"));
        Stage primaryStage = Main.getPrimaryStage();
        primaryStage.setTitle("KROGG The Destroyer - Battle");
        primaryStage.setScene(new Scene(root, 640, 400));
    }

    public void usePotion() {}
    public void useAttack() {}

    public void runLinda(){
        Linda linda = new Linda();
        LindaType.setText(linda.getType());
        LindaHP.setText(String.valueOf(linda.getHP()));
        LindaSpeed.setText(String.valueOf(linda.getSpeed()));
        LindaDodge.setText(String.valueOf(linda.getDodge()));
        LindaDefense.setText(String.valueOf(linda.getDefense()));

    }

    public void runKrogg(){
        Krogg krogg = new Krogg();
        KroggType.setText(krogg.getType());
        KroggHP.setText(String.valueOf(krogg.getHP()));
        KroggSpeed.setText(String.valueOf(krogg.getSpeed()));
        KroggDodge.setText(String.valueOf(krogg.getDodge()));
        KroggDefense.setText(String.valueOf(krogg.getDefense()));
    }

    public void runGlen(){
        Glen glen = new Glen();
        GlenType.setText(glen.getType());
        GlenHP.setText(String.valueOf(glen.getHP()));
        GlenSpeed.setText(String.valueOf(glen.getSpeed()));
        GlenDodge.setText(String.valueOf(glen.getDodge()));
        GlenDefense.setText(String.valueOf(glen.getDefense()));
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