package map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class ExampleHashTable {
    public static void main(String[] args) {

        Hashtable<String, Integer> estudantes = new Hashtable<>();

        estudantes.put("Marcos", 59);
        estudantes.put("Felipe", 67);
        estudantes.put("Giovana", 44);
        estudantes.put("Valdomiro", 30);
        estudantes.put("Miguel", 28);
        estudantes.put("Helena", 26);
        estudantes.put("Zaia", 49);
        estudantes.put("Beatriz", 18);

        System.out.println(estudantes);

        System.out.println("");
        System.out.println("Zaia agora tem 10 anos");
        estudantes.put("Zaia", 10);
        System.out.println(estudantes);

        System.out.println("");
        System.out.println("Qual é a idade de Valdomiro no map? "+estudantes.get("Valdomiro"));

        System.out.println("");
        System.out.println("removendo Helena");
        estudantes.remove("Helena");
        System.out.println(estudantes);

        System.out.println("");
        System.out.println("Navegando no map com metodo Entry");
        for (Map.Entry<String, Integer> entry: estudantes.entrySet()){
            System.out.println(entry.getKey() + " -- " + entry.getValue());
        }


        System.out.println("");
        System.out.println("Navegando no map com KeySet");
        for (String key : estudantes.keySet()){
            System.out.println(key + " -- " + estudantes.get(key));
        }

        System.out.println("");
        System.out.println("Tamanho do Map: "+ estudantes.size());


    }

}
