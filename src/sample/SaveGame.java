package sample;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveGame {
    public static void SaveGame() {
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

        PrintWriter outFile = null;
        try {
            outFile = new PrintWriter(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
/*
        for(int i = 0; i<table.getItems().size(); i++){
            outFile.println(table.getItems().get(i).toString());
        }
        */

        outFile.close();
    }
}