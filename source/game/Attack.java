package game;

public class Attack {

    private String attackName;
    private int attackType;

    public Attack(int attackType, String attackName) {
        setAttackName(attackName);
        setAttackType(attackType);    
    }

    public void setAttackName(String name) {
        attackName = name;
    }

    public String getAttackName() {
        return attackName;
    }
    
    public void setAttackType(int type) {
        attackType = type;
    }

    public int getAttackType() {
        return attackType;
    }

    public String toString(){
        return attackName + " de type " + Types.types.get(attackType); 
    }
}
