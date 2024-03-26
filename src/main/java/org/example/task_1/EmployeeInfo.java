package org.example.task_1;

import java.util.*;
import java.util.stream.*;

public class EmployeeInfo {
    public static void main(String[] args) {
        List<Map<String, String>> employees = Arrays.asList(
                Map.of("Имя", "Кирилл", "Возраст", "26", "Должность", "Middle java dev", "Зарплата", "150000 руб"),
                Map.of("Имя", "Виталий", "Возраст", "28", "Должность", "Senior java automation QA", "Зарплата", "2000$"),
                Map.of("Имя", "Александр", "Возраст", "31", "Должность", "junior functional tester", "Зарплата", "50000 руб"),
                Map.of("Имя", "Дементий", "Возраст", "35", "Должность", "dev-ops", "Зарплата", "1500$")
        );

        List<String> namesUnder30 = employees.stream()
                .filter(e -> Integer.parseInt(e.get("Возраст")) < 30)
                .map(e -> e.get("Имя"))
                .collect(Collectors.toList());

        System.out.println("Сотрудники младше 30: " + namesUnder30);

        List<String> namesPaidInRubles = employees.stream()
                .filter(e -> e.get("Зарплата").endsWith("руб"))
                .map(e -> e.get("Имя"))
                .collect(Collectors.toList());

        System.out.println("Сотрудники, получающие зарплату в рублях: " + namesPaidInRubles);

        OptionalDouble averageAge = employees.stream()
                .mapToInt(e -> Integer.parseInt(e.get("Возраст")))
                .average();

        if (averageAge.isPresent()) {
            System.out.printf("Средний возраст сотрудников: %.2f%n", averageAge.getAsDouble());
        }
    }
}
