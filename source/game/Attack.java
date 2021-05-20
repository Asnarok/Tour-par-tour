package game;

public class Attack {


    private String attackName;
    private Type attackType;

    public Attack(Type attackType, String attackName) {
        setAttackName(attackName);
        setAttackType(attackType);    
    }

    public void setAttackName(String name) {
        attackName = name;
    }

    public String getAttackName() {
        return attackName;
    }
    
    public void setAttackType(Type type) {
        attackType = type;
    }

    public Type getAttackType() {
        return attackType;
    }

    public String toString(){
        return attackName + " de type " + attackType; 
    }
}
