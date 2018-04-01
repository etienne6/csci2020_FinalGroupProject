package sample.model;


import sample.model.Base.*;


public class Glen extends Player{

    public Glen(){
        super("Glen", "Tank", 1500.0f, 1000.0f,30.0f,
                50.0f, 500.0f,500.0f);
        this.setMoves(new Move("SMASH", "Hand", 300));
        this.setMoves(new Move("Shield Bash","Close-Range Weapon", 200));
        this.setMoves(new Move("Awkward Stare","Long-Range Weapon", 100));
    }

}