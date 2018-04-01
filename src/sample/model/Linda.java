package sample.model;

import sample.model.Base.*;

public class Linda extends Player {

    public Linda(){
        super("Linda", "Healer", 800.0f, 600.0f,90.0f,
                50.0f, 60.0f,60.0f);
        this.setMoves(new Move("Valkyrie", "Magic", 200));
        this.setMoves(new Move("Fallen Angel","Magic", 150));
        this.setMoves(new Move("Demon Call","Summon", 100));

        this.setItems(new Item("Heroes Never Die", "Revival/Full Healing", 9999, 1));
        this.setItems(new Item("Elixir","Elixir", 9999, 2));
        this.setItems(new Item("Healer's Touch","Healing", 1000, 3));
    }

}
