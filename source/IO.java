import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class IO {


    public static List<Character> loadCharacters() {
        List<Character> list = new ArrayList<Character>();
        
        File f = new File("Tour-par-tour/characters.txt");
        try {
            InputStream is = new FileInputStream(f);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            //variables temporaires, servant au traitement

            String line; //ligne lue

            String characterName = "";
            Type[] types = null;
            Type[] weaknesses = null;
            Attack[] attacks = new Attack[2];

            int attackIndex = 0; //index dans le tableau attacks

            boolean finished = false;

            while((line = br.readLine()) != null) { //parcours du fichier
                if(!line.startsWith("-")) { //noms de persos
                    if(finished){
                        list.add(new Character(characterName, types, attacks, weaknesses)); //on ajoute le perso précédent si on l'a complété
                        finished = false;
                    }
                    if(line.length() >=1) {
                        characterName = line.substring(0, line.indexOf(":")); //nom du perso
                        attacks = new Attack[2]; //2 attaques par persos
                        attackIndex = 0; //réinitialisation de l'index d'attaque
                    }
                    
                }else {
                    if(line.contains("attacks:"))continue; //la ligne attacks sert juste de formattage pour remplir le fichier texte à la main, mais ne sert pas au décodage
                    else {
                        if(line.startsWith("--")) { //traitement des attaques
                            String withoutSpaces = line.replaceAll(" ", "");
                            String attackName = line.substring(2, line.indexOf(":")); //suppression des potentiels espaces et découpage
                            String attackType = withoutSpaces.substring(withoutSpaces.indexOf(":")+1); //pareil
                            attacks[attackIndex] = new Attack(Type.parseType(attackType), attackName);
                            if(Type.parseType(attackType) == null)System.out.println(attackType);
                            attackIndex++;
                            finished = true;
                        }else if(line.startsWith("-")) { //attaque ou faiblesse
                            Type[] pointer; //pointeur tableau
                            if(line.contains("types"))pointer = types; //si on traite les types, le pointeur renverra à la variable temporaire des types
                            else pointer = weaknesses; //cas contraire
                            
                                String[] typesAsStrings = line.substring(7).replaceAll(" ", "").split(","); //suppression des espaces inutiles, et découpage en fonction des virgules
                                pointer = new Type[typesAsStrings.length];
                                for(int i = 0; i < typesAsStrings.length; i++) {
                                    pointer[i] = Type.parseType(typesAsStrings[i]); //transformation en types
                                }
                            }
                        }
                    }
                }
                list.add(new Character(characterName, types, attacks, weaknesses)); //à la fin de la lecture, il reste un personnage à ajouter
            br.close(); //fin de lecture
            } catch (IOException e) {
                e.printStackTrace();
            }
        
        return list;
    }
    
}
