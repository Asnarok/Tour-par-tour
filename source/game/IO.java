package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IO {

    public static File selectCharactersFile(Scanner sc) {
        FileFilter txtFilter = new FileFilter() {
            public boolean accept(File file) {
                return file.getName().endsWith(".txt");
            }
        };

        File dir = new File(System.getProperty("user.dir"));
        File[] files = dir.listFiles(txtFilter);


        System.out.println("Voici la liste de fichiers disponibles pour le chargement du jeu:");
        String name;
        int i = 1;
        for(File f : files) {
            name = f.getName().substring(0, f.getName().lastIndexOf(".")).toLowerCase();
            System.out.println(i+") "+name);
            i++;
        }

        File selected = null;

        int input;

        while(selected == null) {
            input = sc.nextInt()-1;
            if(input >= 0 && input < files.length)selected = files[input];
            if(selected == null)System.out.println("Veuillez entrer un nom de fichier valide.");
        }

        return selected;

    }

    public static List<Character> loadCharacters(File f) {
        
        List<Character> list = new ArrayList<Character>();

        try {

            InputStream is = new FileInputStream(f); //ouverture du fichier en byte stream
            InputStreamReader isr = new InputStreamReader(is); //convertir le byte stream en character stream
            BufferedReader br = new BufferedReader(isr); //lecture ligne par ligne du fichier, sous forme de Strings


            String line; //ligne lue
            
            //variables temporaires, servant au traitement ->

            String characterName = "";
            int[] types = null;
            int[] weaknesses = null;
            Attack[] attacks = new Attack[2];

            int attackIndex = 0; //index dans le tableau attacks

            boolean finished = false; //état du traitement d'un seul personnage

            while((line = br.readLine()) != null) { //parcours du fichier

                if(!line.startsWith("-")) { //noms de persos

                    if(finished){
                        list.add(new Character(characterName, types, attacks, weaknesses)); //on ajoute le perso précédent si on l'a complété
                        finished = false; //rebellote
                    }

                    if(line.length() >=1) { //ignorer les retours à la ligne
                        characterName = line.substring(0, line.indexOf(":")); //nom du perso
                        attacks = new Attack[2]; //2 attaques par persos
                        attackIndex = 0; //réinitialisation de l'index d'attaque
                    }
                    
                }else { //attaques ou types ou faiblesses
                    
                    //la ligne attacks sert juste de formattage pour remplir le fichier texte à la main, 
                    //mais ne sert pas au décodage, donc on l'évite directement
                    if(line.contains("attacks:"))continue; 

                    else {
                        if(line.startsWith("--")) { //traitement des attaques

                            String withoutSpaces = line.replaceAll(" ", ""); //suppression des espaces dans la ligne
                            String attackName = line.substring(2, line.indexOf(":")); //découpage
                            String attackType = withoutSpaces.substring(withoutSpaces.indexOf(":")+1); //pareil

                            attacks[attackIndex] = new Attack(Types.addType(attackType), attackName); //conversion du string en Type et création de l'objet temporaire
                            attackIndex++;

                            finished = true; //fin du traitement d'un personnage

                        }else if(line.startsWith("-")) { //type ou faiblesse
                            
                            String[] strings;

                            int[] pointer; //pointeur tableau

                            if(line.contains("types")) {//si on traite les types, le pointeur renverra à la variable temporaire des types
                                strings = line.substring(line.indexOf("types:")+6).replaceAll(" ", "").split(","); //suppression des espaces inutiles, et découpage en fonction des virgules
                                types = new int[strings.length];
                                pointer = types;
                            }else { //cas contraire
                                strings = line.substring(line.indexOf("weaknesses:")+11).replaceAll(" ", "").split(","); //suppression des espaces inutiles, et découpage en fonction des virgules
                                weaknesses = new int[strings.length];
                                pointer = weaknesses;
                            }
                                
                            for(int i = 0; i < strings.length; i++) {
                                pointer[i] = Types.addType(strings[i]); //conversion en types et stockage dans le tableau temporaire
                            }

                            }
                        }
                    }
                }

                list.add(new Character(characterName, types, attacks, weaknesses)); //à la fin de la lecture, il reste un personnage à ajouter

                br.close(); //fin de lecture

            } catch (IOException e) { // exceptions dûes à la lecture / ouverture du fichier
                e.printStackTrace();
            }
        System.out.println("Found "+Types.types.size()+" types");
        return list;
    }
    
}