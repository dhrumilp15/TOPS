import java.util.Scanner;

public class quiz {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Greetings");
        int first = sc.nextInt();
        int sec = sc.nextInt();
        int third = sc.nextInt();
        int median;
        double mean = ((double) (first + sec + third)) / 3.0;

        System.out.printf("MEAN: %1.1f", mean);

    }
}