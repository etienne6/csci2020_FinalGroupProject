package Model;

import java.util.ArrayList;
import Model.Base.*;

public class Battle_Simulation {
    public static void main(String args[]){
        Heroes hero = new Heroes();
        ArrayList < Player > heroesArrayList = new ArrayList< Player >();
        heroesArrayList = hero.heroList();
        System.out.println(heroesArrayList.get(0).getName());
        System.out.println(heroesArrayList.get(1).getName());
        System.out.println(heroesArrayList.get(2).getName());
    }
}
