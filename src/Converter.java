public class Converter {

    // iStepCount писал с i чтобы указать, что тип переменной int
    // далее через Double.valueOf() переводил тип int в double
    // Понял, что так не принято, не буду :)

    // поля класса Converter
    double STEP_SIZE = 0.00075; // км в шаге
    double CALORIES_IN_STEP = 50; // калорий в шаге
    double CALORIES_IN_K_CAL = 1_000; // калорий в килокалории

    // Количество пройденных километров
    public double convertDistance (long stepCount) {
        return stepCount * STEP_SIZE;
    }

    // Количество сожжённых килокалорий
    public double convertCalories (long stepCount) {
        return stepCount * CALORIES_IN_STEP / CALORIES_IN_K_CAL;
    }
}