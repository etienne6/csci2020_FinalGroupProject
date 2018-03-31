package sample.model;

import java.util.ArrayList;

import sample.model.Base.*;

public class Battle_Simulation {
    private static ArrayList < Player > heroesArrayList = new ArrayList< Player >();
    private static ArrayList< Player > bossArrayList = new ArrayList< Player >();

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
        //Need to implement specific battle game play below...


    }

    /*
    Quick method to pick characters to start the game. Probably going to be buttons to select characters,
    but using terminal input for now where you just type in character name.
    */
    public static Player chooseHero(String userHeroPick){

        Player heroPick = new Player("Not initialized", "None", 0f, 0f, 0f, 0f, 0f);

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
}
