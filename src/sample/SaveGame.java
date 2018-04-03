package sample;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveGame {
    // use file chosoer and directory chooser to create a save file based on current game stats
    // file is automatically named for date and time to ensure no overlap/overwrites
    public static void SaveGame(String gameState) {
        String userName = LoginController.getUserPlayer();
        String sep = System.getProperty("file.separator");
        Stage primaryStage = Main.getPrimaryStage();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("." + sep + "src" + sep + "saved_games" + sep + userName + "_saveFiles"));
        File directory = fileChooser.getInitialDirectory();
        if (! directory.exists()){
            directory.mkdir();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd___hh-mm-ss");
        Date now = new Date();
        String timeAndDate = simpleDateFormat.format(now);
        fileChooser.setInitialFileName("KroggSaveGame-" + timeAndDate);
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text doc(*.txt)", "*.txt"));
        File f = fileChooser.showSaveDialog(primaryStage);
        if (!f.getName().contains(".")) {
            f = new File(f.getAbsolutePath() + ".txt");
        }

        while (f == null) {
            f = fileChooser.showSaveDialog(null);
        }

        SaveFile(gameState, f);
    }
    private static void SaveFile(String gameState, File file){
        try {
            FileWriter fileWriter = null;
            fileWriter = new FileWriter(file);
            fileWriter.write(gameState);
            fileWriter.close();
        } catch (IOException ex) {
            System.err.println("Could not save game.");
        }
    }
}