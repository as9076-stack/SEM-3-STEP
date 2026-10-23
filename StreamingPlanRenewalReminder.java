import java.util.Scanner;
import java.time.LocalDate;

abstract class Subscription {
    String name;
    LocalDate startDate;

    Subscription(String name, String startDate) {
        this.name = name;
        this.startDate = LocalDate.parse(startDate);
    }

    abstract int getValidityDays();

    LocalDate calculateRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class Basic extends Subscription {
    Basic(String name, String date) {
        super(name, date);
    }

    int getValidityDays() {
        return 30;
    }
}

class Standard extends Subscription {
    Standard(String name, String date) {
        super(name, date);
    }

    int getValidityDays() {
        return 90;
    }
}

class Premium extends Subscription {
    Premium(String name, String date) {
        super(name, date);
    }

    int getValidityDays() {
        return 365;
    }
}

public class StreamingPlanRenewalReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            String date = sc.next();
            Subscription s;

            switch (type) {
                case "BASIC":
                    s = new Basic(name, date);
                    break;
                case "STANDARD":
                    s = new Standard(name, date);
                    break;
                case "PREMIUM":
                    s = new Premium(name, date);
                    break;
                default:
                    continue;
            }

            System.out.printf("%s: %s%n",
                    name, s.calculateRenewalDate());
        }

        sc.close();
    }
}
