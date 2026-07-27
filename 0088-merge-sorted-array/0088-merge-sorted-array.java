class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointers for the end of valid elements in nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        
        // Pointer for the last position in nums1
        int p = m + n - 1;

        // Fill nums1 starting from the end
        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
    }
}