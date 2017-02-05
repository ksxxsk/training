package hackerrank.bitmanipulation;

import java.util.Arrays;
import java.util.Scanner;


public class LonelyInteger {

    private static int lonelyInteger(int[] a) {
        return Arrays.stream(a).reduce(0, (i, j) -> i ^ j);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(lonelyInteger(a));
    }
}
