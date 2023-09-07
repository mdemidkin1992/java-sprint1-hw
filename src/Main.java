import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        int stepsGoal = 10_000;

        while (true) {
            printMenu();
            int userInput = scanner.nextInt();

            if (userInput == 1) {
                stepTracker.getSteps();
            } else if (userInput == 2) {
                stepTracker.printStatistics(stepsGoal);
            } else if (userInput == 3) {
                stepsGoal = stepTracker.changeStepsGoal();
            } else if (userInput == 4) {
                System.out.println("Выход из приложения");
                break;
            } else {
                System.out.println("Такой команды пока нет");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Выберите действие: " + "\n" +
                "1. Ввести количество шагов за определённый день;" + "\n" +
                "2. Напечатать статистику за определённый месяц;" + "\n" +
                "3. Изменить цель по количеству шагов в день;" + "\n" +
                "4. Выйти из приложения.");
    }
}