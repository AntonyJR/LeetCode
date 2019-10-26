package easy.reverseinteger;

class Solution {
    public int reverse(int x) {
        int max_val = Integer.MAX_VALUE / 10;
        int min_val = Integer.MIN_VALUE / 10;
        int retval = 0;
        while (x != 0) {
            if (x < 10)
                if (retval > max_val || retval < min_val)
                    return 0;
            retval = 10 * retval + ( x % 10 );
            x /= 10;
        }
        return retval;
    }
}