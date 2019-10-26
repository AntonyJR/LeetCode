package medium.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> retval = new ArrayList<List<Integer>>();
        List<List<Integer>> retval = new ArrayList<List<Integer>>(nums.length*2);
//        List<List<Integer>> retval = new LinkedList<List<Integer>>();
//        Set<List<Integer>> retval = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        int ilimit = nums.length-2;
        for (int i=0; i<ilimit; i++) {
            int j=i+1,k=nums.length-1;
            int oldi = nums[i];
            while (j<k) {
                int oldj = nums[j];
                int oldk = nums[k];
                int sum = oldi+oldj+oldk;
                if (sum == 0) {
                    List<Integer> result = Arrays.asList(oldi, oldj, oldk);
                    retval.add(result);
                    do
                        j++;
                    while (j<k && nums[j] == oldj);
                    do
                        k--;
                    while (j<k && nums[k] == oldk);
                }
                else if (sum < 0) {
                    //do
                    j++;
                    //while (j<k && nums[j] == oldj);
                }
                else {
                    //do
                    k--;
                    //while (j<k && nums[k] == oldk);
                }
            }
            while (i<ilimit && oldi==nums[i+1]) i++;
        }
        return retval;
    }
}