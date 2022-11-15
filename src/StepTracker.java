import java.util.Scanner;

public class StepTracker {

    // Считываем ввод пользователя по шагам за день
    static void getSteps(Scanner scanner, int[][] steps) {

        // Ввод данных пользователем с учетом допустимых диапазонов

        System.out.println("Введите номер месяца от 1 (янв) до 12 (дек):");
        int month = scanner.nextInt();
        while ((month < 1) || (month > 12)) {
            System.out.println("Ошибка, повторите ввод:");
            month = scanner.nextInt();
        }

        System.out.println("Введите дату от 1 до 30:");
        int day = scanner.nextInt();
        while ((day < 1) || (day > 30)) {
            System.out.println("Ошибка, повторите ввод:");
            day = scanner.nextInt();
        }

        System.out.println("Введите количество шагов:");
        int stepsPerDay = scanner.nextInt();
        while (stepsPerDay < 0) {
            System.out.println("Ошибка, введите положительное значение:");
            stepsPerDay = scanner.nextInt();
        }

        steps[month - 1][day - 1] = stepsPerDay;
        System.out.println("Значение сохранено!\n");
    }

    // Выводим статистику по шагам (в этом методе вызываем другие)
    static void printStatistics(Scanner scanner, int[][] steps, int stepsGoal) {
        System.out.println("Введите номер месяца от 1 (янв) до 12 (дек):");
        int[] chosenMonthSteps = chooseMonth(scanner, steps);

        // Вызываем метод печати списка шагов по дням
        printSteps(chosenMonthSteps);

        // Вызываем методы для вывода статистики пользователя
        System.out.println("\n\nВаша статистика за выбранный месяц");
        System.out.println("  Среднее количество шагов в день: " + findStepsAverage(chosenMonthSteps));
        System.out.println("  Общее количество шагов за месяц: " + findStepsTotal(chosenMonthSteps));
        System.out.println("  Максимальное пройденное количество шагов в месяце: " + findStepsMax(chosenMonthSteps));
        System.out.println("  Лучшая серия шагов в месяце: " + findBestStepsSeries(chosenMonthSteps, stepsGoal));
        System.out.println("  Пройденная дистанция (в км): " + Converter.convertDistance(findStepsTotal(chosenMonthSteps)));
        System.out.println("  Количество сожжённых килокалорий: " + Converter.convertCalories(findStepsTotal(chosenMonthSteps)) + "\n");

    }

    // Печатаем кол-во пройденных шагов по дням
    static void printSteps(int[] chosenMonthSteps) {
        for (int i = 0; i < chosenMonthSteps.length; i++) {
            System.out.print((i + 1) + " день: " + chosenMonthSteps[i] + ", ");
        }
    }

    // Считаем сумму пройденных шагов
    static int findStepsTotal(int[] chosenMonthSteps) {
        int stepsTotal = 0;
        for (int i = 0; i < chosenMonthSteps.length; i++) {
            stepsTotal = stepsTotal + chosenMonthSteps[i];
        }
        return stepsTotal;
    }

    // Считаем среднее количество шагов
    static int findStepsAverage(int[] chosenMonthSteps) {
        return findStepsTotal(chosenMonthSteps) / chosenMonthSteps.length;
    }

    // Считаем максимальное количество шагов
    static int findStepsMax(int[] chosenMonthSteps) {
        int maxSteps = 0;
        for (int i = 0; i < chosenMonthSteps.length; i++) {
            if (chosenMonthSteps[i] > maxSteps) {
                maxSteps = chosenMonthSteps[i];
            }
        }
        return maxSteps;
    }

    // Поиск лучшей серии шагов в месяце
    static int findBestStepsSeries(int[] chosenMonthSteps, int stepsGoal) {
        int daysCount = 0;
        int maxCount = 0;
        for (int i = 0; i < chosenMonthSteps.length; i++) {
            if (chosenMonthSteps[i] >= stepsGoal) {
                daysCount = daysCount + 1;
                if (maxCount < daysCount) {
                    maxCount = daysCount;
                }
            } else {
                daysCount = 0;
            }
        }
        return maxCount;
    }

    // Метод chooseMonth отвечает за выбор месяца пользователем
    static int[] chooseMonth(Scanner scanner, int[][] steps) {
        int month = scanner.nextInt();
        while((month < 1) || (month > 12)) {
            System.out.println("Ошибка, повторите ввод: ");
            month = scanner.nextInt();
        }
        int[] chosenMonth = new int[steps[0].length];
        for (int i = 0; i < steps.length; i++) {
            if (i == month - 1) {
                for (int j = 0; j < steps[0].length; j++) {
                    chosenMonth[j] = steps[i][j];
                }
            }
        }
        return chosenMonth;
    }

    // Метод изменения цели по шагам
    static int changeStepsGoal(Scanner scanner, int stepsGoal) {
        System.out.println("Введите новую цель по шагам: ");
        stepsGoal = scanner.nextInt();
        while (stepsGoal < 0) {
            System.out.println("Ошибка, введите положительное значение: ");
            stepsGoal = scanner.nextInt();
        }
        System.out.println("Новая цель по шагам: " + stepsGoal);
        return stepsGoal;
    }

}