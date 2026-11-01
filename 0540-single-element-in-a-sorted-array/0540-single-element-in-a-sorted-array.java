class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        
        // Edge cases
        if (n == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];
        
        int low = 1, high = n - 2;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Check if mid is the single element
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            
            // Decide whether to shrink left or right
            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) || 
                (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
                low = mid + 1; // Single element is on the right
            } else {
                high = mid - 1; // Single element is on the left
            }
        }
        
        return -1;
    }
}