package ru.nsu.dsavenko.taskchoice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TaskChoice {

    private static final List<String> STUDENTS = Arrays.asList(
            "Астахов Ярослав",
            "Вдовин Артем",
            "Гаркуша Ксения",
            "Голуб Александр",
            "Гузенков Дмитрий",
            "Жусалин Айдархан",
            "Петренко Никита",
            "Потапов Илья",
            "Процева Валерия",
            "Рудякова Анна",
            "Соловьев Андрей",
            "Тимофеев Николай",
            "Хадуков Владислав"
    );

    public static void main(String[] args) {
        System.out.print("Количество задач: ");
        int n = new Scanner(System.in).nextInt();
        if (0 >= n) {
            System.err.println("Должно быть больше 0");
            return;
        }
        List<Integer> choice = createChoice(n, STUDENTS.size());
        IntStream.range(0, STUDENTS.size())
                .mapToObj(i -> STUDENTS.get(i) + " -> " + choice.get(i))
                .forEach(System.out::println);
    }

    private static List<Integer> createChoice(int maxN) {
        List<Integer> ret = IntStream.rangeClosed(1, maxN)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        Collections.shuffle(ret);
        return ret;
    }

    private static List<Integer> createChoice(int maxN, int size) {
        List<Integer> ret = new ArrayList<>();
        while (ret.size() < size) {
            ret.addAll(createChoice(maxN));
        }
        return ret;
    }
}
