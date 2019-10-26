package medium.permutations;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helper(nums, 0, list);
        return list;
    }

    private void helper(int[] nums, int l, List<List<Integer>> list) {

        // terminating condition
        if (l == nums.length-1) {
            List<Integer> lst = new ArrayList<>();
            for (int n : nums) {
                lst.add(n);
            }
            list.add(lst);
            return;
        }

        for (int i = l; i <= nums.length-1; i++) {
            swap(nums, l, i);
            helper(nums, l + 1, list);
            swap(nums, l, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
