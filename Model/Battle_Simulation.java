package Model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Model.Base.*;
import sun.management.counter.perf.PerfLongArrayCounter;

public class Battle_Simulation {
    private static ArrayList < Player > heroesArrayList = new ArrayList< Player >();
    private static ArrayList< Player > bossArrayList = new ArrayList< Player >();
    private static Player userPlayer;
    private static Player currentBoss = null;

    public static void main(String args[]){
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

        userPlayer = chooseHero();
        currentBoss = getCurrentBoss(currentBoss);
        System.out.println(chooseFirst(userPlayer, currentBoss));

        //Need to implement specific battle game play below...


    }

    /*
    Quick method to pick characters to start the game. Probably going to be buttons to select characters,
    but using terminal input for now where you just type in character name.
    */
    public static Player chooseHero(){
        System.out.println("Choose a character from the list:\n" + "1) Krogg\n" + "2) Linda\n" + "3) Glen\n");
        Scanner scanner = new Scanner(System.in);
        String userHeroPick = scanner.next();

        Player heroPick = new Player("Not initialized", "None", 0f, 0f, 0f, 0f, 0f);

        switch(userHeroPick){
            case "Krogg": heroPick = heroesArrayList.get(0);
                break;
            case "Linda": heroPick = heroesArrayList.get(1);
                break;
            case "Glen": heroPick = heroesArrayList.get(2);
        }

        return heroPick;
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
}

