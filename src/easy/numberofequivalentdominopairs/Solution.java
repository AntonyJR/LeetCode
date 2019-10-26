package easy.numberofequivalentdominopairs;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        for (int[] domino : dominoes)
            if (domino[0] > domino[1]) {
                int temp = domino[0];
                domino[0] = domino[1];
                domino[1] = temp;
            }
        Arrays.sort(dominoes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] < b[0])
                    return -1;
                if (a[0] == b[0])
                    return a[1]-b[1];
                return 1;
            }
        });
        int count = 0;
        int pred = 0;
        for (int i=0; i<dominoes.length-1; i++) {
            if (dominoes[i][0] == dominoes[i+1][0] &&
                    dominoes[i][1] == dominoes[i+1][1])
                count += pred++ + 1;
            else
                pred = 0;
        }
        return count;
    }
}
