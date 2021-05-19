


public class Character {
    
    //constantes
    public static final int HP_CONST = 100;

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


    public float takeDamage(Type attackType) {

        float damage;
        if(isWeakness(attackType)){
            System.out.println("C'est super efficace !");
            damage = randomFloat(20, 30);
        }
        else if(isResistance(attackType)){
            System.out.println("Ce n'est pas très efficace...");
            damage = randomFloat(1, 10);
        }
        else damage = randomFloat(10, 20);

        if(HP-damage > 0)HP-=damage;
        else HP = 0;

        System.out.println("Le "+name+" ennemi a subi "+damage+" points de dégâts.");
        return damage;
    }

    public void decreaseHeals() {
        heals--;
    }

    public void heal() {
        if (heals !=0){
           if (HP < HP_CONST - 20 ){ 
            HP += 20; 
        } else { 
            HP = HP_CONST; 
        }
        System.out.print("Votre " + name + " s'est soigné. ");
        displayHP();
        heals --;
        } else {
            System.out.println("Votre " + name + " n'a plus de potions de soins !");
        }
        
    }

    public static float randomFloat(int min, int max) {
        return (int)(Math.random() * ((max-min+1)*2))/2f+min;
    }

}

