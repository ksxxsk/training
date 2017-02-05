package gayle.bitmanipulation;

/**
 * Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, print
 the binary representation. If the number cannot be represented accurately in binary with at most 32
 characters, print "ERROR:'
 Hints: #143, #167, #173, #269, #297
 */
public class BinaryToString {

    public String conversion(double num) {
        StringBuilder binary = new StringBuilder();
        while (num > 0) {
            if(binary.length() >= 32)
                return "ERROR";

            double r = num * 2;
            if(r >= 1) {
                binary.append(1);
                num -= 1;
            } else {
                binary.append(0);
                num = r;
            }
        }

        return binary.toString();
    }
}
