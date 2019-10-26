package medium.stringtointegeratoi;

class Solution {
    public int myAtoi(String str) {
        char[] input = str.toCharArray();
        int i = 0;
        int retval = 0;
        int max_val = Integer.MAX_VALUE / 10;
        int max_last = Integer.MAX_VALUE % 10;
        int min_val = Integer.MIN_VALUE / 10;
        int min_last = Integer.MIN_VALUE % 10;

        // Skip whitespace
        while (i < input.length && input[i] == ' ')
            i++;

        if (i < input.length) {

            // Get sign, if any
            int sign = 1;
            if (input[i] == '+')
                i++;
            else if (input[i] == '-') {
                i++;
                sign = -1;
            }

            // Skip leading 0
            while (i < input.length && input[i] == '0')
                i++;

            // Scan remaining digits
            while (i < input.length) {

                // Get a digit
                int value = input[i++] - '0';
                if (value < 0 || value > 9)
                    break;
                value *= sign;

                // Check if exceeded capacity of int
                if (retval > max_val ||
                        (retval == max_val && value > max_last))
                    return Integer.MAX_VALUE;
                if (retval < min_val ||
                        (retval == min_val && value < min_last))
                    return Integer.MIN_VALUE;

                // Add to result
                retval = retval * 10 + value;
            }
        }
        return retval;
    }
}
