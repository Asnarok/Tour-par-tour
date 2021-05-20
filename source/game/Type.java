package game;

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

    public static Type parseType(String s) {
        if(s.equals("ELECTRIC"))return ELECTRIC;
        else if(s.equals("COSMOS"))return COSMOS;
        else if(s.equals("INFORMATIC"))return INFORMATIC;
        else if(s.equals("GEOMETRIC"))return GEOMETRIC;
        else if(s.equals("MATTER"))return MATTER;
        else if(s.equals("RADIO"))return RADIO;
        else if(s.equals("MATH"))return MATH;
        else if(s.equals("GRAVITATION"))return GRAVITATION;
        else if(s.equals("MEDICAL"))return MEDICAL;
        else if(s.equals("QUANTIC"))return QUANTIC;
        else return null;
    }
}