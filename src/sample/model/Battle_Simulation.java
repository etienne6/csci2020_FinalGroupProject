package sample.model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import sample.model.Base.*;

public class Battle_Simulation {
    private static ArrayList < Player > heroesArrayList = new ArrayList< Player >();
    public static ArrayList< Player > bossArrayList = new ArrayList< Player >();
    private static Player userPlayer;
    private static Player currentBoss = null;

    public static void run(){
        Heroes hero = new Heroes();
        Bosses boss = new Bosses();

        heroesArrayList = hero.heroList();
        bossArrayList = boss.bossList();

        /*

        System.out.println(heroesArrayList.get(0).getName());
        System.out.println(heroesArrayList.get(1).getName());
        System.out.println(heroesArrayList.get(2).getName());
        System.out.println(bossArrayList.get(0).getName());
        System.out.println(bossArrayList.get(1).getName());
        System.out.println(bossArrayList.get(2).getName());

*/
        //userPlayer = chooseHero("Krogg");
        //currentBoss = getCurrentBoss(currentBoss);
        //Battle implemented
        //battle(userPlayer, currentBoss);


    }

    /*
    Quick method to pick characters to start the game. Probably going to be buttons to select characters,
    but using terminal input for now where you just type in character name.
    */
    public static Player chooseHero(String userHeroPick){

        Player heroPick = new Player("Not initialized", "None", 0f, 0f, 0f, 0f, 0f, 0f);

        switch(userHeroPick){
            case "Krogg": heroPick = heroesArrayList.get(0);
                break;
            case "Linda": heroPick = heroesArrayList.get(1);
                break;
            case "Glen": heroPick = heroesArrayList.get(2);
        }

        return heroPick;
    }

    public static Player chooseBoss(String userBossPick){

        Player bossPick = new Player("Not initialized", "None", 0f, 0f, 0f, 0f, 0f, 0f);

        switch(userBossPick){
            case "Professor X": bossPick = bossArrayList.get(0);
                break;
            case "Draconis": bossPick = bossArrayList.get(1);
                break;
            case "Dragon": bossPick = bossArrayList.get(2);
        }

        return bossPick;
    }

    public static String chooseFirst(Player userHeroPick, Player currentBoss){
        boolean userProb = new Random().nextInt((int)userHeroPick.getSpeed())>50;
        boolean bossProb = new Random().nextInt((int)currentBoss.getSpeed())>50;

        while((userProb == true && bossProb == false) || (userProb == false && bossProb == false)){
            userProb = new Random().nextInt((int)userHeroPick.getSpeed())>50;
            bossProb = new Random().nextInt((int)currentBoss.getSpeed())>50;
        }

        if(userProb == true){
            return userHeroPick.getName();
        }else{
            return currentBoss.getName();
        }
    }

    public static Player getCurrentBoss(Player currentBoss){
        if(currentBoss == null){
            return bossArrayList.get(0);
        }else{
            return bossArrayList.get(bossArrayList.indexOf(currentBoss)+1);
        }
    }

    //returns the damage done by a Move
    public static String damage(Move move, Player attacker, Player player){

        float playerDefense = player.getDefense();
        float damageCount = move.movePower();
        float playerHP = player.getHP();

        if(playerDefense > 0){
            playerDefense = playerDefense - move.movePower();
            player.setDefense(playerDefense);
            return attacker.getName() + " does " + damageCount + " points of damage to " + player.getName() + "'s defense with " + move.moveName() + "!";
        }else{
            playerHP = playerHP - move.movePower();
            player.setHP(playerHP);
            return attacker.getName() + " does " + damageCount + " points of damage to " + player.getName() + "'s HP with " + move.moveName() + "!";
        }
    }

    public static String heal(Item item, Player healer, Player healed){

        float itemHealing = item.itemPower();
        String itemType = item.itemType();
        float playerHP = healed.getHP();
        float playerMaxHP = healed.getMaxHP();
        float playerDefense = healed.getDefense();
        float playerMaxDefense = healed.getMaxDefense();

        if(itemType=="Defense Booster"){
            playerDefense = playerDefense + itemHealing;
            healed.setDefense(playerDefense);
            return healer.getName() + " boosts " + healed.getName() + "'s defense by " + itemHealing + " points with " + item.itemName() + "!";
        }else if (itemType=="Healing") {
            playerHP = playerHP + item.itemPower();
            if (playerHP <= playerMaxHP) {
                healed.setHP(playerHP);
            } else {
                healed.setHP(playerMaxHP);
            }
            return healer.getName() + " heals " + healed.getName() + " by " + itemHealing + " points with " + item.itemName() + "!";
        }else if (itemType=="Elixir") {
            healed.setHP(playerMaxHP);
            if (playerDefense < playerMaxDefense) {
                healed.setDefense(playerMaxDefense);
            }
            return healer.getName() + " returns " + healed.getName() + " to full health and defense with " + item.itemName() + "!";
        } else {
            healed.setHP(playerMaxHP);
            healed.setDefense(playerMaxDefense);
            return healer.getName() + " revives/heals " + healed.getName() + " with " + item.itemName() + "!";
        }
    }

    public static boolean isHit(Player currentCharacter){
        boolean missChance = new Random().nextInt((int)currentCharacter.getSpeed())>30;
        return missChance;
    }

    //Used for simulated battle where user doesn't pick attack
    public static String rando_attack(Player player1, Player player2){
        //prompt user to choose attack
        ArrayList<Move> moves = player1.getMoveList();
        Random rand = new Random();
        int  n = rand.nextInt(moves.size());
        if(isHit(player1)){
            return damage(moves.get(n),player1, player2);
        }else{
            return player1.getName() + "'s attack missed!";
        }
    }

}
