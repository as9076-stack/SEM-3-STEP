import java.util.Scanner;

interface Transport {
    double transportFee();
}

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateFee();
}

class DayScholar extends Student implements Transport {
    DayScholar(String name) {
        super(name);
    }

    public double transportFee() {
        return 12000;
    }

    double calculateFee() {
        return 40000 + transportFee();
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double calculateFee() {
        return 40000 + 60000;
    }
}

class Scholar extends Student implements Transport {
    Scholar(String name) {
        super(name);
    }

    public double transportFee() {
        return 12000;
    }

    double calculateFee() {
        return 20000 + transportFee();
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student s;

            switch (type) {
                case "DAY_SCHOLAR":
                    s = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    s = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    s = new Scholar(name);
                    break;
                default:
                    continue;
            }

            double fee = s.calculateFee();
            System.out.printf("%s: %.2f%n", name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}
