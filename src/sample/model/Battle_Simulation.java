package sample.model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import sample.model.Base.*;

public class Battle_Simulation {
    private static ArrayList < Player > heroesArrayList = new ArrayList< Player >();
    private static ArrayList< Player > bossArrayList = new ArrayList< Player >();
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
        userPlayer = chooseHero("Krogg");
        currentBoss = getCurrentBoss(currentBoss);
        //Battle implemented
        Battle(userPlayer, currentBoss);


    }

    /*
    Quick method to pick characters to start the game. Probably going to be buttons to select characters,
    but using terminal input for now where you just type in character name.
    */
    public static Player chooseHero(String userHeroPick){

        Player heroPick = new Player("Not initialized", "None", 0f, 0f, 0f, 0f);

        switch(userHeroPick){
            case "Krogg": heroPick = heroesArrayList.get(0);
                System.out.println("You picked " + heroesArrayList.get(0));
                break;
            case "Linda": heroPick = heroesArrayList.get(1);
                System.out.println("You picked " + heroesArrayList.get(1));
                break;
            case "Glen": heroPick = heroesArrayList.get(2);
                System.out.println("You picked " + heroesArrayList.get(2));
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
    //returns the damage done by a Move
    public static void Damage(Move move, Player player){
        float playerDefense = player.getDefense();
        float playerHP = player.getHP();

        if(playerDefense > 0){
            playerDefense = playerDefense - move.movePower();
            player.setDefense(playerDefense);
        }else{
            playerHP = playerHP - move.movePower();
            player.setHP(playerHP);
        }
    }

    //Attack function
    public static void Attack(Player player1, Player player2){
        //prompt user to choose attack
        ArrayList<Move> moves = player1.getMoveList();

        System.out.println("Choose Attack: ");
        for(int i = 0; i < moves.size(); i++){
            System.out.println(i+1 + " " + moves.get(i).moveName());
        }

        Scanner scanner = new Scanner(System.in);
        int userMovePick = scanner.nextInt();


        if(userMovePick == 1){
            Damage(moves.get(1), player2);
        }else if(userMovePick == 2){
            Damage(moves.get(2), player2);
        }else if(userMovePick == 3){
            Damage(moves.get(3),player2);
        }else{
            System.out.println("Did not pick a move");
        }
    }

    //Used for simulated battle where user doesn't pick attack
    public static void rando_attack(Player player1, Player player2){
        //prompt user to choose attack
        ArrayList<Move> moves = player1.getMoveList();
        Random rand = new Random();
        int  n = rand.nextInt(moves.size());
        Damage(moves.get(n),player2);
    }

    //Currently using rando_attack but haven't tested the Attack function yet
    public static void Battle(Player player1, Player player2){
        while(player1.getHP() > 0 && player2.getHP() > 0){
            chooseFirst(player1,player2);
            if(chooseFirst(player1,player2) == player1.getName()){
                //player2 attacks player1
                System.out.println(player1.getName() + "s turn");
                rando_attack(player1, player2);
            }else{
                //player2 attacks player1
                System.out.println(player2.getName() + "s turn");
                rando_attack(player2,player1);
            }
        }
        if(player1.getHP()>0){
            System.out.println(player1.getName() + " wins!");
        }else{
            System.out.println(player2.getName() + " wins!");
        }
    }

}

