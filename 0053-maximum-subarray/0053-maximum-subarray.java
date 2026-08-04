class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Decide to add current element to existing sum OR start fresh from current element
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // Keep track of the highest sum seen so far
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}