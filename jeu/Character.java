package jeu;
public class Character {
    
    //types
    public static final int ELECTRIC = 0, COSMOS = 1, INFORMATIC = 2, GEOMETRIC = 3, MATTER = 4, RADIO = 5;
    public static final int HP_CONST = 100;

    public static enum Type {
        ELECTRIC, COSMOS, INFORMATIC, GEOMETRIC, MATTER, RADIO;
    }

    private String name;
    private float HP;
    private Type[] types;
    private Type[] weaknesses; //sera rempli des int des types qui seront sa faiblesse

    public Character(String name, float HP, Type[] types, Type[] weaknesses) { // constructeur pour des HP différents
        this.name = name; //pas besoin de setter puisqu'il sera initialisé une seule fois
        setHP(HP);
        this.types = types; //pareil
        this.weaknesses = weaknesses; //idem
    }

    public Character(String name, Type[] types, Type[] weaknesses) { // constructeur pour des HP constants
        this.name = name; //pas besoin de setter puisqu'il sera initialisé une seule fois
        setHP(HP_CONST);
        this.types = types; //pareil
        this.weaknesses = weaknesses; //idem
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

    

    

}
