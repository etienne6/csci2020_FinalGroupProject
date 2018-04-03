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
    public TextField username;
    public MenuItem newGame;
    public MenuItem openGame;
    public MenuItem saveGame;
    public MenuItem exitGame;
    public SeparatorMenuItem separator;
    public ImageView soundButton;
    public ImageView soundButtonOff;
    boolean playing = Main.mediaPlayer.getStatus().equals(MediaPlayer.Status.PLAYING);
    public TextField lindaType;
    public TextField lindaHP;
    public TextField lindaSpeed;
    public TextField lindaDodge;
    public TextField lindaDefense;
    public TextField kroggType;
    public TextField kroggHP;
    public TextField kroggSpeed;
    public TextField kroggDodge;
    public TextField kroggDefense;
    public TextField glenType;
    public TextField glenHP;
    public TextField glenSpeed;
    public TextField glenDodge;
    public TextField glenDefense;

    public MenuBar attackBar;
    public Menu attackMenu;
    public MenuItem move1;
    public MenuItem move2;
    public MenuItem move3;
    public Menu itemMenu;
    public MenuItem item1;
    public MenuItem item2;
    public MenuItem item3;


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
        Parent root = FXMLLoader.load(getClass().getResource("NewGame.fxml"));
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

    // start battle with Krogg as hero
    public void pickKrogg() throws Exception{
        userPlayer = chooseHero("Krogg");
        setCharacter(userPlayer);
        Parent root = FXMLLoader.load(getClass().getResource("SinglePlayerFight.fxml"));
        Stage primaryStage = Main.getPrimaryStage();
        primaryStage.setTitle("KROGG The Destroyer - Battle");
        primaryStage.setScene(new Scene(root, 640, 400));
    }
    // start battle with Linda as hero
    public void pickLinda() throws Exception{
        userPlayer = chooseHero("Linda");
        Parent root = FXMLLoader.load(getClass().getResource("SinglePlayerFight.fxml"));
        Stage primaryStage = Main.getPrimaryStage();
        primaryStage.setTitle("KROGG The Destroyer - Battle");
        primaryStage.setScene(new Scene(root, 640, 400));;
    }
    // start battle with Glen as hero
    public void pickGlen() throws Exception {
        userPlayer = chooseHero("Glen");
        Parent root = FXMLLoader.load(getClass().getResource("SinglePlayerFight.fxml"));
        Stage primaryStage = Main.getPrimaryStage();
        primaryStage.setTitle("KROGG The Destroyer - Battle");
        primaryStage.setScene(new Scene(root, 640, 400));
    }

    // access information on Linda
    public void runLinda(){
        Linda linda = new Linda();
        lindaType.setText(linda.getType());
        lindaHP.setText(String.valueOf(linda.getHP()));
        lindaSpeed.setText(String.valueOf(linda.getSpeed()));
        lindaDodge.setText(String.valueOf(linda.getDodge()));
        lindaDefense.setText(String.valueOf(linda.getDefense()));

    }

    // access information on Krogg
    public void runKrogg(){
        Krogg krogg = new Krogg();
        kroggType.setText(krogg.getType());
        kroggHP.setText(String.valueOf(krogg.getHP()));
        kroggSpeed.setText(String.valueOf(krogg.getSpeed()));
        kroggDodge.setText(String.valueOf(krogg.getDodge()));
        kroggDefense.setText(String.valueOf(krogg.getDefense()));
    }

    // access information on Glen
    public void runGlen(){
        Glen glen = new Glen();
        glenType.setText(glen.getType());
        glenHP.setText(String.valueOf(glen.getHP()));
        glenSpeed.setText(String.valueOf(glen.getSpeed()));
        glenDodge.setText(String.valueOf(glen.getDodge()));
        glenDefense.setText(String.valueOf(glen.getDefense()));
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