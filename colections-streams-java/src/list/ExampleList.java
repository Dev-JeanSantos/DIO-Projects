package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ExampleList {

    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        nomes.add("Romario");
        nomes.add("Bebeto");
        nomes.add("Dunga");
        nomes.add("César Sampaio");
        nomes.add("Taffarel");
        nomes.add("Ricardo Rocha");
        nomes.add("Parreira");

        System.out.println("*******************************");
        System.out.println("Apenas Imprimir a Lista");
        System.out.println(nomes);

        System.out.println("*******************************");
        System.out.println("Imprimir a Lista em Ordem Alfabetica com Interface Collections eo metodo Sort");
        Collections.sort(nomes);
        System.out.println(nomes);

        System.out.println("*******************************");
        System.out.println("Atualizar uma lista com  metodo set(Int, String)");
        System.out.println("atualizamos Bebeto no indice 0 para Branco");
        nomes.set(0, "Branco");
        System.out.println(nomes);

        System.out.println("*******************************");
        System.out.println("Excluindo com o metodo remove(Int) ");
        System.out.println("Removemos o indice 3 em nossa lista no caso Parreira  ");
        nomes.remove(3);
        System.out.println(nomes);

        System.out.println("*******************************");
        System.out.println("Buscando um valor com o metodo get(Int) ");
        System.out.println("Buscamos o indice 1 em nossa lista no caso César Sampaio e salvamos em uma var ");
        String nome = nomes.get(1);
        System.out.println(nome);

        System.out.println("*******************************");
        System.out.println("Buscando o tamanho da lista metodo size(lista) ");
        int tamanhoLista = nomes.size();
        System.out.println(tamanhoLista);

        System.out.println("*******************************");
        System.out.println("Buscando um elemento com o metodo contains(elemento) retorna um boolean ");
        System.out.println("verificamos se existe taffarel na Lista ");
        boolean temTaffarel = nomes.contains("Taffarel");
        System.out.println(temTaffarel);


        System.out.println("*******************************");
        System.out.println("Buscando um elemento com o metodo contains(elemento)");
        System.out.println("verificamos se existe Dida na Lista ");
        boolean temDida = nomes.contains("Dida");
        System.out.println(temDida);

        System.out.println("*******************************");
        System.out.println("verifca se a lista está vazia metodo isEmpty() retorna um boolean");
        boolean listaIsVazia = nomes.isEmpty();
        System.out.println(listaIsVazia);

        System.out.println("*******************************");
        System.out.println("retorna o indice de uma lista com o metodo indexOf(elemento) retorna um boolean");
        System.out.println("verificamos a posição do Romario ");
        int posRomario = nomes.indexOf("Romario");
        System.out.println(posRomario);

        System.out.println("*******************************");
        System.out.println("iterar (navegar) sobre uma lista com foreach");
        for (String nomeDoItem: nomes){
            System.out.println("Nome com foreach: "+nomeDoItem);
        }

        System.out.println("*******************************");
        System.out.println("iterar (navegar) sobre uma lista com iterator");
        Iterator<String> it = nomes.iterator();
        while (it.hasNext()){
            System.out.println("Nome com iterator: "+ it.next());
        }

        System.out.println("*******************************");
        System.out.println("Limpa uma lista com metodo clear() retorna um boolean");
        nomes.clear();
        boolean listaIsVazia2 = nomes.isEmpty();
        System.out.println(listaIsVazia2);

    }
}
