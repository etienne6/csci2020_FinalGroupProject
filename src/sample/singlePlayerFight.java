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

import static sample.model.Battle_Simulation.*;
import static sample.model.Battle_Simulation.getCurrentBoss;

public class singlePlayerFight {
    public Button newGameButton;
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
    public Base.Player userPlayer = characterChooser.getUserPlayer();

    Image kroggPic = new Image("/media/krogg.png");
    Image lindaPic = new Image("/media/lindas.png");
    Image glenPic = new Image("/media/glen.png");
    Image draconisPic = new Image("/media/boss2.png");
    Image dragonPic = new Image("/media/boss3.png");

    public TextField BossHP;
    public TextField BossSpeed;
    public TextField BossDodge;
    public TextField BossDefense;

    public TextField PlayerHP;
    public TextField PlayerSpeed;
    public TextField PlayerDodge;
    public TextField PlayerDefense;

    ArrayList<Base.Move> playerMoves = userPlayer.getMoveList();
    ArrayList<Base.Item> playerItems = userPlayer.getItemList();
    public MenuBar AttackBar;
    public Menu AttackMenu;
    public String move1 = playerMoves.get(0).moveName();
    public String move2 = playerMoves.get(1).moveName();
    public String move3 = playerMoves.get(2).moveName();
    public String move1Type = playerMoves.get(0).moveType();
    public String move2Type = playerMoves.get(1).moveType();
    public String move3Type = playerMoves.get(2).moveType();
    public float move1Power = playerMoves.get(0).movePower();
    public float move2Power = playerMoves.get(1).movePower();
    public float move3Power = playerMoves.get(2).movePower();
    public String item1 = playerItems.get(0).itemName();
    public String item2 = playerItems.get(1).itemName();
    public String item3 = playerItems.get(2).itemName();
    public String item1Type = playerItems.get(0).itemType();
    public String item2Type = playerItems.get(1).itemType();
    public String item3Type = playerItems.get(2).itemType();
    public float item1Power = playerItems.get(0).itemPower();
    public float item2Power = playerItems.get(1).itemPower();
    public float item3Power = playerItems.get(2).itemPower();
    public int item1Quantity = playerItems.get(0).itemQuantity();
    public int item2Quantity = playerItems.get(1).itemQuantity();
    public int item3Quantity = playerItems.get(2).itemQuantity();
    public MenuItem Move1;
    public MenuItem Move2;
    public MenuItem Move3;
    public Menu ItemMenu;
    public MenuItem Item1;
    public MenuItem Item2;
    public MenuItem Item3;
    public Label moveChooseLabel;

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
        if (userPlayer.getName()=="Krogg") {
            playerPic.setImage(kroggPic);
        } else if (userPlayer.getName()=="Linda") {
            playerPic.setImage(lindaPic);
        } else {
            playerPic.setImage(glenPic);
        }
        yourMove.setOpacity(0.0);
        Battle_Simulation.run();
        runBoss();
        runPlayer();
        Move1.setText("Attack: '" + move1 + "' - Type: " + move1Type + " - Damage: " + move1Power);
        Move2.setText("Attack: '" + move2 + "' - Type: " + move2Type + " - Damage: " + move2Power);
        Move3.setText("Attack: '" + move3 + "' - Type: " + move3Type + " - Damage: " + move3Power);
        Item1.setText("Item: '" + item1 + "' - Type: " + item1Type + " - Healing: " + item1Power +
                " - Remaining: " + item1Quantity);
        Item2.setText("Item: '" + item2 + "' - Type: " + item2Type + " - Defense Boost: " + item2Power +
                " - Remaining: " + item2Quantity);
        Item3.setText("Item: '" + item3 + "' - Type: " + item3Type + " - Healing: " + item3Power +
                " - Remaining: " + item3Quantity);
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

