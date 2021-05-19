public class Display {

    public static void displayAttacks(Character c) {
        System.out.println("Attaques disponibles: \n"  + 
        "1) " + c.getAttackNames()[0] + " de type " + attacks[0].getAttackType() + 
        "\n2) " + attacks[1].getAttackName() + " de type " + attacks[1].getAttackType() +
        "\n3) Potions de soins (" + heals + ")");
    }

}