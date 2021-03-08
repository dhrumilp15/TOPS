import java.util.Scanner;
import java.util.stream;
import java.lang.Math;

public class quiz2b {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

    }

    public static int getInt(int low, int high) {
        do {
            System.out.print("Sicko mode 1: ");
            int value = sc.nextInt();

        } while(value < low || value > high)
        return value;
    }

    public static void message(String string, int dashes) {
        System.out.println(string);
        for (int i = 0; i < dashes; i++) {
            System.out.print('=');
        }
    }

    public static double areaCircle(double radius) {
        return Math.pow(radius, 2) * Math.PI;
    }

    public static int sumRange(int low, int high) {
        int sum = 0;
        for (int i = low; i <= high; i++) {
            sum += i;
        }
        return sum;
    }

    public static int numFactors(int num) {
        int factors = 2; // Initialize as 1 and num
        for (int i = 2, i < Math.sqrt(num); i++) {
            if (num % i == 0)
                factors++;
        }
    }

    public static String category(int num) {
        if (num == 0) {
            return "zero";
        } else if (num > 0) {
            return "positive";
        } else {
            return "negative";
        }
    }

    public static int getRandom(int max) {
        return (int) (Math.random() * (max - 2)) + 2;
    }

}