package Model;

import java.util.ArrayList;
import Model.Base.*;
import sun.management.counter.perf.PerfLongArrayCounter;

public class Battle_Simulation {
    public static void main(String args[]){
        Heroes hero = new Heroes();
        Bosses boss = new Bosses();
        ArrayList < Player > heroesArrayList = new ArrayList< Player >();
        ArrayList< Player > bossArrayList = new ArrayList< Player >();
        heroesArrayList = hero.heroList();
        bossArrayList = boss.bossList();
        System.out.println(heroesArrayList.get(0).getName());
        System.out.println(heroesArrayList.get(1).getName());
        System.out.println(heroesArrayList.get(2).getName());
        System.out.println(bossArrayList.get(0).getName());
        System.out.println(bossArrayList.get(1).getName());
        System.out.println(bossArrayList.get(2).getName());
    }
}
