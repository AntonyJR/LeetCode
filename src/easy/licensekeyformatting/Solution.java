package easy.licensekeyformatting;

class Solution {
    public String licenseKeyFormatting(String S, int K) {
        int k=K;
        int sLen = S.length();
        StringBuffer buff = new StringBuffer(sLen+sLen/4+1);
        for (int i=sLen-1; i>=0; i--) {
            char c=S.charAt(i);
            if (c!='-') {
                if (k==0) {
                    buff.append('-');
                    k=K;
                }
                buff.append(Character.toUpperCase(c));
                k--;
            }
        }
        return buff.reverse().toString();
    }
}
