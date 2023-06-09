package comparator_comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExampleComparatorsList {

    public static void main(String[] args) {
        List<Estudante> estudantes = new ArrayList<>();

        estudantes.add(new Estudante("Pedro", 19));
        estudantes.add(new Estudante("Carlos", 23));
        estudantes.add(new Estudante("Mariana", 21));
        estudantes.add(new Estudante("João", 18));
        estudantes.add(new Estudante("Thiago", 20));
        estudantes.add(new Estudante("George", 22));
        estudantes.add(new Estudante("larissa", 21));

        System.out.println("");
        System.out.println("-------Ordem de Inserção------------");
        System.out.println(estudantes);

        System.out.println("");
        System.out.println("-------Ordem natural do números com o sort - Idade ------------");
        estudantes.sort((first, second) -> first.getIdade() - second.getIdade());
        System.out.println(estudantes);

        System.out.println("");
        System.out.println("-------Ordem reversa dos números com o sort - Idade ------------");
        estudantes.sort((first, second) -> second.getIdade() - first.getIdade());
        System.out.println(estudantes);

        System.out.println("");
        System.out.println("-------Ordem natural dos números com sort - Idade (methodo referece) ------------");
        estudantes.sort((Comparator.comparingInt(Estudante::getIdade)));
        System.out.println(estudantes);

        System.out.println("");
        System.out.println("-------Ordem reversa dos números com sort - Idade (methodo referece) ------------");
        estudantes.sort((Comparator.comparingInt(Estudante::getIdade).reversed()));
        System.out.println(estudantes);

        System.out.println("");
        System.out.println("-------Ordem natural dos números com sort - Idade (Interface Comparable) ------------");
        Collections.sort(estudantes);
        System.out.println(estudantes);

        System.out.println("");
        System.out.println("-------Ordem Inversa dos números com sort - Idade (Interface Comparable) ------------");
        Collections.sort(estudantes, new EstudanteOrdemIdadeReversaComparator());
        System.out.println(estudantes);
    }
}
