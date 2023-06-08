package set;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class ExemplosLinkedHashSet {
    public static void main(String[] args) {

        LinkedHashSet<Integer> sequenciaNumerica = new LinkedHashSet<>();
        sequenciaNumerica.add(3);
        sequenciaNumerica.add(5);
        sequenciaNumerica.add(8);
        sequenciaNumerica.add(7);
        sequenciaNumerica.add(10);
        sequenciaNumerica.add(4);
        sequenciaNumerica.add(8);
        sequenciaNumerica.add(7);
        sequenciaNumerica.add(6);
        sequenciaNumerica.add(1);
        sequenciaNumerica.add(9);

        System.out.println("Garante a ordem de inserção dos valores");
        System.out.println("Notas: " + sequenciaNumerica);

        System.out.println("");
        System.out.println("Numeros com Iterator:");
        Iterator<Integer> it = sequenciaNumerica.iterator();
        while (it.hasNext()){
            System.out.println("Numero: "+ it.next());
        }

        System.out.println("");
        System.out.println("Removendo Numero:  9.5 Removida");
        sequenciaNumerica.remove(9.5);
        System.out.println("Numeros Sequenciais: " + sequenciaNumerica);

        System.out.println("");
        System.out.println("Tamanho SET");
        System.out.println("Tamanho do Set: " + sequenciaNumerica.size());

        System.out.println("");
        System.out.println("Limpamos o SET");
        sequenciaNumerica.clear();

        System.out.println("");
        System.out.println("Verificamos se o SET está vazio após limparmos acima");
        System.out.println("O SET está Vazio? " + sequenciaNumerica.isEmpty());
    }
}
