class Solution {
    // public int[] twoSum(int[] nums, int target) {
    //     int res [] = new int[2];
    //     int b[]= new int [2];
    //     boolean find = false;

    //     for(int i = 0; i< nums.length; i++){
            
    //         for(int j = i+1; j< nums.length; j++){
    //             if(nums[i] + nums[j] == target){
    //                 res[0] = i;
    //                 res[1] =j;
    //                 return res;
                    
    //             }
                
    //         }
            
    //     }
    //     return b;
    // }

    
    public int[] twoSum(int[] nums, int target) {
        Map <Integer, Integer> map = new HashMap<>();

        for(int i = 0; i< nums.length; i++){
            int value = target - nums[i];

            if(map.containsKey(value)){
                return new int [] {map.get(value), i};
            }
            else{
                map.put(nums[i],i);
            }
        }

        return new int[] {0,0};
    }
}