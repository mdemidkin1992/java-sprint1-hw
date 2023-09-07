public class Converter {
    double STEP_SIZE = 0.00075;
    double CALORIES_IN_STEP = 50;
    double CALORIES_IN_K_CAL = 1_000;

    public double convertDistance (long stepCount) {
        return stepCount * STEP_SIZE;
    }

    public double convertCalories (long stepCount) {
        return stepCount * CALORIES_IN_STEP / CALORIES_IN_K_CAL;
    }
}