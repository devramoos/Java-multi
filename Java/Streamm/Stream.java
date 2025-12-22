packeage Streamm;

import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Ninja> ninjas = new ArrayList<>();
        ninjas.add(new Ninja("Naruto Uzumaki", 17, "Konoha"));
        ninjas.add(new Ninja("Hinata Hyuga", 17, "Konoha"));
        ninjas.add(new Ninja("Kakashi Hatake", 31, "Konoha"));
        ninjas.add(new Ninja("Sakura Haruno", 18, "Konoha"));
        ninjas.add(new Ninja("Sasuke Uchiha", 18, "Konoha"));
        ninjas.add(new Ninja("Itachi Uchiha", 21, "Konoha"));
        ninjas.add(new Ninja("Gaara", 17, "Suna"));

        printWithDivisor("Filtrando Idade = 17");
        ninjas.stream()
                .filter(ninja -> ninja.idade() == 17)
                .forEach(System.out::println);

        printWithDivisor("Ordenando Nome");
        ninjas.stream()
                .sorted(Comparator.comparing(Ninja::nome))
                .forEach(System.out::println);

        printWithDivisor("Ordenando Idade");
        ninjas.stream()
                .sorted(Comparator.comparingInt(Ninja::idade))
                .forEach(System.out::println);

        printWithDivisor("Ninja mais velho");
        Ninja ninjaMaisVelho = ninjas.stream()
                .max(Comparator.comparingInt(Ninja::idade))
                .orElse(null);

        System.out.println(ninjaMaisVelho);

        printWithDivisor("Ninja mais novo");
        Ninja ninjaMaisNovo = ninjas.stream()
                .min(Comparator.comparingInt(Ninja::idade))
                .orElse(null);

        System.out.println(ninjaMaisNovo);

        printWithDivisor("Somando Idade");
        int ninjaTotalIdades = ninjas.stream()
                .map(Ninja::idade)
                .reduce(Integer::sum)
                .orElse(null);

        System.out.println(ninjaTotalIdades);

        printWithDivisor("Buscando ninja Naruto");
        Ninja ninjaNaruto = ninjas.stream()
                .filter(ninja -> ninja.nome().toLowerCase().contains("naruto"))
                .findFirst()
                .orElse(null);

        System.out.println(ninjaNaruto);
    }

    static void printWithDivisor(String name) {
        String divisor = Stream
                .generate(() -> String.valueOf('-'))
                .limit(5)
                .collect(Collectors.joining());

        System.out.println(divisor + " " + name + " " + divisor);
    }
}