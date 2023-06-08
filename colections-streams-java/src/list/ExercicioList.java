package list;

import java.util.*;

public class ExercicioList {

    public static void main(String[] args) {

        List<String> listNames = new ArrayList<>();
        listNames.add("Juliana");
        listNames.add("Pedro");
        listNames.add("Carlos");
        listNames.add("Larissa");
        listNames.add("João");

        System.out.println(listNames);

        System.out.println("----------------------------");
        System.out.println("Imprimindo nome com foreach");
        for (String name: listNames ) {
            System.out.println("Name: "+ name);
        }

        System.out.println("----------------------------");
        System.out.println("Imprimindo nome com Iterator");
        Iterator<String> it = listNames.iterator();
        while (it.hasNext()){
            System.out.println("Name: "+ it.next());
        }

        System.out.println("----------------------------");
        System.out.println("* SUBSTITUA O NOME CARLOS POR ROBERTO");
        listNames.set(2, "Roberto");
        System.out.println(listNames);

        System.out.println("----------------------------");
        System.out.println("* RETORNANDO NOME DA POSIÇÃO 1");
        String nomePos1 = listNames.get(1);
        System.out.println(nomePos1);

        System.out.println("----------------------------");
        System.out.println("* REMOVA NOME DA POSIÇÃO 4");
        listNames.remove(4);
        System.out.println(listNames);

        System.out.println("----------------------------");
        System.out.println("* RETORNE A QUANTIDADE DE ITENS NA LISTA");
        int sizeList = listNames.size();
        System.out.println(sizeList);

        System.out.println("----------------------------");
        System.out.println("* VERIFIQUE SE O NOME JULIANO EXISTE NA LISTA");
        boolean existJuliano = listNames.contains("Juliano");
        System.out.println(existJuliano);

        System.out.println("----------------------------");
        System.out.println("* CRIE UMA NOVA LISTA E INSIRA ANOVA LISTA NA LISTA ANTERIOR");
        List<String> listNames2 = new ArrayList<>();
        listNames2.add("Ismael");
        listNames2.add("Rodrigo");

        listNames.addAll(listNames2);
        System.out.println(listNames);

        System.out.println("----------------------------");
        System.out.println("* ORDENE OS ITENS DA LISTA POR ORDEM ALFABETICA");
        Collections.sort(listNames);
        System.out.println(listNames);

        System.out.println("----------------------------");
        System.out.println("* VERIFIQUE SE A LISTA ESTÁ VAZIA");
        boolean isEmpty = listNames.isEmpty();
        System.out.println(isEmpty);
    }
}
