package Model;

import Model.Base.*;

public class Linda extends Player {

    public Linda(){
        super("Linda", "Healer", 600.0f, 40.0f,
                50.0f, 60.0f, 30.0f);
        this.setMoves(new Move("Attack1", "Type2", 100));
        this.setMoves(new Move("Attack2","type2", 100));
        this.setMoves(new Move("Attack3","type3", 100));
    }

}
