package game;

import java.util.ArrayList;
import java.util.List;

public class Types {

    public static List<String> types = new ArrayList<String>();

    public static int addType(String label) {
        if(!types.contains(label)){
            types.add(label);
            return types.size()-1;
        }else return types.indexOf(label);
    }   

}
