package sample;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class OpenGame{
    public static File OpenGame(){
        String sep = System.getProperty("file.separator");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("." + sep + "src" + sep + "saved_games"));
        Stage primaryStage = Main.getPrimaryStage();
        fileChooser.setTitle("Open Game File");
        File file = fileChooser.showOpenDialog(primaryStage.getScene().getWindow());
        System.out.print("The file you have opened is " + file);
        return file;
    }
}