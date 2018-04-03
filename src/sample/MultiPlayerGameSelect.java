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
import sample.model.Base;
import sample.network.Client;
import sample.network.MainServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class MultiPlayerGameSelect {
    public TextField username;
    public PasswordField password;
    public Button submitButton;
    public MenuItem newGame;
    public MenuItem openGame;
    public MenuItem saveGame;
    public MenuItem exitGame;
    public SeparatorMenuItem separator;
    public ImageView soundButton;
    public ImageView soundButtonOff;
    public String userName;
    public String actorName;
    public String actorHP;
    public String actorDefense;
    public String impactedName;
    public String impactedHP;
    public String impactedDefense;
    public String action;
    public String item;
    boolean playing = Main.mediaPlayer.getStatus().equals(MediaPlayer.Status.PLAYING);
    String currentPlayerName = LoginController.getUserPlayer();
    int port = 2222;
    Boolean isConnected = false;
    Socket sock;
    BufferedReader reader;
    PrintWriter writer;
    ArrayList<String> users = new ArrayList<>();


    public void initialize(){
        if (!playing) {
            soundButton.setOpacity(0.0);
            soundButtonOff.setOpacity(100.0);
        } else {
            soundButton.setOpacity(100.0);
            soundButtonOff.setOpacity(0.0);
        }
    }

    public void New() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("SelectMode.fxml"));
        Stage primaryStage = Main.getPrimaryStage();
        primaryStage.setTitle("KROGG The Destroyer - Mode Select");
        primaryStage.setScene(new Scene(root, 640, 400));
    }
    public void Save(){
    }
    public void Open(){
    }
    public void Back() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("SelectMode.fxml"));
        Stage primaryStage = Main.getPrimaryStage();
        primaryStage.setTitle("KROGG The Destroyer - Mode Select");
        primaryStage.setScene(new Scene(root, 640, 400));
    }
    public void Versus(){
        Client.StartClient();

    }
    public void Coop() throws Exception{
        Client.StartClient();
        socketCreator(currentPlayerName);
        users.add(currentPlayerName + "hey");
        MainServer.users.add(currentPlayerName);
        System.out.println(MainServer.users.size());
        //ArrayList<Base.Move> playerMove = CharacterChooserMultiplayer.userPlayer.getMoveList();
        //ArrayList<Base.Item> playerItems = CharacterChooserMultiplayer.userPlayer.getItemList();
        Parent root = FXMLLoader.load(getClass().getResource("CharacterChooserMultiplayer.fxml"));
        Stage primaryStage = Main.getPrimaryStage();
        primaryStage.setTitle("KROGG The Destroyer - Choose Your Character");
        primaryStage.setScene(new Scene(root, 640, 400));

    //Stage secondaryStage = new Stage();
    //Stage tertiaryStage = new Stage();
    //Stage quaternaryStage = new Stage();
    //startGame(secondaryStage,tertiaryStage,quaternaryStage);
    }



    private void socketCreator(String username) {
        if (isConnected == false)
        {

            try
            {
                sock = new Socket("localhost", port);
                InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(streamreader);
                writer = new PrintWriter(sock.getOutputStream());
                writer.println(username + ":has connected.:Connect");
                writer.flush();
                System.out.println("connected");
                isConnected = true;
            }
            catch (Exception ex)
            {
                System.err.println("error on socket creator");
            }

            //ListenThread();

        } else if (isConnected == true)
        {
            System.out.println("You are already connected. \n");
        }
    }

    public void userAdd(String data)
    {
        users.add(data);
    }

    public void startGame(Stage secondaryStage, Stage tertiaryStage, Stage quaternaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("CharacterChooser.fxml"));
        Parent root2 = FXMLLoader.load(getClass().getResource("CharacterChooser.fxml"));
        Parent root3 = FXMLLoader.load(getClass().getResource("CharacterChooser.fxml"));

        secondaryStage.setTitle("KROGG The Destroyer - Mode Select");
        secondaryStage.setScene(new Scene(root, 640, 400));
        secondaryStage.show();
        tertiaryStage.setTitle("KROGG The Destroyer - Mode Select");
        tertiaryStage.setScene(new Scene(root2, 640, 400));
        tertiaryStage.show();
        quaternaryStage.setTitle("KROGG The Destroyer - Mode Select");
        quaternaryStage.setScene(new Scene(root3, 640, 400));
        quaternaryStage.show();
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