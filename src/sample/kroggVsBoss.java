package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import sample.model.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static sample.model.Battle_Simulation.*;
import static sample.model.Battle_Simulation.getCurrentBoss;

public class kroggVsBoss {
    public MenuItem newGame;
    public MenuItem openGame;
    public MenuItem saveGame;
    public MenuItem exitGame;
    public SeparatorMenuItem separator;

    public ImageView playerPic;
    public ImageView bossPic;

    public ImageView soundButton;
    public ImageView soundButtonOff;
    boolean playing = Main.mediaPlayer.getStatus().equals(MediaPlayer.Status.PLAYING);
    public TextField yourMove;
    public TextArea damageAnnouncer;

    public TextField battleInfo;
    public TextField heroName;
    public TextField villainName;

    public Base.Player currentBoss = getCurrentBoss(null);
    public Base.Player userPlayer = chooseHero("Krogg");

    Image draconisPic = new Image("/media/boss2.png");
    Image dragonPic = new Image("/media/boss3.png");
    //Boss boss1 = new Boss1();
    public TextField BossHP;
    float bossHP = currentBoss.getHP();
    public TextField BossSpeed;
    float bossSpeed = currentBoss.getSpeed();
    public TextField BossDodge;
    float bossDodge = currentBoss.getDodge();
    public TextField BossDefense;
    float bossDefense = currentBoss.getDefense();
    ArrayList<Base.Move> bossMoves = currentBoss.getMoveList();

    Boss2 boss2 = new Boss2();
    public TextField Boss2HP;
    float boss2HP = boss2.getHP();
    public TextField Boss2Speed;
    float boss2Speed = boss2.getSpeed();
    public TextField Boss2Dodge;
    float boss2Dodge = boss2.getDodge();
    public TextField Boss2Defense;
    float boss2Defense = boss2.getDefense();
    ArrayList<Base.Move> boss2Moves = boss2.getMoveList();

    Boss3 boss3 = new Boss3();
    public TextField Boss3HP;
    float boss3HP = boss3.getHP();
    public TextField Boss3Speed;
    float boss3Speed = boss3.getSpeed();
    public TextField Boss3Dodge;
    float boss3Dodge = boss3.getDodge();
    public TextField Boss3Defense;
    float boss3Defense = boss3.getDefense();
    ArrayList<Base.Move> boss3Moves = boss3.getMoveList();

    public TextField KroggHP;
    float kroggHP = userPlayer.getHP();
    public TextField KroggSpeed;
    float kroggSpeed = userPlayer.getSpeed();
    public TextField KroggDodge;
    float kroggDodge = userPlayer.getDodge();
    public TextField KroggDefense;
    float kroggDefense = userPlayer.getDefense();

    ArrayList<Base.Move> kroggMoves = userPlayer.getMoveList();
    public MenuBar AttackBar;
    public Menu AttackMenu;
    public String move1 = kroggMoves.get(0).moveName();
    public String move2 = kroggMoves.get(1).moveName();
    public String move3 = kroggMoves.get(2).moveName();
    public String move1Type = kroggMoves.get(0).moveType();
    public String move2Type = kroggMoves.get(1).moveType();
    public String move3Type = kroggMoves.get(2).moveType();
    public float move1Power = kroggMoves.get(0).movePower();
    public float move2Power = kroggMoves.get(1).movePower();
    public float move3Power = kroggMoves.get(2).movePower();
    public MenuItem Move1;
    public MenuItem Move2;
    public MenuItem Move3;
    public Menu ItemMenu;
    public MenuItem Item1;
    public MenuItem Item2;
    public MenuItem Item3;



    int turnNumber = 0;

    public void initialize(){
        if (!playing) {
            soundButton.setOpacity(0.0);
            soundButtonOff.setOpacity(100.0);
        } else {
            soundButton.setOpacity(100.0);
            soundButtonOff.setOpacity(0.0);
        }
        battleInfo.setText("Battle! " + userPlayer.getName() + " vs. " + currentBoss.getName());
        heroName.setText(userPlayer.getName());
        villainName.setText(currentBoss.getName());
        yourMove.setOpacity(0.0);
        Battle_Simulation.run();
        runBoss();
        runKrogg();
        Move1.setText("Attack: '" + move1 + "' - Type: " + move1Type + " - Damage: " + move1Power);
        Move2.setText("Attack: '" + move2 + "' - Type: " + move2Type + " - Damage: " + move2Power);
        Move3.setText("Attack: '" + move3 + "' - Type: " + move3Type + " - Damage: " + move3Power);
        currentBoss = getCurrentBoss(currentBoss);
        String firstPlayer = chooseFirst(userPlayer,currentBoss);
        turn(firstPlayer);
   }

