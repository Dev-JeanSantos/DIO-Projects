package optional;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class ExemplosOptionalPrimitivos {

    public static void main(String[] args) {
        System.out.println("***Valor inteiro Opcional***");
        OptionalInt.of(12).ifPresent(System.out::println);

        System.out.println("***Valor decimal Opcional***");
        OptionalDouble.of(58.6).ifPresent(System.out::println);

        System.out.println("***Valor long Opcional***");
        OptionalLong.of(75L).ifPresent(System.out::println);
    }
}
