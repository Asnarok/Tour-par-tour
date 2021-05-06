package jeu;

public class Game {

    public static Character player1, player2;

    //personnages
    public static final Character newton = new Character("I. Newton", new Type[]{Type.GRAVITATION}, 
                                                        new Type[]{Type.MATH, Type.GRAVITATION},
                                                        new String[]{"Développement binomial", "Superpesanteur"},
                                                        new Type[]{Type.QUANTIC, Type.COSMOS});
    public static final Character pythagore = new Character("Pythagore", new Type[]{Type.GEOMETRIC}, 
                                                        new Type[]{Type.GEOMETRIC, Type.MEDICAL},
                                                        new String[]{" ", " "},
                                                        new Type[]{Type.INFORMATIC, Type.ELECTRIC});
    public static final Character tesla = new Character("N. Tesla", new Type[]{Type.ELECTRIC}, 
                                                        new Type[]{Type.ELECTRIC, Type.MEDICAL},
                                                        new String[]{"Décharge HV", "Rayons X"},
                                                        new Type[]{Type.MATH, Type.MATTER});
    public static final Character einstein = new Character("A. Einstein", new Type[]{Type.COSMOS}, 
                                                        new Type[]{Type.RADIO, Type.COSMOS},
                                                        new String[]{"LASER", "Singularité"},
                                                        new Type[]{Type.ELECTRIC, Type.GEOMETRIC});
    public static final Character curie = new Character("M. Curie", new Type[]{Type.RADIO}, 
                                                        new Type[]{Type.RADIO, Type.MATTER},
                                                        new String[]{"Impulsion gamma", " "},
                                                        new Type[]{Type.GEOMETRIC, Type.MEDICAL});
    public static final Character vinci = new Character("L. de Vinci", new Type[]{Type.MATH,}, 
                                                        new Type[]{Type.QUANTIC, Type.COSMOS},
                                                        new String[]{"Développement binomial", "Superpesanteur"},
                                                        new Type[]{Type.MATH, Type.GRAVITATION});

    public static final Character hawking = new Character("S. Hawking", new Type[]{Type.COSMOS},
                                                        new Type[]{Type.COSMOS, Type.INFORMATIC},
                                                        new String[]{"Inflation", "Frappe bionique"},
                                                        new Type[]{Type.MEDICAL, Type.MATTER});
    
    public static final Character schrodinger = new Character("E. Schrödinger", new Type[]{Type.RADIO, Type.MATTER},
                                                            new Type[]{Type.QUANTIC, Type.ELECTRIC},
                                                            new String[]{"Intrication quantique", ""},
                                                            new Type[]{Type.GRAVITATION, Type.RADIO});
    public static final Character pasteur = new Character("L. Pasteur", new Type[]{Type.MEDICAL},
                                                            new Type[]{Type.MEDICAL, Type.MATTER},
                                                            new String[]{"Vaccination", "Get acide"},
                                                            new Type[]{Type.MATH, Type.GRAVITATION});
                                                    


    public static void main (String[] args){
        
    }
    
}
