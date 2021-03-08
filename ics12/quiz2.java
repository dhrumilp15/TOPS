import java.util.Scanner;
import java.lang.Math;

public class quiz2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int pairs = 0;
        int runs = 0;
        for (int i = 1; i <= 5; i++) {
            int pair1 = getRandom(5);
            int pair2 = getRandom(5);

            System.out.println("Round " + i + ": " + pair1 + " " + pair2);

            if (result(pair1, pair2) == 'p') {
                pairs += 1;
            } else if (result(pair1, pair2) == 'r') {
                runs += 1;
            }
        }
        System.out.println(pairs + " pairs and " + runs + " runs");
    }

    public static int getRandom(int max) {
        return (int) (Math.random() * (max - 2)) + 2;
    }

    public static char result(int a, int b) {
        if (a == b) {
            return 'p';
        } else if (a == b + 1 || a + 1 == b) {
            return 'r';
        } else {
            return 'd';
        }
    }
}