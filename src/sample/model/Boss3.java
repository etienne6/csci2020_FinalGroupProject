package sample.model;

public class Boss3 extends Base.Player {
    public Boss3(){
        super("Dragon", "Boss", 3000.0f, 3000.0f, 85.0f, 30.0f, 200.0f, 200.0f);
        this.setMoves(new Base.Move("Earthquake", "Earth", 300));
        this.setMoves(new Base.Move("Hurricane", "Wind", 350));
        this.setMoves(new Base.Move("Dragonfire", "Fire", 500));
    }
}
