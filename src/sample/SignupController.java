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

public class SignupController {
    public TextField username;
    public PasswordField password;
    public PasswordField PasswordConfirm;
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

    protected String newuserName = "";
    protected String newuserPass = "";
    protected String newuserPassCheck = "";
    protected final String dataBaseFile = "KroggDatabase.txt";
    public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
    public void ModeSelect() {
        Register();
    }
    public void Back() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Greeting.fxml"));
        Stage primaryStage = Main.getPrimaryStage();
        primaryStage.setTitle("KROGG The Destroyer - Welcome");
        primaryStage.setScene(new Scene(root, 640, 400));
    }

    public void Register(){
        boolean taken = false;
        try{
            newuserName = username.getText();
            newuserPass = password.getText();
            taken = CheckUsername(this.newuserName, "fluff", true);
            if(taken){
                feedback.setText("Error: username has been taken. Please try again.");

            } else {

                Writer writer = new BufferedWriter(new FileWriter(dataBaseFile, true));

                String newLine = System.getProperty("line.separator");
                writer.append(newLine + newuserName + " " + newuserPass);
                writer.close();

                feedback.setText("Your account now has been saved.");
                Parent root = FXMLLoader.load(getClass().getResource("SelectMode.fxml"));
                Stage primaryStage = Main.getPrimaryStage();
                primaryStage.setTitle("KROGG The Destroyer - Select Mode");
                primaryStage.setScene(new Scene(root, 640, 400));
            }

        }catch(IOException e){System.out.println(e);}
    }


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