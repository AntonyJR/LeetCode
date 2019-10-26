package easy.maximumsubarray;

class Solution {
    public int maxSubArray(int[] nums) {
        int maxrun = nums[0];
        int lastrun = nums[0];
        for (int i=1; i<nums.length; i++) {
            boolean ispositive = nums[i] > -1;
            if (ispositive && lastrun < 0) {
                lastrun = nums[i];
            }
            else if (!ispositive && lastrun < nums[i]) {
                lastrun = nums[i];
            }
            else {
                lastrun += nums[i];
            }
            if (lastrun > maxrun)
                maxrun = lastrun;
        }
        return maxrun;
    }
}