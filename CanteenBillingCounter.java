import java.util.Scanner;

abstract class Customer {
    double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract double calculateFinalAmount();
}

class Student extends Customer {
    Student(double amount) {
        super(amount);
    }

    double calculateFinalAmount() {
        return amount * 0.90;
    }
}

class Staff extends Customer {
    Staff(double amount) {
        super(amount);
    }

    double calculateFinalAmount() {
        return amount * 0.95;
    }
}

class Guest extends Customer {
    Guest(double amount) {
        super(amount);
    }

    double calculateFinalAmount() {
        return amount + 10;
    }
}

public class CanteenBillingCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Customer c;

            switch (type) {
                case "STUDENT": c = new Student(amount); break;
                case "STAFF": c = new Staff(amount); break;
                case "GUEST": c = new Guest(amount); break;
                default: continue;
            }

            double result = c.calculateFinalAmount();
            System.out.printf("%s: %.2f%n", type, result);
            total += result;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
