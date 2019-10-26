package easy.twosum;

import java.util.Map;
import java.util.HashMap;


class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> targets = new HashMap(nums.length);
        targets.put(target-nums[0], 0);
        for (int i=1; i< nums.length; i++) {
            if (targets.containsKey(nums[i])) {
                return new int[]{targets.get(nums[i]), i};
            }
            targets.put(target-nums[i], i);
        }
        return null;
    }
}