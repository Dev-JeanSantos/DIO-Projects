package queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ExempleQueueLinkedList {

    public static void main(String[] args) {
        Queue<String> filaBanco = new LinkedList<>();

        filaBanco.add("Nayara");
        filaBanco.add("Flavio");
        filaBanco.add("Alberto");
        filaBanco.add("Sueli");
        filaBanco.add("Gilberto");
        filaBanco.add("Marcia");
        filaBanco.add("Heitor");

        System.out.println("*******************************");
        System.out.println("Imprimir a Queue criada");
        System.out.println(filaBanco);
        System.out.println("");

        System.out.println("*******************************");
        System.out.println("itera (navega) sobre um Queue com foreach");
        for (String nextNameQueue:filaBanco) {
            System.out.println("Name Queue by foreach: "+nextNameQueue);
        }
        System.out.println("");

        System.out.println("*******************************");
        System.out.println("itera (navega) sobre um Queue com Iterator");
        Iterator<String> it = filaBanco.iterator();
        while (it.hasNext()) {
            System.out.println("Name Queue by iterator: " + it.next());
        }

        System.out.println("");
        System.out.println("*******************************");
        System.out.println("retorna o tamanho da queue size()");
        System.out.println("Size Queue: "+filaBanco.size());

        System.out.println("");
        System.out.println("*******************************");
        System.out.println("retorna a verificação se queue está ou nao vazia  isEmpty()");
        System.out.println("Is Empty Queue: "+filaBanco.isEmpty());

        System.out.println("");
        System.out.println("*******************************");
        System.out.println("Apenas mostra porém não remover o primeiro elemento  metodo peek()");

        String mostrarClienteASerAtendido = filaBanco.peek();
        System.out.println(mostrarClienteASerAtendido);
        System.out.println(filaBanco);
        System.out.println("");

        System.out.println("*******************************");
        System.out.println("mostra porém não remover o primeiro elemento mas caso" +
                " a fila estiver vazia retorna uma excetions element()");


        String primeiroClienteOuErro = filaBanco.element();
        System.out.println(primeiroClienteOuErro);
        System.out.println(filaBanco);
        System.out.println("");


        System.out.println("*******************************");
        System.out.println("Remover o primeiro elemento metodo pool()");

        String clienteASerAtendido = filaBanco.poll();
        System.out.println(clienteASerAtendido);
        System.out.println(filaBanco);
        System.out.println("");

        System.out.println("*******************************");
        System.out.println("mostra uma exception pois a fila está vazia metodo clean() e element()");

        filaBanco.clear();
        String primeiroClienteOuErroException = filaBanco.element();
        System.out.println(primeiroClienteOuErroException);
        System.out.println(filaBanco);
        System.out.println("");


    }


}
