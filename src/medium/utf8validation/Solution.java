package medium.utf8validation;

class Solution {
    public boolean validUtf8(int[] data) {
        int i = 0;
        while (i < data.length) {
            int remaining;
            int current = data[i++];
            int prefix4 = 0xF0;
            int match1 = 0x80;
            int prefix1 = 0x00;
            int match2 = 0xE0;
            int prefix2 = 0xC0;
            int match3 = 0xF0;
            int prefix3 = 0xE0;
            int match4 = 0xF8;
            if ((current& match4) == prefix4)
                remaining = 3;
            else if ((current& match3) == prefix3)
                remaining = 2;
            else if ((current& match2) == prefix2)
                remaining = 1;
            else if ((current& match1) == prefix1)
                remaining = 0;
            else
                return false;
            int continuationmatch = 0xc0;
            int continuation = 0x80;
            while (remaining-- > 0)
                if (i==data.length || (data[i++]& continuationmatch) != continuation)
                    return false;
        }
        return true;
    }
}
