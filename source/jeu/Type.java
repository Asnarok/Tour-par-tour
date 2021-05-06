

public enum Type {
    ELECTRIC, COSMOS, INFORMATIC, 
    GEOMETRIC, MATTER, RADIO, 
    MATH, GRAVITATION, 
    MEDICAL, QUANTIC;

    public String toString() {
        if(this == ELECTRIC)return "Electrique";
        else if(this == COSMOS)return "Cosmos";
        else if(this == INFORMATIC)return "Informatique";
        else if(this == GEOMETRIC)return "Géométrique";
        else if(this == MATTER)return "Matière";
        else if(this == RADIO)return "Radio";
        else if(this == MATH)return "Maths";
        else if(this == GRAVITATION)return "Gravité";
        else if(this == MEDICAL)return "Médecine";
        else return "Mécanique quantique";
    }
}