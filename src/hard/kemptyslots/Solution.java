package hard.kemptyslots;

class Solution {
    public int kEmptySlots(int[] bulbs, int K) {
        boolean[] onBulb = new boolean[bulbs.length];
        int k=K+1;
        onBulb[bulbs[0]-1]=true;
        for (int i=1; i<bulbs.length-K; i++) {
            boolean prevBulb=false;
            boolean lastBulb=false;
            int bulb = bulbs[i]-1;
            onBulb[bulb] = true;
            if (bulb-k > -1)
                prevBulb = onBulb[bulb-k];
            if (bulb+k < bulbs.length)
                lastBulb = onBulb[bulb+k];
            boolean found = false;
            if (prevBulb) {
                for (int j=bulb-K; j<bulb; j++) {
                    found = onBulb[j];
                    if (found)
                        break;
                }
                if (!found) return i+1;
            }
            found = false;
            if (lastBulb) {
                for (int j=bulb+1; j<bulb+k; j++) {
                    found = onBulb[j];
                    if (found)
                        break;
                }
                if (!found) return i+1;
            }
        }
        return -1;
    }
}