    public void New() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("selectMode.fxml"));
        Stage primaryStage = Main.getPrimaryStage();
        primaryStage.setTitle("KROGG The Destroyer - Select Mode");
        primaryStage.setScene(new Scene(root, 640, 400));
    }
    public void Save(){ SaveGame.SaveGame();}
    public void Open(){ OpenGame.OpenGame();}
/*
    public void usePotion() {}
    */
    public void useAttack1() {
        yourMove.setOpacity(0.0);
        String attackAnnouncement = damage(kroggMoves.get(0),userPlayer,currentBoss);
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        damageAnnouncer.setText("");
                    }
                },
                5000
        );
        damageAnnouncer.setText(attackAnnouncement);
        BossHP.setText(String.valueOf(currentBoss.getHP()));
        BossDefense.setText(String.valueOf(currentBoss.getDefense()));
        turn(chooseFirst(userPlayer,currentBoss));
    }

    public void useAttack2() {
        yourMove.setOpacity(0.0);
        String attackAnnouncement = damage(kroggMoves.get(1),userPlayer,currentBoss);
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        damageAnnouncer.setText("");
                    }
                },
                5000
        );
        damageAnnouncer.setText(attackAnnouncement);
        BossHP.setText(String.valueOf(currentBoss.getHP()));
        BossDefense.setText(String.valueOf(currentBoss.getDefense()));
        turn(chooseFirst(userPlayer,currentBoss));
    }

    public void useAttack3() {
        yourMove.setOpacity(0.0);
        String attackAnnouncement = damage(kroggMoves.get(2),userPlayer,currentBoss);
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        damageAnnouncer.setText("");
                    }
                },
                5000
        );
        damageAnnouncer.setText(attackAnnouncement);
        BossHP.setText(String.valueOf(currentBoss.getHP()));
        BossDefense.setText(String.valueOf(currentBoss.getDefense()));
        turn(chooseFirst(userPlayer,currentBoss));
    }

    public void turn(String firstPlayer){
        yourMove.setOpacity(0.0);
        if(isDead(userPlayer)){
            damageAnnouncer.setText("GAME OVER. \nYou fought valiantly, brave warrior. Alas, it was not enough. UOITOPIA will fall to evil... and it's all your fault...");
        }
        if(isDead(currentBoss)){
            bossIsDead();
        }
        if (firstPlayer == "Krogg"){
            yourMove.setText("Your Move!");
            AttackMenu.setDisable(false);
            ItemMenu.setDisable(false);
            yourMove.setOpacity(100.0);
        } else {
            yourMove.setText("Boss's Move!");
            AttackMenu.setDisable(true);
            ItemMenu.setDisable(true);
            yourMove.setOpacity(100.0);
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            damageAnnouncer.setText("");
                        }
                    },
                    5000
            );
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                           damageAnnouncer.setText(rando_attack(currentBoss,userPlayer));
                            KroggHP.setText(String.valueOf(userPlayer.getHP()));
                            KroggDefense.setText(String.valueOf(userPlayer.getDefense()));
                            turn(chooseFirst(userPlayer,currentBoss));
                        }
                    },
                    5000
            );

        }
    }

    public void runBoss(){
        BossHP.setText(String.valueOf(currentBoss.getHP()));
        BossSpeed.setText(String.valueOf(currentBoss.getSpeed()));
        BossDodge.setText(String.valueOf(currentBoss.getDodge()));
        BossDefense.setText(String.valueOf(currentBoss.getDefense()));
    }

    public void runKrogg(){
        KroggHP.setText(String.valueOf(userPlayer.getHP()));
        KroggSpeed.setText(String.valueOf(userPlayer.getSpeed()));
        KroggDodge.setText(String.valueOf(userPlayer.getDodge()));
        KroggDefense.setText(String.valueOf(userPlayer.getDefense()));
    }
    public void bossIsDead(){
        damageAnnouncer.setText("You have slain the boss! \nOh no, here comes another one!");
        currentBoss = getCurrentBoss(currentBoss);
        runBoss();
        userPlayer.setHP(800.0f);
        userPlayer.setDefense(85.0f);
        runKrogg();
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        battleInfo.setText("Battle! " + userPlayer.getName() + " vs. " + currentBoss.getName());
                        heroName.setText(userPlayer.getName());
                        villainName.setText(currentBoss.getName());
                        if (currentBoss.getName()=="Draconis"){
                            bossPic.setImage(draconisPic);
                        } else if (currentBoss.getName()=="Dragon"){
                            bossPic.setImage(dragonPic);
                        }
                    }
                },
                6000
        );
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