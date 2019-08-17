import java.util.Arrays;

// 16. 3Sum Closest
// Given an array nums of n integers and an integer target, 
// find three integers in nums such that the sum is closest to target. 
// Return the sum of the three integers. 
// You may assume that each input would have exactly one solution.

// Example:
// Given array nums = [-1, 2, 1, -4], and target = 1.
// The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int rst=0;
        if(n<=3){
            for(int num:nums){
                rst += num;
            }
            return rst;
        }

        Arrays.sort(nums);
        rst = nums[0]+nums[1]+nums[n-1];
        for (int i = 0; i < n-2; i++) {
            int j = i + 1;
            int k = n - 1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==target){
                    return sum;
                }else if(sum>target){
                    k--;
                }else{
                    j++;
                }
                if(Math.abs(sum-target)<Math.abs(rst-target)){
                    rst = sum;
                }
            }
        }
        return rst;
    }
    public static void main(String[] args) {
        ThreeSumClosest solu = new ThreeSumClosest();
        int[] nums = {-1, 2, 1, -4};
        int target=1;
        int rst = solu.threeSumClosest(nums, target);
        System.out.println(rst);
    }
}