package sample.model;
import java.util.ArrayList;

public class Base {

    public static class Player {
        private String name;
        private String type;
        //Attack decreases health
        private float hp;
        //Probability based on speed
        private float speed;
        //Attack hit with probability of dodge
        private float dodge;
        //Calculate full damage based on defense
        private float defense;
        private ArrayList<Move> moveList = new ArrayList<Move>();

        public Player(String name, String type, float hp, float speed, float dodge, float defense)  {
            this.name = name;
            this.type = type;
            this.hp = hp;
            this.speed = speed;
            this.dodge = dodge;
            this.defense = defense;
        }

        public void setMoves(Move move){
            this.moveList.add(move);
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

        public float getSpeed() {
            return this.speed;
        }

        public float getDodge() {
            return this.dodge;
        }

        public float getDefense() {
            return this.defense;
        }

        public ArrayList<Move> getMoveList() { return moveList; }

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
}
