class Solution {
    public int countQuadruplets(int[] nums) {  
        int count=0;  //개수 저장
        
        for(int d=3; d<nums.length; d++){
            for(int c=2; c<d; c++){
            for(int b=1; b<c; b++){
                for(int a=0; a<b;a++){
                    if(nums[a]+nums[b]+nums[c]==nums[d]){
                        count++;
                    }
                }
            }
        }
        }
        
        
        return count;
    }
}