import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;

        // 1. Sort the array
        Arrays.sort(nums);
        int n = nums.length;

        // 2. Loop for the 1st number
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates

            // 3. Loop for the 2nd number
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // Skip duplicates

                // 4. Two pointers for 3rd and 4th numbers
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    // Use long to avoid integer overflow
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Skip duplicates for 3rd and 4th numbers
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++; // Need a larger sum
                    } else {
                        right--; // Need a smaller sum
                    }
                }
            }
        }

        return result;
    }
}