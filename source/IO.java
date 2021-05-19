import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class IO {


    public static List<Character> loadCharacters() throws IOException {
        List<Character> list = new ArrayList<Character>();
        
        File f = new File("characters.txt");
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

            Character current = null;

            while((line = br.readLine()) != null) { //parcours du fichier
                if(!line.startsWith("\t")) { //noms de persos
                    if(current != null)list.add(new Character(characterName, types, attacks, weaknesses)); //on ajoute le perso précédent si on l'a complété
                    characterName = line.substring(0, line.indexOf(":")); //nom du perso
                    attacks = new Attack[2]; //2 attaques par persos
                    attackIndex = 0; //réinitialisation de l'index d'attaque
                    
                }else {
                    if(line.contains("attacks:"))continue; //la ligne attacks sert juste de formattage pour remplir le fichier texte à la main, mais ne sert pas au décodage
                    else {
                        if(line.startsWith("\t\t")) { //traitement des attaques
                            String attackName = line.replaceAll(" ", "").substring(2, line.indexOf(":")); //suppression des potentiels espaces et découpage
                            String attackType = line.replaceAll(" ", "").substring(line.indexOf(":")+1); //pareil
                            attacks[attackIndex] = new Attack(Type.parseType(attackType), attackName);
                            attackIndex++;
                        }else if(line.startsWith("\t")) { //attaque ou faiblesse
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
                
            }
            br.close(); //fin de lecture

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
}
