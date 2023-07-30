public class Converter {
    double step = 75 / 100000.0;
    double kkPerStep = 50 / 1000.0;

    int convertToKm(int steps) {
        return (int) (steps * step);

    }

    int convertStepsToKilocalories(int steps) {
        return (int) (steps * kkPerStep);

    }
}
