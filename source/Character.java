


public class Character {
    
    //constantes
    public static final int HP_CONST = 100;
    public static final int HEAL_HP = 20;

    private String name;
    private float HP;
    private Type[] types;
    private Type[] weaknesses; //sera rempli des types qui seront sa faiblesse

    private Attack[] attacks;

    private int heals = 2; //nombre de potions 

    public Character(String name, Type[] types,  Attack[] attacks, Type[] weaknesses) { // constructeur pour des HP constants
        this.name = name; //pas besoin de setter puisqu'il sera initialisé une seule fois
        this.HP = HP_CONST;
        this.types = types; //"
        this.weaknesses = weaknesses; //"
        this.attacks = attacks;//"
    
    }

 
    public String getName() {
        return name;
    }

    public float getHP() {
        return HP;
    }

    public void setHP(float HP) {
        this.HP = HP;
    }

    public boolean isAlive() {
        return HP > 0;
    }

    public Type[] getTypes() {
        return types;
    }

    public Type[] getWeaknesses() {
        return weaknesses;
    }

    public Attack[] getAttacks(){
        return attacks; 
    }
    
    public int getHeals(){
        return heals;
    }

    public boolean isWeakness(Type attackType) {
        int i = 0;
        
        while(weaknesses[i] != attackType && i < weaknesses.length)i++;
        
        return i < weaknesses.length;
    }

    public boolean isResistance(Type attackType) {
        int i = 0;
        
        while(weaknesses[i] == attackType && i < weaknesses.length)i++;
        
        return i < weaknesses.length;
    }

    public void decreaseHeals() {
        heals--;
    }

}