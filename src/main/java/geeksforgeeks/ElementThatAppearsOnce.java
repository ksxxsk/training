package geeksforgeeks;

/**
 * Given an array where every element occurs three times, except one element which occurs only once. Find the element
 * that occurs once. Expected time complexity is O(n) and O(1) extra space. Examples:
 * <p>
 * Input: arr[] = {12, 1, 12, 3, 12, 1, 1, 2, 3, 3} Output: 2
 */
public class ElementThatAppearsOnce {

    public static int appearsOnceAmongThreeTimes(int[] array) {

        int once = 0;
        int twice = 0;
        for (int number : array) {

            once = (once ^ number) & ~twice;
            twice = (twice ^ number) & ~once;
        }

        return once;
    }

    public static int appearsOnceSumBits(int[] array, int no) {
        int result = 0;
        for (int i = 0; i < 32; i++) {

            int x = 1 << i;
            int count = 0;
            for (int number : array)
                if ((number & x) != 0)
                    count++;

            if (count % no == 1)
                result |= x;
        }
        return result;
    }
}
