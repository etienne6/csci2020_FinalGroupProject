package Model;

import java.util.ArrayList;
import Model.Base.*;

public class Bosses{
    private ArrayList <Player> bossList = new ArrayList();

    //instantiate a list of bosses
    public Bosses(){
        Boss1 boss1 = new Boss1();
        bossList.add(boss1);

        Boss2 boss2 = new Boss2();
        bossList.add(boss2);

        Boss3 boss3 = new Boss3();
        bossList.add(boss3);
    }
    public ArrayList < Player > bossList() {
        return this.bossList;
    }
}