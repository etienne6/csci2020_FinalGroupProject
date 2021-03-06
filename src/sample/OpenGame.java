package sample;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class OpenGame{
    public static String[] OpenGame(){
        String userName = LoginController.getUserPlayer();
        String[] gameStats = null;
        String sep = System.getProperty("file.separator");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("." + sep + "src" + sep + "saved_games" + sep + userName + "_saveFiles"));
        File directory = fileChooser.getInitialDirectory();
        if (! directory.exists()){
            directory.mkdir();
        }
        Stage primaryStage = Main.getPrimaryStage();
        fileChooser.setTitle("Open Game File");
        File file = fileChooser.showOpenDialog(primaryStage.getScene().getWindow());

        Scanner in = new Scanner(System.in);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            br.close();

            String gameState = sb.toString();
            gameStats = gameState.split(",", -1);
            System.out.println("Attempting to load the following Game Stats: " + Arrays.toString(gameStats));
        } catch (IOException e) {
            System.err.println("Error opening file.");
        }
        return gameStats;
    }

}