import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod ) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);

        return makePercent(pay, 2);
}

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return makePercent(amount+amount * yearRate *depositPeriod, 2);
}

    double makePercent(double value, int grade) {
        double valueInPow = Math.pow(10, grade);

        return Math.round(value * valueInPow) / valueInPow;
}

    void calculateTheBid( ) {
        int depositPeriod, count ;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:") ;
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        depositPeriod = scanner.nextInt( );
        System.out.println ( "Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:") ;
        count = scanner.nextInt();
        double depositResult = 0;
        if (count == 1) {
            depositResult = calculateSimplePercent(amount, 0.06, depositPeriod);
        } else if (count == 2) {
            depositResult = calculateComplexPercent(amount, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + amount + " за " + depositPeriod + " лет превратятся в " + depositResult);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateTheBid();
}

}
