


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

    public Character(String name, Type[] types,  Type[] attacksTypes, String[] attacksNames,Type[] weaknesses) { // constructeur pour des HP constants
        this.name = name; //pas besoin de setter puisqu'il sera initialisé une seule fois
        this.HP = HP_CONST;
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

    /**
     * 
     */
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


    public float takeDamage(Type attackType) {

        float damage;
        if(isWeakness(attackType)){
            damage = randomFloat(20, 30);
        }
        else if(isResistance(attackType)){
            damage = randomFloat(1, 10);
        }
        else damage = randomFloat(10, 20);

        if(HP-damage > 0)HP-=damage;
        else HP = 0;

        return damage;
    }

    public void heal() {
        if (HP < HP_CONST - 20 ){ 
            HP += 20; 
        } else { 
            HP = HP_CONST; 
        }
    }

    public void displayHP() {
        System.out.println("Votre " + name + " a encore " + HP + " / "+ HP_CONST + " PV");
    }

    public void displayAttacks() {
        System.out.println("Attaques disponibles: \n"  + 
        "- " + attacksNames[0] + " de type " + attacksTypes[0] + 
        "\n- " + attacksNames[1] + " de type " + attacksTypes[1]);
    }

    public static float randomFloat(int min, int max) {
        return (int)(Math.random() * ((max-min+1)*2))/2f+min;
    }
    
}
