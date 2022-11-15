public class Converter {

    // Количество пройденных километров
    // 1 шаг = 75 см
    static double convertDistance (int stepCount) {
        double stepsInSm = stepCount; // конвертируем тип int в double
        return stepsInSm * 0.75 / 1000;
    }

    // Количество сожжённых килокалорий
    // 1 шаг = 50 калорий, 1 килокалория = 1 000 калорий
    static double convertCalories (int stepCount) {
        double stepsInSm = stepCount; // конвертируем тип int в double
        return stepsInSm * 50 / 1000;
    }
}