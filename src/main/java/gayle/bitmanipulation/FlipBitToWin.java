package gayle.bitmanipulation;

/**
 * You have an integer and you can flip exactly one bit from a 13 to a 1. Write code to
 find the length of the longest sequence of ls you could create.
 EXAMPLE
 Input: 1775 (or: 111011101111)
 Output: 8
 Hints: #159, #226, #314, #352
 */
public class FlipBitToWin {

    public static int countOnes(int number) {
        String num = Integer.toBinaryString(number);
        int max = -1;
        int count =0;
        int zero = 0;
        while(number != 0) {
            if ((number & 1) == 1) {
                count++;
            }
            else if ((number & 1) == 0) {
                if (zero > 0) {
                    if(count > max) {
                        max = count;
                    }
                    count = 0;
                    zero = 0;
                } else {
                    count++;
                    zero++;
                }

            }
            number >>= 1;
        }
        if(count > max)
            max = count;

        return max;
    }

    public static int countOnes2(int number) {
        String num = Integer.toBinaryString(number);
        int max = 0;
        int current = 0;
        int previous = 0;
        while (number != 0) {
            if((number & 1) == 1) {
                current++;
            } else {
                previous = ( (number & 2) == 2 ) ? current : 0;
                current = 0;
            }
            max = Math.max(max, current + previous + 1);
            number >>= 1;
        }

        return max;
    }
}
