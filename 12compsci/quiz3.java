import java.util.Scanner;

public class quiz3 {

    public static void main(String[] args) {
        // repeat(4);
        System.out.print(fun(7));
    }

    public static void repeat(int N) {
        if (N > 0) {
            System.out.print("In: " + N);   
            repeat(N - 1);
        }
        System.out.println("Out: " + N);
    }

    public static int fun(int x) {
        if (x <= 1)
            return 1;
        return 3 * fun(x - 1) - fun(x - 2);
    }

}