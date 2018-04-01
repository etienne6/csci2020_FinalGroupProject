package sample.model;


public class Boss2 extends Base.Player {
    public Boss2(){
        super("Draconis", "Boss", 2000.0f, 2000.0f, 80.0f, 30.0f, 150.0f, 150.0f);
        this.setMoves(new Base.Move("Nunchaku", "Close-Range Weapon", 200));
        this.setMoves(new Base.Move("Shuriken", "Distance Weapon", 250));
        this.setMoves(new Base.Move("Katana Slash", "Close-Range Weapon", 400));
    }
}



