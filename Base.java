
public class Base{

  public class Player{
    private boolean isDead = false;
    private String name;
    private String type;
    private float hp;
    private float speed;
    private float dodge;
    private float attack;
    private float defense;
    private Move[] moves;

    public Player(String name, String type, float hp, float speed, float dodge, float attack,
                  float defense, Move[] moves){
      this.name = name;
      this.type = type;
      this.hp = hp;
      this.speed = speed;
      this.dodge = dodge;
      this.attack = attack;
      this.defense = defense;
      this.moves = moves;
    }

    public String getName(){return this.name;}
    public float getHP(){return this.hp;}
    public float getSpeed(){return this.speed;}
    public float getDodge(){return this.dodge;}
    public float getAttack(){return this.attack;}
    public float getDefense(){return this.defense;}

    public boolean hasLost(){
      if(this.getHP() <= 0){
        return true;
      }else{
        return false;
      }
    }
    /*Implement these later
    public int chooseMove();
    public void attack(Player other, int nextMove);
    */
  }


  public class Move{
    protected String name;
    protected String type;
    protected int damage;

    public Move(String name, String type, int power){
      this.name = name;
      this.type = type;
      this.damage = power;
    }
  }
}
