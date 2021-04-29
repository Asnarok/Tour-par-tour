package jeu;
public class Perso {
    
    //types
    public static final int ELECTRIC = 0, COSMOS = 1, INFORMATIC = 2, GEOMETRIC = 3, MATTER = 4, RADIO = 5;

    private String name;
    private float HP;
    private int[] type;
    private int[] weaknesses; //sera rempli des int des types qui seront sa faiblesse

    public Perso(String nom, float PV, int type, int[] faiblesses) {

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
     * @return the type of the character
     */
    public int getType() {
        return type;
    }


    public int[] getWeaknesses() {
        return weaknesses;
    }

    public boolean isWeakness(int type) {
        int i = 0;
        
        while(weaknesses[i] != type)i++;
        
        return i < weaknesses.length;
    }

    

    

}