    public void useAttack1() {
        yourMove.setOpacity(0.0);
        String attackAnnouncement = damage(playerMoves.get(0),userPlayer,currentBoss);
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
        String attackAnnouncement = damage(playerMoves.get(1),userPlayer,currentBoss);
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
        String attackAnnouncement = damage(playerMoves.get(2),userPlayer,currentBoss);
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
    public void useItem1() {
        yourMove.setOpacity(0.0);
        if (item1Quantity > 0) {
            String attackAnnouncement = heal(playerItems.get(0), userPlayer, userPlayer);
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
            PlayerHP.setText(String.valueOf(userPlayer.getHP()));
            PlayerDefense.setText(String.valueOf(userPlayer.getDefense()));
            turn(chooseFirst(userPlayer, currentBoss));
            item1Quantity--;
            Item1.setText("Item: '" + item1 + "' - Type: " + item1Type + " - Healing: " + item1Power +
                    " - Remaining: " + item1Quantity);
            if (item1Quantity == 0) {
                Item1.setDisable(true);
            }
        }
    }
    public void useItem2() {
        yourMove.setOpacity(0.0);
        if (item2Quantity > 0) {
            String attackAnnouncement = heal(playerItems.get(1), userPlayer, userPlayer);
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
            PlayerHP.setText(String.valueOf(userPlayer.getHP()));
            PlayerDefense.setText(String.valueOf(userPlayer.getDefense()));
            turn(chooseFirst(userPlayer, currentBoss));
            item2Quantity--;
            Item2.setText("Item: '" + item2 + "' - Type: " + item2Type + " - Defense Boost: " + item2Power +
                    " - Remaining: " + item2Quantity);
            if (item2Quantity == 0) {
                Item2.setDisable(true);
            }
        }
    }
    public void useItem3() {
        yourMove.setOpacity(0.0);
        if (item3Quantity > 0) {
            String attackAnnouncement = heal(playerItems.get(2), userPlayer, userPlayer);
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
            PlayerHP.setText(String.valueOf(userPlayer.getHP()));
            PlayerDefense.setText(String.valueOf(userPlayer.getDefense()));
            turn(chooseFirst(userPlayer, currentBoss));
            item3Quantity--;
            Item3.setText("Item: '" + item3 + "' - Type: " + item3Type + " - Healing: " + item3Power +
                    " - Remaining: " + item3Quantity);
            if (item3Quantity == 0) {
                Item3.setDisable(true);
            }
        }
    }

    public void turn(String firstPlayer){
        yourMove.setOpacity(0.0);
        if(userPlayer.hasLost()){
            damageAnnouncer.setText("GAME OVER. \nYou fought valiantly, brave warrior. Alas, it was not enough. UOITOPIA will fall to evil... and it's all your fault...");
            moveChooseLabel.setOpacity(0.0);
            yourMove.setOpacity(0.0);
            AttackMenu.setDisable(true);
            ItemMenu.setDisable(true);
            newGameButton.setVisible(true);
        }
        if(currentBoss.hasLost()){
            if (currentBoss.getName()!="Dragon"){
                bossIsDead();
            } else {
                dragonIsDead();
            }
        }
        if (!currentBoss.hasLost() && !userPlayer.hasLost()) {
            if (firstPlayer == userPlayer.getName()) {
                yourMove.setText("Your Move!");
                moveChooseLabel.setOpacity(100.0);
                AttackMenu.setDisable(false);
                ItemMenu.setDisable(false);
                yourMove.setOpacity(100.0);
            } else {
                yourMove.setText(currentBoss.getName() +"'s Move!");
                moveChooseLabel.setOpacity(0.0);

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
                        4000
                );
                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                damageAnnouncer.setText(rando_attack(currentBoss, userPlayer));
                                PlayerHP.setText(String.valueOf(userPlayer.getHP()));
                                PlayerDefense.setText(String.valueOf(userPlayer.getDefense()));
                                turn(chooseFirst(userPlayer, currentBoss));
                            }
                        },
                        5000
                );

            }
        }
    }

    public void runBoss(){
        BossHP.setText(String.valueOf(currentBoss.getHP()));
        BossSpeed.setText(String.valueOf(currentBoss.getSpeed()));
        BossDodge.setText(String.valueOf(currentBoss.getDodge()));
        BossDefense.setText(String.valueOf(currentBoss.getDefense()));
    }

    public void runPlayer(){
        PlayerHP.setText(String.valueOf(userPlayer.getHP()));
        PlayerSpeed.setText(String.valueOf(userPlayer.getSpeed()));
        PlayerDodge.setText(String.valueOf(userPlayer.getDodge()));
        PlayerDefense.setText(String.valueOf(userPlayer.getDefense()));
    }
    public void bossIsDead(){
        damageAnnouncer.setText("You have slain the boss! \nOh no, here comes another one!");
        currentBoss = getCurrentBoss(currentBoss);
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        userPlayer.setHP(userPlayer.getMaxHP());
                        userPlayer.setDefense(userPlayer.getMaxDefense());
                        item1Quantity = 1;
                        item2Quantity = 2;
                        item3Quantity = 3;
                        Item1.setText("Item: '" + item1 + "' - Type: " + item1Type + " - Healing: " + item1Power +
                                " - Remaining: " + item1Quantity);
                        Item2.setText("Item: '" + item2 + "' - Type: " + item2Type + " - Healing: " + item2Power +
                                " - Remaining: " + item2Quantity);

                        Item3.setText("Item: '" + item3 + "' - Type: " + item3Type + " - Healing: " + item3Power +
                                " - Remaining: " + item3Quantity);
                        Item1.setDisable(false);
                        Item2.setDisable(false);
                        Item3.setDisable(false);
                        runPlayer();
                        runBoss();
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
                5000
        );
    }
    public void dragonIsDead() {
        damageAnnouncer.setText("Huzzah! You have defeated Dragon and his evil minions! \n UOITOPIA will be forever in your debt!");
        moveChooseLabel.setOpacity(0.0);
        yourMove.setOpacity(0.0);
        AttackMenu.setDisable(true);
        ItemMenu.setDisable(true);
        newGameButton.setVisible(true);
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