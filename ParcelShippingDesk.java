import java.util.Scanner;

interface Insurable {
    double calculateInsurance();
}

abstract class Parcel {
    double weight;
    double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double calculateCharge();

    double calculateInsurance() {
        return 0.0;
    }

    String getType() {
        return "";
    }

    double calculateTotal() {
        return calculateCharge() + calculateInsurance();
    }
}

class StandardParcel extends Parcel {
    StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double calculateCharge() {
        return 40 + 10 * weight;
    }

    String getType() {
        return "STANDARD";
    }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double calculateCharge() {
        return 80 + 15 * weight;
    }

    public double calculateInsurance() {
        return declaredValue * 0.02;
    }

    String getType() {
        return "EXPRESS";
    }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double calculateCharge() {
        return 40 + 10 * weight + 50;
    }

    public double calculateInsurance() {
        return declaredValue * 0.02;
    }

    String getType() {
        return "FRAGILE";
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            Parcel parcel;

            switch (type) {
                case "STANDARD":
                    parcel = new StandardParcel(weight, value);
                    break;

                case "EXPRESS":
                    parcel = new ExpressParcel(weight, value);
                    break;

                case "FRAGILE":
                    parcel = new FragileParcel(weight, value);
                    break;

                default:
                    continue;
            }

            double charge = parcel.calculateCharge();
            double insurance = parcel.calculateInsurance();
            double total = parcel.calculateTotal();

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                parcel.getType(), charge, insurance, total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}
