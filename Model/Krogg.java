package Model;

import Model.Base.*;

public class Krogg extends Player{

    public Krogg(){
        super("Krogg", "Knight", 800.0f, 80.0f, 50.0f,
                85.0f);
        this.setMoves(new Move("Attack1", "Type2", 100));
        this.setMoves(new Move("Attack2","type2", 100));
        this.setMoves(new Move("Attack3","type3", 100));
    }

}


