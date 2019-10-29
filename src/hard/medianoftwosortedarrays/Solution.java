package hard.medianoftwosortedarrays;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
// int count=10;
        int[] shorter;
        int[] longer;
        if (nums1.length < nums2.length) {
            shorter = nums1;
            longer = nums2;
        }
        else {
            shorter = nums2;
            longer = nums1;
        }
        int total_len = shorter.length + longer.length;
        int min_index = 0;
        int max_index = shorter.length;
        do {
            int sindex = (min_index + max_index) / 2;
            int lindex = (total_len + 1) / 2 - sindex;
// System.out.println("i="+Integer.toString(sindex)+" j="+Integer.toString(lindex)+" min="+Integer.toString(min_index)+" max="+Integer.toString(max_index));
            int sl = sindex > 0 ? shorter[sindex-1] : Integer.MIN_VALUE;
            int sr = sindex < shorter.length ? shorter[sindex ] : Integer.MAX_VALUE;
            int ll = lindex > 0 ? longer[lindex-1] : Integer.MIN_VALUE;
            int lr = lindex < longer.length ? longer[lindex] : Integer.MAX_VALUE;
// System.out.println("sl="+Integer.toString(sl)+" sr="+Integer.toString(sr)+" ll="+Integer.toString(ll)+" lr="+Integer.toString(lr));
            if (sl <= lr && ll <= sr) {
                if (total_len % 2 == 1)
                    return Math.max(sl, ll);
                else
                    return (Math.max(sl, ll) + Math.min(sr, lr)) / 2.0;
            }
            if (sl > lr)
                max_index = sindex - 1;
            else
                min_index = sindex + 1;
// if (--count < 1) return Integer.MIN_VALUE;
        } while (true);
    }

    public static void main(String args[]) {
        int[] n1 = { 3, 5, 10, 11, 17};
        int[] n2 = {9, 13, 20, 21,23, 27};
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(n1, n2));
        n1 = new int[] { 2, 3, 5, 8};
        n2 = new int[] {10, 12, 14, 16,18, 20};
        System.out.println(solution.findMedianSortedArrays(n1, n2));
    }
}
