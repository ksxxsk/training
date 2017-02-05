package geeksforgeeks.bitmanipulation;

public class TotalSetBitsInAllNumbersFrom1ToN {

    public static int naive(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++)
            sum += Integer.bitCount(i);

        return sum;
    }
}
