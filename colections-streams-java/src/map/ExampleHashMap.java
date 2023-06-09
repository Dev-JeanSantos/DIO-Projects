package map;

import java.util.HashMap;
import java.util.Map;

public class ExampleHashMap {
    public static void main(String[] args) {

        Map<String, Integer> campeosMundiaisFifa = new HashMap<>();

        campeosMundiaisFifa.put("Brasil", 5);
        campeosMundiaisFifa.put("Alemanha", 4);
        campeosMundiaisFifa.put("Itália", 4);
        campeosMundiaisFifa.put("Argentina", 3);
        campeosMundiaisFifa.put("Uruguai", 2);
        campeosMundiaisFifa.put("França", 2);
        campeosMundiaisFifa.put("Inglaterra", 1);
        campeosMundiaisFifa.put("Espanha", 1);

        System.out.println(campeosMundiaisFifa);

        System.out.println("");
        System.out.println("Atualizar valor da chave com metodo put(chave, valor a atualizar)");
        System.out.println("Brasil agora tem 6 titulos");
        campeosMundiaisFifa.put("Brasil", 6);
        System.out.println(campeosMundiaisFifa);

        System.out.println("");
        System.out.println("busca um indice metodo get(chave)");
        System.out.println("Qual é a posição de Uruguai no map? "+campeosMundiaisFifa.get("Uruguai"));

        System.out.println("");
        System.out.println("busca se existe ou nao um valor metodo containerKey(chave)");
        System.out.println("Existe Alemanha no meu map? "+campeosMundiaisFifa.containsKey("Alemanha"));

        System.out.println("");
        System.out.println("remover um valor metodo remove(chave)");
        campeosMundiaisFifa.remove("Alemanha");
        System.out.println("Existe Alemanha no meu map após a remoção acima? "+campeosMundiaisFifa.containsKey("Alemanha"));

        System.out.println("");
        System.out.println("busca se existe ou nao um valor metodo containsValue(chave)");
        System.out.println("Existe seleção de valor 6 no meu map? "+campeosMundiaisFifa.containsValue(6));

        System.out.println("");
        System.out.println("retorna o tamanho do map metodo size()");
        System.out.println("Tamanho MAP: "+campeosMundiaisFifa.size());

        System.out.println("");
        System.out.println("Navegando no map com metodo Entry");
        for (Map.Entry<String, Integer> entry: campeosMundiaisFifa.entrySet()){
            System.out.println(entry.getKey() + " -- " + entry.getValue());
        }


        System.out.println("");
        System.out.println("Navegando no map com KeySet");
        for (String key : campeosMundiaisFifa.keySet()){
            System.out.println(key + " -- " + campeosMundiaisFifa.get(key));
        }

        System.out.println("");
        System.out.println("Busca se existe ou nao um valor da chave metodo containskey(key)");
        System.out.println("Existe seleção USA no map? "+campeosMundiaisFifa.containsKey("USA"));
        System.out.println("Existe seleção BRASIL no map? "+campeosMundiaisFifa.containsKey("Brasil"));

        System.out.println("");
        System.out.println("Busca se existe ou nao um valor especifico metodo containsValue(key)");
        System.out.println("Existe seleção com 3 titulos no map? "+campeosMundiaisFifa.containsValue(3));
        System.out.println("Existe seleção com 10 titulos  no map? "+campeosMundiaisFifa.containsValue(10));


        System.out.println("");
        System.out.println("retorna o tamanho do map metodo size()");
        System.out.println("Tamanho do Map: "+ campeosMundiaisFifa.size());

        System.out.println("");
        System.out.println("Zerando o MAP");
        campeosMundiaisFifa.clear();

        System.out.println("");
        System.out.println("Tamanho do Map após esvazia-lo: "+ campeosMundiaisFifa.size());

    }

}
