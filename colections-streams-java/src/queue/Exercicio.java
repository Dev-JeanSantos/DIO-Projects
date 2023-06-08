package queue;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Exercicio {

    public static void main(String[] args) {
        Queue<String> queueNames = new LinkedList<>();

        queueNames.add("Juliana");
        queueNames.add("Pedro");
        queueNames.add("Carlos");
        queueNames.add("Larissa");
        queueNames.add("João");

        System.out.println("CRIE E ADICIONE ELEMENTOS A UMA QUEUE");
        System.out.println("EXIBA ESSA LISTA UTILIZANDO ITERATOR");

        System.out.println("My Queue");
        Iterator it = queueNames.iterator();
        while (it.hasNext()) {
            System.out.println("Nome: " + it.next());
        }

        System.out.println("");
        System.out.println("RETORNE O PRIMEIRO ITEM DA FILA, SEM REMOVE-LO");
        System.out.println("O Primeiro a sair da fila: " + queueNames.peek());
        System.out.println(queueNames);

        System.out.println("");
        System.out.println("RETORNE E REMOVA O PRIMEIRO ITEM DA FILA");
        System.out.println("O Primeiro a sair da fila: " + queueNames.poll());
        System.out.println(queueNames);

        System.out.println("");
        System.out.println("ADICIONE DANIEL A QUEUE E VERIFIQUE SUA POSIÇÃO ASSUMIDA");
        System.out.println("Daniel entrou na Queue: " + queueNames.add("Daniel"));
        System.out.println(queueNames);

        System.out.println("");
        System.out.println("RETORNAR O TAMANHO DA QUEUE ");
        System.out.println("Size Queue: " + queueNames.size());

        System.out.println("");
        System.out.println("VERIFIQUE SE A QUEUE ESTÁ VAZIA ");
        System.out.println("Queue is Empty? " + queueNames.isEmpty());

        System.out.println("");
        System.out.println("VERIFIQUE SE O NOME CARLOS ESTÁ NA QUEUE");
        System.out.println("Carlos contains of queue: " + queueNames.contains("Carlos"));


    }
}
