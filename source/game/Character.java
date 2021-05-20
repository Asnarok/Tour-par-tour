package game;

public class Character {
    
    //constantes
    public static final int HP_CONST = 100; //PV de chaque perso au départ 
    public static final int HEAL_HP = 20; //PV gagné lors du soin 

    // attributs du perso 
    private String name;
    private float HP;
    private int[] types; //sera rempli du/des type.s qui sera.ont sa.ses résistances 
    private int[] weaknesses; //sera rempli des types qui seront sa faiblesse
    private Attack[] attacks; //sera remplis d'objet de type Attack 
    private int heals = 2; //nombre de potions de soins 

    public Character(String name, int[] types,  Attack[] attacks, int[] weaknesses) { // constructeur pour des HP constants
        this.name = name; //pas besoin de setter puisqu'il sera initialisé une seule fois
        this.HP = HP_CONST;
        this.types = types; //"
        this.weaknesses = weaknesses; //"
        this.attacks = attacks;//"
    }
  
    //getters et setters 
    public String getName() {
        return name;
    }

    public float getHP() {
        return HP;
    }

    public void setHP(float HP) {
        this.HP = HP;
    }

    public int[] getTypes() {
        return types;
    }

    public int[] getWeaknesses() {
        return weaknesses;
    }

    public Attack[] getAttacks(){
        return attacks; 
    }
    
    public int getHeals(){
        return heals;
    }

    //
    public boolean isAlive() {
        return HP > 0;
    }

    public boolean isWeakness(int attackType) {
        int i = 0;
        
        while(i < weaknesses.length && weaknesses[i] != attackType)i++;
        
        return i < weaknesses.length;
    }

    public boolean isResistance(int attackType) {
        int i = 0;
        
        while(i < types.length && types[i] != attackType)i++;
        return i < types.length;
    }

    public void decreaseHeals() { //permettera de supprimer les potions utilisées
        heals--;
    }

}