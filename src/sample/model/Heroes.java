package sample.model;

//Public class heroes just returns a list of the heroes in the story
import java.util.ArrayList;
import sample.model.Base.*;


public class Heroes {
    private ArrayList < Player > heroList = new ArrayList();
    //instantiate a list of heroes
    public Heroes(){
        Krogg krogg = new Krogg();
        heroList.add(krogg);

        Linda linda = new Linda();
        heroList.add(linda);

        Glen glen = new Glen();
        heroList.add(glen);
    }
    public ArrayList < Player > heroList() {
        return this.heroList;
    }
}