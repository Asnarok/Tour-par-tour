import java.util.List;
import java.util.Scanner;

public class Game {

    public static Character player1, player2;

    
    public static Character playingChar; //joueur en train de jouer
    public static Character idleChar; //joueur inactif

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        chooseCharacter(sc);

        playingChar = player2; //comme on inverse au début de chaque round, le joueur 1 commencera en 1er
        idleChar = player1;
        
        while(player1.isAlive() && player2.isAlive()) { //le jeu continue
            //chaque tour l'autre joueur joue
            if(playingChar == player2){
                playingChar = player1; 
                idleChar = player2;
            }
            else {
                playingChar = player2;
                idleChar = player1;
            } 

            int attack = chooseAttack(sc);

            if(attack < 2){ //dégâts
                Type attackType = playingChar.getTypes()[attack];
                idleChar.takeDamage(attackType);
                idleChar.displayHP();
                
            }else { //potion
                playingChar.heal();
            }
            
        }
       
    }

    public static int chooseAttack(Scanner sc) {
        
        println("Choisissez une attaque");
        displayAttacks(playingChar);
        int i = 0;
        while(i < 1 || i > 3) {
            i = sc.nextInt();
            if(i < 1 || i > 3) println("Attaque invalide.");
        }
        i--;
        println(playingChar.getName()+" attaque "+ playingChar.getAttackNames()[i]+" !");
        return i;
    }

    public static void displayAttacks(Character c) {
        System.out.println("Attaques disponibles: \n"  + 
        "1) " + c.getAttacks()[0] + 
        "\n2) " + c.getAttacks()[1] +
        "\n3) Potions de soins (" + c.getHeals() + ")");
        System.out.println();
    }

    public static void displayCharacter(Character c) {
        System.out.println(c.getName());
        displayAttacks(c);
        System.out.println();
    }

    public void displayHP(Character c) {
        System.out.println("Votre " + c.getName() + " a encore " + c.getHP() + " / "+ Character.HP_CONST + " PV et il lui reste " + c.getHeals() + "potions de soins");
    }

    public static void println(String s) {
        if(playingChar == player1)System.out.println("(Joueur 1) "+s);
        else System.out.println("(Joueur 2) "+s);
    }



    public static void chooseCharacter(Scanner sc) {

        /*
         * Pour choisir son personnage, le joueur écrira le nom de son choix, et le programme reconnaîtra le personnage
         * correspondant
         */

        List<Character> characters = IO.loadCharacters();
        
        System.out.println("Liste des personnages: ");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(Character c : characters){
            c.displayCharacter();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        
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
