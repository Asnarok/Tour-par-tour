import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public static final Character vinci = new Character("L. de Vinci", new Type[]{Type.MATH,Type.GEOMETRIC, Type.MEDICAL, Type.MATTER}, 
                                                        new Type[]{Type.MEDICAL, Type.GRAVITATION},
                                                        new String[]{" ", " "},
                                                        new Type[]{Type.MATH, Type.GRAVITATION});

    public static final Character bohr = new Character("N. Bohr", new Type[]{Type.MATTER}, 
                                                        new Type[]{Type.QUANTIC, Type.MATTER},
                                                        new String[]{"Charge photonique", " "},
                                                        new Type[]{Type.RADIO, Type.ELECTRIC});

    public static final Character turing = new Character("A. Turing", new Type[]{Type.INFORMATIC}, 
                                                        new Type[]{Type.INFORMATIC, Type.MATH},
                                                        new String[]{"Cyber attaque", " "},
                                                        new Type[]{Type.COSMOS, Type.MEDICAL});

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
                                                    
    public static List<Character> characters;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        
        chooseCharacter(sc);

    }

    public static void chooseCharacter(Scanner sc) {

        /*
         * Pour choisir son personnage, le joueur écrira le nom de son choix, et le programme reconnaîtra le personnage
         * correspondant
         */

        characters = new ArrayList<Character>(); //on utilise une liste pour itérer
        
        characters.add(newton);
        characters.add(pythagore);
        characters.add(tesla);
        characters.add(einstein);
        characters.add(curie);
        characters.add(vinci);
        characters.add(bohr);
        characters.add(turing);
        characters.add(hawking);
        characters.add(schrodinger);
        characters.add(pasteur);

        System.out.println("Liste des personnages: ");

        for(Character c : characters)c.displayCharacter();


        
        System.out.println("Joueur 1, veuillez sélectionner votre personnage");
        String input;
        while(player1 == null) { //tant que le personnage du joueur 1 n'a pas été défini
            while((input = sc.nextLine()).length() < 3); //en dessous de 3 caractères, le personnage reconnu par la machine a des chances d'être confondu
            input = input.toLowerCase(); //ne pas prendre en compte les majuscules

            for(Character c : characters) {
                if(c.getName().toLowerCase().contains(input))player1 = c; //si le nom d'un personnage contient ce que le joueur a écrit, alors c'est le bon
            }
            if(player1 == null)System.out.println("Veuillez donner un nom de personnage valide");
            else System.out.println("Vous avez choisi "+ player1.getName());
        }

        System.out.println("Joueur 2, veuillez sélectionner votre personnage (différent du joueur 1)");
        while(player2 == null || player1 == player2) { //tant que le personnage du joueur 2 n'a pas été défini ou qu'il a choisi le même que le premier
            while((input = sc.nextLine()).length() < 3); //en dessous de 3 caractères, le personnage reconnu par la machine a des chances d'être confondu
            input = input.toLowerCase(); //ne pas prendre en compte les majuscules

            for(Character c : characters) {
                if(c.getName().toLowerCase().contains(input))player2 = c; //si le nom d'un personnage contient ce que le joueur a écrit, alors c'est le bon
            }
            if(player1 == null || player2 == player1)System.out.println("Veuillez donner un nom de personnage valide");
            else System.out.println("Vous avez choisi "+ player2.getName());
        }

    }


    
}
