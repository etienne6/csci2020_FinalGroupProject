package sample.model;

public class Boss3 extends Base.Player {
    public Boss3(){
        super("Boss3", "Boss", 10000.0f, 100.0f, 30.0f, 200.0f, 250.0f);
        this.setMoves(new Base.Move("Attack1", "Type1", 300));
        this.setMoves(new Base.Move("Attack2", "Type2", 350));
        this.setMoves(new Base.Move("Attack3", "Type3", 500));
    }
}
