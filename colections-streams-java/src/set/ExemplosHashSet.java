package set;

import java.util.HashSet;
import java.util.Set;

public class ExemplosHashSet {
    public static void main(String[] args) {

        Set<Double> notasAlunos = new HashSet<>();
        notasAlunos.add(3.5);
        notasAlunos.add(5.4);
        notasAlunos.add(8.6);
        notasAlunos.add(7.0);
        notasAlunos.add(10.0);
        notasAlunos.add(4.6);
        notasAlunos.add(8.5);
        notasAlunos.add(7.9);
        notasAlunos.add(6.0);
        notasAlunos.add(1.1);
        notasAlunos.add(9.5);

        System.out.println("Não garante a ordem de inserção dos valores");
        System.out.println("Notas Randomicas: " + notasAlunos);

        System.out.println("");
        System.out.println("Notas Randomicas: " + notasAlunos);
        for (Double nota : notasAlunos) {
            System.out.println("Nota: "+nota);
        }

        System.out.println("");
        System.out.println("Removendo Nota:  9.5 Removida");
        notasAlunos.remove(9.5);
        System.out.println("Notas Randomicas: " + notasAlunos);

        System.out.println("");
        System.out.println("Tamanho SET");
        System.out.println("Tamanho do Set: " + notasAlunos.size());

        System.out.println("");
        System.out.println("Limpanos o SET");
        notasAlunos.clear();

        System.out.println("");
        System.out.println("Verificamos se o SET está vazio após limparmos acima");
        System.out.println("O SET está Vazio? " + notasAlunos.isEmpty());
    }
}
