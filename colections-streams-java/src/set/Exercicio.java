package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Exercicio {

    public static void main(String[] args) {
        System.out.println("***************************************");
        System.out.println("         UTILIZANDO O HASHSET");
        System.out.println("***************************************");
        HashSet<Integer> numerosInteiros = new HashSet<>();
        numerosInteiros.add(3);
        numerosInteiros.add(88);
        numerosInteiros.add(20);
        numerosInteiros.add(44);
        numerosInteiros.add(3);

        System.out.println(numerosInteiros);

        System.out.println("");
        System.out.println("Navegando com forEach");
        for (Integer numero:numerosInteiros) {
            System.out.println("Numero: "+ numero);
        }

        System.out.println("");
        System.out.println("Navegando com Iterator");
        Iterator it = numerosInteiros.iterator();
        while (it.hasNext()){
            System.out.println("Numero: "+ it.next());
        }

        System.out.println("");
        System.out.println("Removendo o primeiro item do SET");
        numerosInteiros.remove(3);
        System.out.println(numerosInteiros);

        System.out.println("");
        System.out.println("Inserindo 23 no SET");
        numerosInteiros.add(23);
        System.out.println(numerosInteiros);

        System.out.println("");
        System.out.println("verifique o tamanho do SET");
        System.out.println("Tamanho SET: "+numerosInteiros.size());

        System.out.println("");
        System.out.println("verifique se o SET está Vazio");
        System.out.println("SET está vazio? "+numerosInteiros.isEmpty());

        System.out.println("");
        System.out.println("***************************************");
        System.out.println("         UTILIZANDO O LINKEDHASHSET");
        System.out.println("***************************************");
        LinkedHashSet<Integer> numerosInteirosLinked = new LinkedHashSet<>();
        numerosInteirosLinked.add(3);
        numerosInteirosLinked.add(88);
        numerosInteirosLinked.add(20);
        numerosInteirosLinked.add(44);
        numerosInteirosLinked.add(3);

        System.out.println(numerosInteirosLinked);

        System.out.println("");
        System.out.println("Navegando com forEach");
        for (Integer numero:numerosInteirosLinked) {
            System.out.println("Numero: "+ numero);
        }

        System.out.println("");
        System.out.println("Navegando com Iterator");
        Iterator itLinked = numerosInteirosLinked.iterator();
        while (itLinked.hasNext()){
            System.out.println("Numero: "+ itLinked.next());
        }

        System.out.println("");
        System.out.println("Removendo o primeiro item do SET");
        numerosInteirosLinked.remove(3);
        System.out.println(numerosInteirosLinked);

        System.out.println("");
        System.out.println("Inserindo 23 no SET");
        numerosInteirosLinked.add(23);
        System.out.println(numerosInteirosLinked);

        System.out.println("");
        System.out.println("verifique o tamanho do SET");
        System.out.println("Tamanho SET: "+numerosInteirosLinked.size());

        System.out.println("");
        System.out.println("verifique se o SET está Vazio");
        System.out.println("SET está vazio? "+numerosInteirosLinked.isEmpty());

        System.out.println("");
        System.out.println("***************************************");
        System.out.println("         UTILIZANDO O TREESET");
        System.out.println("***************************************");
        TreeSet<Integer> numerosInteirosTreeSet = new TreeSet<>();
        numerosInteirosTreeSet.add(3);
        numerosInteirosTreeSet.add(88);
        numerosInteirosTreeSet.add(20);
        numerosInteirosTreeSet.add(44);
        numerosInteirosTreeSet.add(3);

        System.out.println(numerosInteirosTreeSet);

        System.out.println("");
        System.out.println("Navegando com forEach");
        for (Integer numero:numerosInteirosTreeSet) {
            System.out.println("Numero: "+ numero);
        }

        System.out.println("");
        System.out.println("Navegando com Iterator");
        Iterator itTreeSet = numerosInteirosTreeSet.iterator();
        while (itTreeSet.hasNext()){
            System.out.println("Numero: "+ itTreeSet.next());
        }

        System.out.println("");
        System.out.println("Removendo o primeiro item do SET");
        System.out.println(numerosInteirosTreeSet.pollFirst());
        System.out.println(numerosInteirosTreeSet);

        System.out.println("");
        System.out.println("Inserindo 23 no SET");
        numerosInteirosTreeSet.add(23);
        System.out.println(numerosInteirosTreeSet);

        System.out.println("");
        System.out.println("verifique o tamanho do SET");
        System.out.println("Tamanho SET: "+numerosInteirosTreeSet.size());

        System.out.println("");
        System.out.println("verifique se o SET está Vazio");
        System.out.println("SET está vazio? "+numerosInteirosTreeSet.isEmpty());
    }
}
