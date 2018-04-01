package sample.model;


import sample.model.Base.*;


public class Krogg extends Player{

    public Krogg(){
        super("Krogg", "Knight", 1000.0f, 1000.0f,80.0f, 50.0f,
                85.0f,85.0f);
        this.setMoves(new Move("It's Lit!", "Fire", 500));
        this.setMoves(new Move("Say It, Don't Spray It","Water", 3500));
        this.setMoves(new Move("Blow a 3-1 Lead","Wind", 200));

        this.setItems(new Item("Graduation", "Healing", 1000, 1));
        this.setItems(new Item("Doctor's Note","Defense Booster", 500, 2));
        this.setItems(new Item("Lowest Mark Dropped","Healing", 300, 3));
    }

}


