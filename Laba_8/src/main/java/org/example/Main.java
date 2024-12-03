package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {

        System.out.println();
        List<String> list = List.of("Чайник", "Ночь", "Роза", "Чайник", "Ночь", "Улица", "Фонарь", "Аптека", "Роза", "Аптека");
        System.out.println("Повтор " + list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toCollection(TreeSet::new))))
                .entrySet().stream()
                .max(Map.Entry.comparingByKey())
                .map(entry -> entry.getValue().stream().filter(word -> word.length() <= 5).toList())
                .orElse(Collections.emptyList()));

        System.out.println();
        System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
        System.out.println();

        List<Kontact> kontacts = Arrays.asList(
                new Kontact("Игорь", "Тестов", 19, "+12377997987"),
                new Kontact("Василий", "Шихов", 52, "+88005553535"),
                new Kontact("Ванёк", "Ивановааааааааааа", 35, "+458009529123"),
                new Kontact("Вася", "Ива", 35, "+459800529123"),
                new Kontact("Иванюк", "Иванчикыы", 35, "+459580029123"),
                new Kontact("Иван", "Иванов", 35, "+459529123"),
                new Kontact("Галина", "Раневская", 50, "+380021654987")
        );

        String searchStr = "800";


        System.out.println(
                kontacts.stream()
                        .filter(contact -> contact.getPhone().contains(searchStr))
                        .sorted(Comparator.comparingInt(contact -> contact.getLastName().length()))
                        .map(Kontact::getFirstName)
                        .collect(Collectors.joining(", ", "N контактов зовут: ", "."))
        );



        }
    }