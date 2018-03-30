import java.util.ArrayList;

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
                  float defense){
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
    public String getType(){return this.type;}
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

    //public int chooseMove();
    //public void attack(int nextMove);
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


  public class Characters{
    private ArrayList<Player> characterList = new ArrayList();
    private ArrayList<Player> bossList = new ArrayList();

    public Characters(){
      Player krogg = new Player("Krogg", "Knight", 800.0f, 80.0f, 50.0f, 85.0f, 50.0f);
      Player linda = new Player("Linda", "Healer", 600.0f, 40.0f, 50.0f, 60.0f, 30.0f);
      Player glen = new Player("Glen", "Tank", 1000.0f, 30.0f, 50.0f, 60.0f, 30.0f);

      Player boss1 = new Player("Boss 1", "Boss", 2500.0f, 80.0f, 90.0f, 100.0f, 300.0f);
      Player boss2 = new Player("Boss 2", "Boss", 5000.0f, 90.0f, 30.0f, 150.0f, 200.0f);
      Player boss3 = new Player("Boss 3", "Boss", 10000.0f, 100.0f, 30.0f, 200.0f, 250.0f);

      characterList.add(krogg);
      characterList.add(linda);
      characterList.add(glen);

      bossList.add(boss1);
      bossList.add(boss2);
      bossList.add(boss3);
    }

    public ArrayList<Player> getCharacterList(){return this.characterList;}
    public ArrayList<Player> getBossList(){return this.bossList;}


  }
}