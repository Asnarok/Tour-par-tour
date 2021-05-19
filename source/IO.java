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
            String line;

            String characterName;
            Type[] types;
            Type[] weaknesses;


            Character current = null;

            while((line = br.readLine()) != null) {
                if(!line.startsWith("\t")) { //noms de persos
                    if(current != null)list.add(current); //on ajoute le perso précédent si on l'a complété
                    characterName = line.substring(0, line.indexOf(":")); //nom du perso
                    
                }else {
                    if(line.contains("attacks:"))continue;
                }
                
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
}
