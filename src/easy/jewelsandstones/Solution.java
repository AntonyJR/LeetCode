package easy.jewelsandstones;

class Solution {
    public int numJewelsInStones(String J, String S) {
        int lastStone = 'z';
        int firstStone = 'A';
        boolean[] jewels = new boolean[1+lastStone-firstStone];
        for (char j : J.toCharArray())
            jewels[j-firstStone] = true;
        int count = 0;
        for (char s : S.toCharArray())
            if (jewels[s - firstStone])
                count++;
        return count;
    }
}
