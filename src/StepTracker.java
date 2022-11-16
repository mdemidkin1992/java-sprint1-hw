import java.util.Scanner;

public class StepTracker {

    MonthData[] monthData;
    Converter converter = new Converter();

    public StepTracker() {
        monthData = new MonthData[12];
        for (int i = 0; i < monthData.length; i++) {
            monthData[i] = new MonthData();
        }
    }

    // Считываем ввод пользователя по шагам за день
    public void getSteps(Scanner scanner) {

        // Ввод данных пользователем с учетом допустимых диапазонов
        System.out.println("Введите месяц от 1 до 12:");
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

        monthData[month].steps[day - 1] = stepsPerDay;
    }

    // Выводим статистику по шагам (в этом методе вызываем другие)

    public void printStatistics(Scanner scanner, int stepsGoal) {
        System.out.println("Введите месяц от 1 до 12:");
        int month = scanner.nextInt();
        while ((month < 1) || (month > 12)) {
            System.out.println("Ошибка, повторите ввод:");
            month = scanner.nextInt();
        }

        printSteps(month);

        System.out.println("\nВаша статистика за выбранный месяц");
        System.out.println("  Среднее количество шагов в день: " + findStepsAverage(month));
        System.out.println("  Общее количество шагов за месяц: " + findStepsTotal(month));
        System.out.println("  Максимальное пройденное количество шагов в месяце: " + findStepsMax(month));
        System.out.println("  Лучшая серия шагов в месяце: " + findBestStepsSeries(month, stepsGoal));
        System.out.println("  Пройденная дистанция (в км): " + converter.convertDistance(findStepsTotal(month)));
        System.out.println("  Количество сожжённых килокалорий: " + converter.convertCalories(findStepsTotal(month)));
    }

    // Печатаем кол-во пройденных шагов по дням
    public void printSteps(int month) {
        for (int i = 0; i < monthData.length; i++) {
            if (month == (i-1)) {
                for (int j = 0; j < monthData[month].steps.length; j++) {
                    System.out.print((j+1) + " день: " + monthData[month].steps[j] + ", ");
                }
            }
        }
    }

    // Считаем сумму пройденных шагов
    public int findStepsTotal(int month) {
        int stepsTotal = 0;
        for (int i = 0; i < monthData[month].steps.length; i++) {
            stepsTotal += monthData[month].steps[i];
        }
        return stepsTotal;
    }

    // Считаем максимальное количество шагов
    public int findStepsMax(int month) {
        int maxSteps = 0;
        for (int i = 0; i < monthData[month].steps.length; i++) {
            if (monthData[month].steps[i] > maxSteps) {
                maxSteps = monthData[month].steps[i];
            }
        }
        return maxSteps;
    }

    // Считаем среднее количество шагов
    public int findStepsAverage (int month) {
        return findStepsTotal(month) / monthData[month].steps.length;
    }

    // Поиск лучшей серии шагов в месяце
    public int findBestStepsSeries(int month, int stepsGoal) {
        int daysCount = 0;
        int maxCount = 0;
        for (int i = 0; i < monthData[month].steps.length; i++) {
            if (monthData[month].steps[i] >= stepsGoal) {
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

    // Метод изменения цели по шагам
    public int changeStepsGoal(Scanner scanner) {
        System.out.println("Введите новую цель по шагам: ");
        int stepsGoal = scanner.nextInt();
        while (stepsGoal < 0) {
            System.out.println("Ошибка, введите положительное значение: ");
            stepsGoal = scanner.nextInt();
        }
        System.out.println("Новая цель по шагам: " + stepsGoal);
        return stepsGoal;
    }

}

class MonthData {
    int[] steps = new int[30];
}
