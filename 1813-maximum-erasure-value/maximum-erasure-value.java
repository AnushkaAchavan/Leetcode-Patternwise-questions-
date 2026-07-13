class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int sum =0;
        int maxSum=0;
        int i=0;
        int j=0;
        for(int end=0;end<nums.length;end++){
            while(j<nums.length){
                if(!set.contains(nums[j])){
                    set.add(nums[j]);
                    sum += nums[j];

                    maxSum = Math.max(maxSum,sum);
                    j++;
                }
                else{
                    set.remove(nums[i]);
                    sum -= nums[i];
                    i++;
                }

            }

        }
        return maxSum;
    }
}