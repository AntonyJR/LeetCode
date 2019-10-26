package hard.regularexpressionmatching;

class Solution {
    private boolean[][] tested;

    public boolean isMatch(String s, String p) {
        if (p == null || s == null)
            return false;
        char[] schars = s.toCharArray();
        char[] pchars = p.toCharArray();
        int pi = 0;
        int si = 0;
        tested = new boolean[schars.length+1][pchars.length+1];

        return isMatch2(schars, si, pchars, pi);
    }

    private boolean isMatch2(char[] schar, int si, char[] pchar, int pi) {
        // Seen before?
        if (tested[si][pi])
            return false;

        // Scan string
        if (si == schar.length && pi == pchar.length)
            return true;
        // look ahead
        if (pi+1 < pchar.length  && pchar[pi+1] == '*') {
            char currp = pchar[pi];
            pi += 2;
            do {
                if (isMatch2(schar, si, pchar, pi))
                    return true;
                tested[si][pi] = true;
                if (si == schar.length) {
                    tested[si][pi] = true;
                    return false;
                }
            }
            while (match(schar[si++], currp));
            tested[si-1][pi] = true;
            return false;
        }
        if (si == schar.length || pi == pchar.length) {
            tested[si][pi] = true;
            return false;
        }
        if (!match(schar[si++], pchar[pi++])) {
            tested[si-1][pi-1] = true;
            return false;
        }
        if (isMatch2(schar, si, pchar, pi))
            return true;
        tested[si][pi] = true;
        return false;
    }

    private boolean match(char sc, char pc) {
        return pc == '.' || sc == pc;
    }
}
