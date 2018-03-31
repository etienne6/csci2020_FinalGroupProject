package Model;

public class Boss1 extends Base.Player {
    public Boss1(){
        super("Boss1", "Boss", 2500.0f, 80.0f, 90.0f, 100.0f, 300.0f);
        this.setMoves(new Base.Move("Attack1", "Type1", 150));
        this.setMoves(new Base.Move("Attack2", "Type2", 200));
        this.setMoves(new Base.Move("Attack3", "Type3", 300));
    }
}
