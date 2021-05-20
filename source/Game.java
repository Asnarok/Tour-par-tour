import java.util.InputMismatchException;
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
            } else {
                playingChar = player2;
                idleChar = player1;
            } 

            int attack = -1;
            while(attack == -1)attack = chooseAttack(sc);

            if(attack < 2){ //dégâts
                Type attackType = playingChar.getAttacks()[attack].getAttackType();
                takeDamage(idleChar, attackType);
                displayHP(idleChar);
            }else { //potion
                heal(playingChar);
            }
        }
    }

    public static void takeDamage(Character c, Type attackType) {

        float damage;
        
        if(c.isWeakness(attackType)){
            System.out.println("C'est super efficace !");
            damage = randomFloat(20, 30);
        }
        else if(c.isResistance(attackType)){
            System.out.println("Ce n'est pas très efficace...");
            damage = randomFloat(1, 10);
        }
        else damage = randomFloat(10, 20);

        if(c.getHP()-damage > 0)c.setHP(c.getHP()-damage); 
        else c.setHP(0);
        System.out.println("Le " + c.getName() + " ennemi a subi "+ damage + " points de dégâts.");
        System.out.println();

    }

    public static boolean heal(Character c){

        if (c.getHP() < Character.HP_CONST - Character.HEAL_HP){
            c.setHP(c.getHP() + Character.HEAL_HP);
        } else if(c.getHP() < Character.HP_CONST){
            c.setHP(Character.HP_CONST);
        }

        println("Votre " + c.getName() + " s'est soigné. Il a maintenant " + c.getHP() + "PV");
        c.decreaseHeals();
        return true;
            
    }
    
    
       
    
    public static int chooseAttack(Scanner sc) {
        
        println("Choisissez une attaque");
        displayAttacks(playingChar);
        int i = 0;
        while(i < 1 || i > 3) {
            try {
                i = sc.nextInt();
            }catch(InputMismatchException e) {
                e.printStackTrace();
            }
            if(i < 1 || i > 3) println("Attaque invalide.");
        }
        i--;
        if(i < 2)println(playingChar.getName()+" attaque "+ playingChar.getAttacks()[i].getAttackName()+" !");
        else {
            if(playingChar.getHeals() == 0) {
                println("Votre " + playingChar.getName()+" n'a plus de potions.");
                return -1; //code d'erreur
            }else if(playingChar.getHP() == Character.HP_CONST) {
                println("Votre " + playingChar.getName() +" n'a pas besoin de se soigner.");
                return -1; //code d'erreur
            }
        }
        return i;
    }

    public static void displayAttacks(Character c) {
        System.out.println("-Attaques disponibles: \n"  + 
        "1) " + c.getAttacks()[0] + 
        "\n2) " + c.getAttacks()[1] +
        "\n3) Potions de soins (" + c.getHeals() + ")");
        System.out.println();
    }

    public static void displayCharacter(Character c) {

        System.out.print(c.getName()+" de type(s) ");
        for(int i = 0; i < c.getTypes().length; i++) {
            System.out.print(c.getTypes()[i]);
            if(i < c.getTypes().length-1)System.out.print(" et ");
        }

        System.out.print("\n-Faiblesses: ");
        for(int i = 0; i < c.getWeaknesses().length; i++) {
            System.out.print(c.getWeaknesses()[i]);
            if(i < c.getWeaknesses().length-1)System.out.print(" et ");
        }

        System.out.println();

        displayAttacks(c);
        System.out.println();
    }

    public static void displayHP(Character c) {
        System.out.print("Votre " + c.getName() + " a encore " + c.getHP() + " / "+ Character.HP_CONST+ " PV [");
        int bar = (int)(Math.round(c.getHP()/10));
        for(int i = 0; i < 10; i++) {
            if(i < bar)System.out.print("■");
            else System.out.print("□");
        }
        System.out.println("] et il lui reste " + c.getHeals() + " potion.s de soins");
        System.out.println();
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
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(Character c : characters){
            displayCharacter(c);
            try {
                Thread.sleep(200);
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
            System.out.println();
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
            System.out.println();
        }

    }

    public static float randomFloat(int min, int max) {
        return (int)(Math.random() * ((max-min+0.5f)*2))/2f+min;
    }

}
