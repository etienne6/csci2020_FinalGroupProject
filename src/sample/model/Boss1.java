package sample.model;


public class Boss1 extends Base.Player {
    public Boss1(){
        super("Professor X", "Boss", 1000.0f, 1000.0f, 70.0f, 90.0f, 100.0f, 100.0f);
        this.setMoves(new Base.Move("Bad Comp Sci Pun", "Humor", 150));
        this.setMoves(new Base.Move("Missing Semi-Colon", "Syntax Error", 200));
        this.setMoves(new Base.Move("Pop Quiz", "Shocking", 300));
    }
}
