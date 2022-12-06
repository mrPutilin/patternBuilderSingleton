package singleton;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getInstance();

        logger.log("Зупускаем программу");

        logger.log("Введите размер списка");
        int size = scanner.nextInt();
        logger.log("Введите верхнуюю границу для значений");
        int limitUp = scanner.nextInt();

        List<Integer> elements = new ArrayList<>(size);
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            elements.add(random.nextInt(limitUp));
        }

        logger.log("Вот случайный список " + elements);

        logger.log("Просим ввести входные данные для фильтрации");

        Filter filter = new Filter(scanner.nextInt());


        System.out.println("Отфильтрованный список" + filter.filterOut(elements));

        logger.log("Завершаем работу");

    }
}
