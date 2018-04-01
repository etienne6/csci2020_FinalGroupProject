package sample.model;


import sample.model.Base.*;


public class Glen extends Player{

    public Glen(){
        super("Glen", "Tank", 1500.0f, 1000.0f,75.0f,
                50.0f, 500.0f,500.0f);
        this.setMoves(new Move("GLEN SMASH", "Hand", 300));
        this.setMoves(new Move("Shield Bash","Close-Range Weapon", 200));
        this.setMoves(new Move("Awkward Stare","Long-Range Weapon", 100));

        this.setItems(new Item("Phalanx", "Defense Booster", 2000, 1));
        this.setItems(new Item("Tank Drank","Defense Booster", 1000, 2));
        this.setItems(new Item("Potion","Healing", 150, 3));
    }
}