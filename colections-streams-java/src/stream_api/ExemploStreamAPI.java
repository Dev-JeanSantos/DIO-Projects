package stream_api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExemploStreamAPI {

    public static void main(String[] args) {
        List<String> estudantes = new ArrayList<>();

        estudantes.add("Pedro");
        estudantes.add("Oliveira");
        estudantes.add("Marcos");
        estudantes.add("Thayse");
        estudantes.add("Marcelo");
        estudantes.add("Carla");
        estudantes.add("Juliana");
        estudantes.add("Thiago");
        estudantes.add("Rafael");
        estudantes.add("Mel");

        System.out.println("Contagem de elementos do stream: " + estudantes.stream().count());
        System.out.println("Retorna elemento com maior numero de letras: " + estudantes.stream().max(Comparator.comparingInt(String::length)));
        System.out.println("Retorna elemento com menor numero de letras: " + estudantes.stream().min(Comparator.comparingInt(String::length)));
        System.out.println("Retorna elementos com a letra R no nome: " + estudantes.stream().
                filter((estudante) -> estudante.toLowerCase().contains("r")).collect(Collectors.toList()));
        System.out.println("Retorna elementos (nome com seu respectivo total de caracteres): " + estudantes.stream()
                .map(estudante -> estudante.concat(" -> ").concat(String.valueOf(estudante.length())))
                .collect(Collectors.toList()));
        System.out.println("retorna os 3 primeiros elementos de uma coleção: "+estudantes.stream().
                limit(3).collect(Collectors.toList()));
        System.out.println("Retorna todos os elementoscom peek: "+ estudantes.stream().peek(System.out::println).collect(Collectors.toList()));
        System.out.println("Retorna todos os elementoscom forEach: ");
        estudantes.stream().forEach(System.out::println);
        System.out.println("Todos os elementos possuem a letra M no nome? "+ estudantes.stream().allMatch(elemento -> elemento.contains("m")));
        System.out.println("Tem algum elemento com a letra m minusculo no nome? "+ estudantes.stream().anyMatch(elemento -> elemento.contains("m")));
        System.out.println("Existe algum elemento que não possui a letra m minuscula no nome? "+ estudantes.stream().noneMatch(elemento -> elemento.contains("m")));
        System.out.println("Retorna o primeiro elemento da coleção: ");
        estudantes.stream().findFirst().ifPresent(System.out::println);

        System.out.println("Operação Encadeada: ");
        System.out.println(estudantes.stream()
                .peek(System.out::println)
                .map(estudante -> estudante.concat(" - ").concat(String.valueOf(estudante.length())))
                .peek(System.out::println)
                .filter((estudante) ->
                estudante.toLowerCase().contains("r"))
//                .collect(Collectors.toList()));
//            .collect(Collectors.joining(", ")));
//            .collect(Collectors.toSet()));
            .collect(Collectors.groupingBy(estudante -> estudante.substring(estudante.indexOf("-") + 1))));


    }

}
