public class Converter {

    // Количество пройденных километров
    // 1 шаг = 75 см
    public double convertDistance (int iStepCount) {
        final double cnst = 0.75 / 1_000;
        double dStepCount = Double.valueOf(iStepCount);
        return dStepCount * cnst;
    }

    // Количество сожжённых килокалорий
    // 1 шаг = 50 калорий, 1 килокалория = 1 000 калорий
    public double convertCalories (int iStepCount) {
        final double cnst = 50.0 / 1_000;
        double dStepCount = Double.valueOf(iStepCount);
        return dStepCount * cnst;
    }
}