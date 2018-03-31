package Model;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Base.*;
import sun.management.counter.perf.PerfLongArrayCounter;

public class Battle_Simulation {
    private static ArrayList < Player > heroesArrayList = new ArrayList< Player >();
    private static ArrayList< Player > bossArrayList = new ArrayList< Player >();

    public static void main(String args[]){
        Heroes hero = new Heroes();
        Bosses boss = new Bosses();

        heroesArrayList = hero.heroList();
        bossArrayList = boss.bossList();
        Player userPlayer = chooseHero();
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
    public void Attack(Player player1, Player Player2){
        player1.getAttack();
    }

    public void Battle(Player player1, Player player2){
        float HP1 = player1.getHP();
        float HP2 = player2.getHP();
        while(HP1 > 0 || HP2 > 0){
            
        }
    }
}
