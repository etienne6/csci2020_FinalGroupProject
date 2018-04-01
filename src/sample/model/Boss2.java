package sample.model;


public class Boss2 extends Base.Player {
    public Boss2(){
        super("Draconis", "Boss", 2000.0f, 80.0f, 30.0f, 150.0f);
        this.setMoves(new Base.Move("Attack1", "Type1", 200));
        this.setMoves(new Base.Move("Attack2", "Type2", 250));
        this.setMoves(new Base.Move("Attack3", "Type3", 400));
    }
}



