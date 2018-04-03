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

import java.io.*;
import java.net.Socket;

public class LoginController {
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
    public TextField feedback;
    boolean playing = Main.mediaPlayer.getStatus().equals(MediaPlayer.Status.PLAYING);
    protected final String dataBaseFile = "KroggDatabase.txt";
    public static String playerName;

    int port = 2222;
    Boolean isConnected = false;
    Socket sock;
    BufferedReader reader;
    PrintWriter writer;

    public void initialize(){
        if (!playing) {
            soundButton.setOpacity(0.0);
            soundButtonOff.setOpacity(100.0);
        } else {
            soundButton.setOpacity(100.0);
            soundButtonOff.setOpacity(0.0);
        }
    }

    public void New(){
    }
    public void Save(){
    }
    public void Open(){
    }
    public void Back() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Greeting.fxml"));
        Stage primaryStage = Main.getPrimaryStage();
        primaryStage.setTitle("KROGG The Destroyer - Welcome");
        primaryStage.setScene(new Scene(root, 640, 400));
    }
    // once username and password are submitted, create socket
    public void Submit() throws Exception{
        String userName = username.getText();
        String userPass = password.getText();
        socketCreator(userName, userPass);
        SignIn(userName, userPass);
    }

    // if sign in is successful, they may enter the game
    public void SignIn(String userName, String userPass) throws Exception{
        boolean success = true;

        success = CheckUsername(userName, userPass, false);
        if(success){
            setPlayer(userName);
            feedback.setText("You have successfully logged in.");
            Parent root = FXMLLoader.load(getClass().getResource("NewGame.fxml"));
            Stage primaryStage = Main.getPrimaryStage();
            primaryStage.setTitle("KROGG The Destroyer - The Adventure begins");
            primaryStage.setScene(new Scene(root, 640, 400));
        } else {
            feedback.setText("Password or Username may be incorrect. Please try again.");
        }
    }

    // check if username and password are valid
    public boolean CheckUsername(String user, String pass, boolean register){
        try{
            FileReader fileReader = new FileReader(this.dataBaseFile);
            BufferedReader bin = new BufferedReader(fileReader);
            try{
                while (true) {
                    final String line = bin.readLine();
                    if (line == null) break;

                    String[] array = line.split(" ");
                    if(array[0].equals(user)){
                        if(register){
                            return true;
                        }
                        if(array[1].equals(pass)){
                            return true;
                        }
                    }
                }

                bin.close();
                fileReader.close();
            }catch(IOException e){System.out.println(e);}
        }catch(FileNotFoundException e){System.out.println("Unable to open file.");}
        return false;
    }

    // create socket
    private void socketCreator(String username, String password) {
        if (isConnected == false)
        {
            try
            {
                sock = new Socket("localhost", port);
                InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(streamreader);
                writer = new PrintWriter(sock.getOutputStream());
                writer.println(username + ":" + password + ":has connected.:Connect");
                writer.flush();
                System.out.println("connected");
                isConnected = true;
            }
            catch (Exception ex)
            {
                System.err.println("error on socket creator");
            }
        } else if (isConnected == true){
            System.out.println("You are already connected. \n");
        }
    }

    // set player name based on username for later
    private void setPlayer(String playerName) {
        this.playerName = playerName;
    }

    static public String getUserPlayer(){ return playerName;}

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