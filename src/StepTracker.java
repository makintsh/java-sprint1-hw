import java.util.Scanner;

public class StepTracker {

    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];

    Converter converter = new Converter();

    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int numberOfMonth = scanner.nextInt();

        if (numberOfMonth < 1 || numberOfMonth >= 12) {
            System.out.println("Вы ввели не существующий месяц.");
            return;
        }
        System.out.println("Введите номер дня");
        int numberOfDay = scanner.nextInt();

        if (numberOfDay < 1 || numberOfDay > 30) {
            System.out.println("Вы ввели не существующий день.");
            return;
        }

        System.out.println("Введите количество шагов");
        int steps = scanner.nextInt();
        System.out.println("Количество шагов сохранено.");

        MonthData monthData = monthToData[numberOfMonth - 1];
        monthData.days[numberOfDay - 1] = steps;

    }


    void changeStepGoal() {
        System.out.println("Введите цель шагов на день.");
        goalByStepsPerDay = scanner.nextInt();


    }

    void printStatistic() {
        System.out.println("Введите число месяца");
        int numberOfMonth = scanner.nextInt();
        if (numberOfMonth < 1 || numberOfMonth > 12) {
            System.out.println("Вы ввели не существующий месяц");
            return;
        }
        MonthData monthData = monthToData[numberOfMonth - 1];
        int sumSteps = monthData.sumStepsFromMonth();

        System.out.println();
        monthData.printDaysAndStepsFromMonth();
        System.out.println();
        System.out.println("Максимальное количество шагов за месяц: " + monthData.maxSteps());
        System.out.println();
        System.out.println("Среднее количество шагов за месяц " + sumSteps / monthData.days.length);
        System.out.println();
        System.out.println("Дистанция пройденная за месяц: " + converter.convertToKm(sumSteps) + " КМ.");
        System.out.println();
        System.out.println("Количества сожжённых килокалорий за месяц: " + converter.convertStepsToKilocalories(sumSteps));
        System.out.println();
        System.out.println("Лушая серия: " + monthData.bestSeries(goalByStepsPerDay));

    }

}





