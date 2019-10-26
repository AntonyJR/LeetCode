package medium.minimumsizesubarraysum;

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum =0;
        int rst = Integer.MAX_VALUE;
        for (int i = 1, j = 0; i <= nums.length; i++) {
            if (nums[i-1] >= s)
                return 1;
            sum += nums[i-1];
            if (sum >= s) {
                while (sum - nums[j] >= s)
                    sum -= nums[j++];
                rst = Math.min(rst, i-j);
            }
        }

        return rst == Integer.MAX_VALUE ? 0 : rst;

    }
}
