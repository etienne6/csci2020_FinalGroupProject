package sample.model;


import sample.model.Base.*;


public class Krogg extends Player{

    public Krogg(){
        super("Krogg", "Knight", 800.0f, 80.0f, 50.0f,
                85.0f);
        this.setMoves(new Move("It's Lit!", "Fire", 300));
        this.setMoves(new Move("Say It, Don't Spray It","Water", 200));
        this.setMoves(new Move("Blow a 3-1 Lead","Wind", 100));
    }

}


