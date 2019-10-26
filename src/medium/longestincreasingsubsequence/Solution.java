package medium.longestincreasingsubsequence;

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums==null || nums.length==0)
            return 0;
        int[] longest = new int[nums.length+1];
        int maxlength = 1;
        longest[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            int current = nums[i];
            // Check if larger than end of longest sequence
            if (current > longest[maxlength-1]) {
                longest[maxlength++] = current;
                continue;
            }
            // Check if smaller than shortest sequence
            if (current < longest[0]) {
                longest[0] = current;
                continue;
            }
            for (int j=1; j<maxlength; j++) {
                if (current < longest[j] && current > longest[j-1]) {
                    longest[j] = current;
                    break;
                }
            }
        }
        return maxlength;
    }
}
