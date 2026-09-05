package string.class_problems;
import java.util.Scanner;
public class BankTransactionReferenceGenerator {
    


    
    static String normalizeReference(String raw) {

        
        String reference = raw.trim();

       
        String bankCode = reference.substring(0, 3).toUpperCase();

        
        String remaining = reference.substring(3);

        return bankCode + remaining;
    }

    
    static String validateAndFormat(String reference) {

       
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        
        for (int i = 3; i < reference.length(); i++) {

            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must be digits";
            }
        }

        
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        sb.append(reference.substring(0, 3));
        sb.append("] DATE: ");
        sb.append(reference.substring(3, 9));
        sb.append(" | SEQ: ");
        sb.append(reference.substring(9));

        return sb.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter transaction reference: ");
        String raw = sc.nextLine();

        String normalized = normalizeReference(raw);

        System.out.println(validateAndFormat(normalized));

        sc.close();
    }

    
}
