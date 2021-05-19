public class Display {

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
}