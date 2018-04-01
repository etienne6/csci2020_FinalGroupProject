package sample.model;
import java.util.ArrayList;

public class Base {

    public static class Player {
        private String name;
        private String type;
        //Attack decreases health
        private float hp;
        private float maxHp;
        //Probability based on speed
        private float speed;
        //Attack hit with probability of dodge
        private float dodge;
        //Calculate full damage based on defense
        private float defense;
        private float maxDefense;
        private ArrayList<Move> moveList = new ArrayList<>();
        private ArrayList<Item> itemList = new ArrayList<>();

        public Player(String name, String type, float hp, float maxHp, float speed, float dodge, float defense, float maxDefense)  {
            this.name = name;
            this.type = type;
            this.hp = hp;
            this.maxHp = maxHp;
            this.speed = speed;
            this.dodge = dodge;
            this.defense = defense;
            this.maxDefense = maxDefense;
        }

        public void setMoves(Move move){
            this.moveList.add(move);
        }
        public void setItems(Item item){
            this.itemList.add(item);
        }

        public String getName() {
            return this.name;
        }

        public String getType() {
            return this.type;
        }

        public float getHP() {
            return this.hp;
        }

        public float getMaxHP() {
            return this.maxHp;
        }

        public float getSpeed() {
            return this.speed;
        }

        public float getDodge() {
            return this.dodge;
        }

        public float getDefense() {
            return this.defense;
        }

        public float getMaxDefense() {
            return this.maxDefense;
        }

        public ArrayList<Move> getMoveList() { return moveList; }
        public ArrayList<Item> getItemList() { return itemList; }

        public boolean hasLost() {
            if (this.getHP() <= 0) {
                return true;
            } else {
                return false;
            }
        }

        public void setHP(float hp){
            if(hp < 0){
                this.hp = 0;
            }else {
                this.hp = hp;
            }
        }

        public void setDefense(float defense){
            if(defense < 0){
                this.defense = 0;
            }else {
                this.defense = defense;
            }
        }
    }

    public static class Move {
        protected String name;
        protected String type;
        protected int damage;

        public Move(String name, String type, int power) {
            this.name = name;
            this.type = type;
            this.damage = power;
        }
        public String moveName(){
            return this.name;
        }
        public String moveType(){
            return this.type;
        }
        public float movePower(){
            return this.damage;
        }
    }

    public static class Item {
        protected String name;
        protected String type;
        protected float power;
        protected int quantity;

        public Item(String name, String type, float power, int quantity) {
            this.name = name;
            this.type = type;
            this.power = power;
            this.quantity = quantity;
        }
        public String itemName(){
            return this.name;
        }
        public String itemType(){
            return this.type;
        }
        public float itemPower(){ return this.power; }
        public int itemQuantity() {return this.quantity;}
    }
}


