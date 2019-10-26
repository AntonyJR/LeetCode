package hard.interleavingstring;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int s1len = s1.length();
        int s2len = s2.length();
        int s3len = s3.length();
        int inlen = s1len+s2len;
        if (inlen != s3len)
            return false;
        if (s3len==0)
            return true;
        boolean[] prefix = new boolean[s2len+1];
        for (int i=0; i<s1len+1; i++) {
            for (int j=0; j<s2len+1; j++) {
                int k = i+j-1;
                if (i==0 && j==0)
                    prefix[j] = true;
                else if (i==0)
                    prefix[j] = prefix[k] && s2.charAt(k)==s3.charAt(k);
                else if (j==0)
                    prefix[j] = prefix[j] && s1.charAt(k)==s3.charAt(k);
                else
                    prefix[j] =
                            (prefix[j] && s1.charAt(i-1)==s3.charAt(k)) ||
                                    (prefix[j-1] && s2.charAt(j-1)==s3.charAt(k));
            }
        }
        return prefix[s2len];
    }
}
