package sample.model;


import sample.model.Base.*;


public class Glen extends Player{

    public Glen(){
        super("Glen", "Tank", 1000.0f, 30.0f,
                50.0f, 60.0f);
        this.setMoves(new Move("Attack1", "Type2", 100));
        this.setMoves(new Move("Attack2","type2", 100));
        this.setMoves(new Move("Attack3","type3", 100));
    }

}