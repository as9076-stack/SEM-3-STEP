
import java.util.*;

interface Payment {
    double calculateAmount(double amount);
    String getType();
}

class CardPayment implements Payment {
    public double calculateAmount(double amount) {
        return amount * 1.02;
    }

    public String getType() {
        return "CARD";
    }
}

class WalletPayment implements Payment {
    public double calculateAmount(double amount) {
        return amount * 1.01;
    }

    public String getType() {
        return "WALLET";
    }
}

class BankTransferPayment implements Payment {
    public double calculateAmount(double amount) {
        return amount;
    }

    public String getType() {
        return "BANKTRANSFER";
    }
}

public class PaymentSystemFeeCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");
            String type = input[0];
            double amount = Double.parseDouble(input[1]);

            Payment payment;

            switch (type) {
                case "CARD":
                    payment = new CardPayment();
                    break;
                case "WALLET":
                    payment = new WalletPayment();
                    break;
                default:
                    payment = new BankTransferPayment();
            }

            double adjusted = payment.calculateAmount(amount);
            System.out.printf("%s: %.2f%n", payment.getType(), adjusted);
            total += adjusted;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
