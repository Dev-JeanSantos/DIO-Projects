package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class ExampleTreeMap {
    public static void main(String[] args) {

        TreeMap<String, String> treeCapitais = new TreeMap<>();

        treeCapitais.put("RS", "Porto Alegre");
        treeCapitais.put("SC", "Florianopolis");
        treeCapitais.put("PR", "Curitiba");
        treeCapitais.put("SP", "São Paulo");
        treeCapitais.put("RJ", "Rio de Janeiro");
        treeCapitais.put("MG", "Belo Horizonte");
        treeCapitais.put("ES", "Vitória");
        treeCapitais.put("BA", "Salvador");

        System.out.println("");
        System.out.println(treeCapitais);

        System.out.println("");
        System.out.println("Retorna o topo da arvore metodo firstKey()");
        System.out.println("Primeira Estado: "+treeCapitais.firstKey());

        System.out.println("");
        System.out.println("Retorna o ultimo da arvore metodo lastKey()");
        System.out.println("Último Estado: "+treeCapitais.lastKey());

        System.out.println("");
        System.out.println("Retorna o antecessor da arvore passada como referencia no parametro metodo lowerKey(referencia)");
        System.out.println("Estado: "+treeCapitais.lowerKey("RJ"));

        System.out.println("");
        System.out.println("Retorna o sucessor da arvore passada como referencia no parametro metodo higherKey(referencia)");
        System.out.println("Estado: "+treeCapitais.higherKey("RJ"));

        System.out.println("");
        System.out.println("Todo o MAP ( ESTADO = CAPITAIS )");
        System.out.println(treeCapitais);

        System.out.println("");
        System.out.println("Retorna o elemento do topo  da arvore map");
        System.out.println("estado e Capital do topo da Arvore: "+treeCapitais.firstEntry().getKey() + " -- " + treeCapitais.firstEntry().getValue());

        System.out.println("");
        System.out.println("Retorna o ultimo elemento da arvore map");
        System.out.println("Estado e Capital do topo da Arvore: "+treeCapitais.lastEntry().getKey() + " -- " + treeCapitais.lastEntry().getValue());

        System.out.println("");
        System.out.println("Retorna o elemento do topo  da arvore  e remove do map");
        System.out.println("estado e Capital do topo da Arvore foi removida: "+treeCapitais.pollFirstEntry().getKey() + " -- " + treeCapitais.pollFirstEntry().getValue());

        System.out.println("");
        System.out.println("Retorna o ultimo elemento da arvore e remove do map");
        System.out.println("Estado e Capital do topo da Arvore foi removida: "+treeCapitais.pollLastEntry().getKey() + " -- " + treeCapitais.pollLastEntry().getValue());

        System.out.println("");
        System.out.println("Todo o MAP ( ESTADO = CAPITAIS )");
        System.out.println(treeCapitais);

        System.out.println("");
        System.out.println("Navegando nas capitais con Entry ");
        Map.Entry<String, String> firstEntry = treeCapitais.pollFirstEntry();
        Map.Entry<String, String> lastEntry = treeCapitais.pollLastEntry();
        System.out.println(firstEntry);
        System.out.println(lastEntry);


        System.out.println("");
        System.out.println("Todo o MAP ( ESTADO = CAPITAIS )");
        System.out.println(treeCapitais);

        System.out.println("");
        System.out.println("Navegando com Iterator nas capitais con Entry ");
        Iterator<String> iterator = treeCapitais.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            System.out.println(key + " -- "+ treeCapitais.get(key));
        }

        System.out.println("");
        System.out.println("Navegando com foreach nas capitais com KeySet ");
        for(String capital: treeCapitais.keySet()){
            System.out.println(capital + " -- "+ treeCapitais.get(capital));

        }

        System.out.println("");
        System.out.println("Navegando com foreach nas capitais com Entry ");
        for(Map.Entry<String, String> capital: treeCapitais.entrySet()){
            System.out.println(capital.getKey() + " -- "+ capital.getValue());
        }
    }
}
