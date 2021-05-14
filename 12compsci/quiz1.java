import java.util.Scanner;

public class quiz1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Number of Tickets: ");
        int tickets = sc.nextInt();
        System.out.print("Ticket Price: $");
        float price = sc.nextFloat();
        double finalPrice = tickets * price;

        if (tickets >= 10) {
            finalPrice -= 2;
        }

        System.out.printf("You received " + tickets + " tickets for $%1.2f", finalPrice);
    }
}