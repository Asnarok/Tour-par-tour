package jeu;


public class Character {
    
    //types
    public static final int HP_CONST = 100;

    private String name;
    private float HP;
    private Type[] types;
    private Type[] weaknesses; //sera rempli des types qui seront sa faiblesse

    private String[] attacksNames;
    private Type[] attacksTypes;

    private int heals = 2; //nombre de potions 

    public Character(String name, float HP, Type[] types, Type[] weaknesses, String[] attacksNames, Type[] attacksTypes) { // constructeur pour des HP différents
        this.name = name; //pas besoin de setter puisqu'il sera initialisé une seule fois
        setHP(HP);
        this.types = types; //"
        this.weaknesses = weaknesses; //"
        this.attacksNames = attacksNames;//"
        this.attacksTypes = attacksTypes;//"
    }

    public Character(String name, Type[] types, String[] attacksNames, Type[] attacksTypes, Type[] weaknesses) { // constructeur pour des HP constants
        this.name = name; //pas besoin de setter puisqu'il sera initialisé une seule fois
        setHP(HP_CONST);
        this.types = types; //"
        this.weaknesses = weaknesses; //"
        this.attacksNames = attacksNames;//"
        this.attacksTypes = attacksTypes;//"
    }

    /**
     * 
     * @return the name of the character
     */
    public String getName() {
        return name;
    }

    /**
     * @return the health points of the character
     */
    public float getHP() {
        return HP;
    }

    /**
     * 
     * @param HP the new health points of the character
     */
    public void setHP(float HP) {
        this.HP = HP;
    }

    /**
     * @param loss the health points to subtract 
     */
    public void loseHP(float loss) {
        HP-=loss;
        if(HP < 0) HP = 0;
    }

    /**
     * 
     * @return a boolean indicating whether the character is alive or not
     */
    public boolean isAlive() {
        return HP > 0;
    }

    /**
     * @return the type of the character
     */
    public Type[] getTypes() {
        return types;
    }

    public Type[] getWeaknesses() {
        return weaknesses;
    }

    public boolean isWeakness(Type[] types) {
        int i = 0;
        
        while(weaknesses[i] != types[i] && i < weaknesses.length)i++;
        
        return i < weaknesses.length;
    }

    public int takeDamage(Type attackType) {

        //stuff to do

        return -1;
    }

    public void heal() {
        //stuff to do
    }

    public void displayHP() {
        System.out.println("Votre "+name+" a encore "+HP+" / "+HP_CONST+" PV");
    }

    public void displayAttacks() {
        System.out.println("Attaques disponibles: ");
    }

    
}
