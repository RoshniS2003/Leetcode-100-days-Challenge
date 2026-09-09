class Solution {
    // public void moveZeroes(int[] nums) {
    //     int result[] = new int [nums.length];
    //     int j = 0;

    //     for(int i = 0; i < nums.length; i++){
    //         if( nums[i] != 0){
    //             result [j] = nums[i];
    //             j++;
    //         }
    //     }

    //     for(int k = 0; k < result.length; k++){
    //         nums[k] = result[k];
    //     }
    // }
    public void moveZeroes(int[] nums) {
        int left = 0;

        for(int right = 0; right < nums.length; right++){
            if(nums[right] != 0){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;

                left++;
            }
            
        }
    }
}