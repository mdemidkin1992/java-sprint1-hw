import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int daysPerMonth = 12;
        int monthsPerYear = 30;
        int[][] steps = new int[daysPerMonth][monthsPerYear];
        int stepsGoal = 10000;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int userInput = scanner.nextInt();

            if (userInput == 1) {
                StepTracker.getSteps(scanner, steps);
            } else if (userInput == 2) {
                StepTracker.printStatistics(scanner, steps, stepsGoal);
            } else if (userInput == 3) {
                stepsGoal = StepTracker.changeStepsGoal(scanner, stepsGoal);
            } else if (userInput == 4) {
                System.out.println("Выход из приложения");
                break;
            } else {
                System.out.println("Такой команды пока нет");
            }

        }

    }

        // Метод вызова меню
        public static void printMenu() {
            System.out.println("Выберите действие: " + "\n" +
                    "1. Ввести количество шагов за определённый день;" + "\n" +
                    "2. Напечатать статистику за определённый месяц;" + "\n" +
                    "3. Изменить цель по количеству шагов в день;" + "\n" +
                    "4. Выйти из приложения.");
        }
}
