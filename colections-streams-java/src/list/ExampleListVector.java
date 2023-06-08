package list;

import java.util.*;

public class ExampleListVector {

    public static void main(String[] args) {
        List<String> times = new Vector<>();
        times.add("Corinthias");
        times.add("Flamengo");
        times.add("Botafogo");
        times.add("Santa Cruz");
        times.add("Bahia");
        times.add("Chapecoense");
        times.add("Internacional");
        times.add("São Paulo");
        times.add("Santos");
        times.add("Vasco");

        System.out.println("*******************************");
        System.out.println("Apenas Imprimir a Lista");
        System.out.println(times);

        System.out.println("*******************************");
        System.out.println("Imprimir a Lista em Ordem Alfabetica com Interface Collections eo metodo Sort");
        Collections.sort(times);
        System.out.println(times);

        System.out.println("*******************************");
        System.out.println("Atualizar uma lista com  metodo set(Int, String)");
        System.out.println("atualizamos Corinthias no indice 0 para Atletico Mineiro");
        times.set(0, "Atletico Mineiro");
        System.out.println(times);

        System.out.println("*******************************");
        System.out.println("Excluindo com o metodo remove(Int) ");
        times.remove(3);
        System.out.println(times);

        System.out.println("*******************************");
        System.out.println("Buscando um valor com o metodo get(Int) ");
        String nome = times.get(1);
        System.out.println(nome);

        System.out.println("*******************************");
        System.out.println("Buscando o tamanho da lista metodo size(lista) ");
        int tamanhoLista = times.size();
        System.out.println(tamanhoLista);

        System.out.println("*******************************");
        System.out.println("Buscando um elemento com o metodo contains(elemento) retorna um boolean ");
        System.out.println("verificamos se existe taffarel na Lista ");
        boolean temVasco = times.contains("Vasco");
        System.out.println(temVasco);


        System.out.println("*******************************");
        System.out.println("Buscando um elemento com o metodo contains(elemento)");
        System.out.println("verificamos se existe Santos na Lista ");
        boolean temSantos = times.contains("Santos");
        System.out.println(temSantos);

        System.out.println("*******************************");
        System.out.println("verifca se a lista está vazia metodo isEmpty() retorna um boolean");
        boolean listaIsVazia = times.isEmpty();
        System.out.println(listaIsVazia);

        System.out.println("*******************************");
        System.out.println("retorna o indice de uma lista com o metodo indexOf(elemento) retorna um boolean");
        int posBotafogo = times.indexOf("Botafogo");
        System.out.println(posBotafogo);

        System.out.println("*******************************");
        System.out.println("iterar (navegar) sobre uma lista com foreach");
        for (String nomeDoItem: times){
            System.out.println("Nome com foreach: "+nomeDoItem);
        }

        System.out.println("*******************************");
        System.out.println("iterar (navegar) sobre uma lista com iterator");
        Iterator<String> it = times.iterator();
        while (it.hasNext()){
            System.out.println("Nome com iterator: "+ it.next());
        }

        System.out.println("*******************************");
        System.out.println("Limpa uma lista com metodo clear() retorna um boolean");
        times.clear();
        boolean listaIsVazia2 = times.isEmpty();
        System.out.println(listaIsVazia2);
    }
}
