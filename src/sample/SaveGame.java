package sample;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveGame {
    public static void SaveGame(String gameState) {
        String sep = System.getProperty("file.separator");
        Stage primaryStage = Main.getPrimaryStage();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("." + sep + "src" + sep + "saved_games"));
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
            System.out.println("starting filewriter");
            FileWriter fileWriter = null;
            fileWriter = new FileWriter(file);
            System.out.println("starting to write");
            fileWriter.write(gameState);
            fileWriter.close();
            System.out.println("closing file");
        } catch (IOException ex) {
           System.err.println("Could not save game.");
        }

    }
}