package set;

import java.util.Iterator;
import java.util.TreeSet;

public class ExemplosTreeSet {
    public static void main(String[] args) {

        TreeSet<String> treeCapitais = new TreeSet<>();
        treeCapitais.add("Porto Alegre");
        treeCapitais.add("Florianópolis");
        treeCapitais.add("Curitiba");
        treeCapitais.add("São Paulo");
        treeCapitais.add("Rio de Janeiro");
        treeCapitais.add("Belo Horizonte");
        treeCapitais.add("Salvador");
        treeCapitais.add("Aracaju");
        treeCapitais.add("Maceio");
        treeCapitais.add("Recife");
        treeCapitais.add("Goiania");

        System.out.println("Não Garante a ordem de inserção dos valores");
        System.out.println("Capitais: " + treeCapitais);

        System.out.println("");
        System.out.println("Retorna o topo da arvore metodo first()");
        System.out.println("Primeira Capital: "+treeCapitais.first());

        System.out.println("");
        System.out.println("Retorna o ultimo da arvore metodo last()");
        System.out.println("Última Capital: "+treeCapitais.last());

        System.out.println("");
        System.out.println("Retorna o antecessor da arvore passada como referencia no parametro metodo lower(referencia)");
        System.out.println("Capital: "+treeCapitais.lower("Goiania"));

        System.out.println("");
        System.out.println("Retorna o sucessor da arvore passada como referencia no parametro metodo higher(referencia)");
        System.out.println("Capital: "+treeCapitais.higher("Goiania"));

        System.out.println("");
        System.out.println("Retorna o topo da arvore removendo do SET metodo poolFirst()");
        System.out.println("Capital Removida: "+treeCapitais.pollFirst());
        System.out.println("Capitais: " + treeCapitais);

        System.out.println("");
        System.out.println("Retorna o ultimo da arvore removendo do SET metodo poolLast()");
        System.out.println("Capital Removida: "+treeCapitais.pollLast());
        System.out.println("Capitais: " + treeCapitais);

        System.out.println("");
        System.out.println("Navegando pela arvore com Iterator:");
        Iterator<String> it = treeCapitais.iterator();
        while (it.hasNext()){
            System.out.println("Capital: "+ it.next());
        }

        System.out.println("");
        System.out.println("Removendo Capital:  Maceio");
        treeCapitais.remove("Maceio");
        System.out.println("Capitais após Maceio ser removida: " + treeCapitais);

        System.out.println("");
        System.out.println("Tamanho Arvore");
        System.out.println("Tamanho do Arvore: " + treeCapitais.size());

        System.out.println("");
        System.out.println("Arvore Zerada com o clean()");
        treeCapitais.clear();

        System.out.println("");
        System.out.println("Verifica se a Arvore está vazia após limparmos acima");
        System.out.println("A Arvore está Vazia? " + treeCapitais.isEmpty());
    }
}
