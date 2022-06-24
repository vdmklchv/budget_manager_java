package budget;

import java.util.*;

public class Screen {
    void printEntries(List<Entry> entries) {
        for (Entry entry: entries) {
            System.out.println(entry.toString());
        }
    }

    void printTotal(double total) {
        System.out.printf("Total sum: $%s", MoneyFormatter.format(total));
    }

    int obtainInteger() {
        Scanner scanner = new Scanner(System.in);
        int number = -1;
        while (number < 0) {
            try {
                number = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please provide a number");
            }
        }
        return number;
    }

    private double obtainDouble() {
        Scanner scanner = new Scanner(System.in);
        double number = -1;
        while (number < 0) {
            try {
                number = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please provide a number");
            }
        }
        return number;
    }

    double getIncome() {
        System.out.println("Enter income:");
        return obtainDouble();
    }

    String getPurchaseName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter purchase name:");
        return scanner.nextLine();
    }

    double getPurchaseCost() {
        System.out.println("Enter its price:");
        return obtainDouble();
    }

    void showBalance(double balance) {
        System.out.printf("Balance: $%s\n", MoneyFormatter.format(balance));
        System.out.println();
    }

    int getPurchaseCategoryNumber() {
        return obtainInteger();
    }
}
