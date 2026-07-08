class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
     return atMost(nums, k) - atMost(nums, k - 1);
    }
    private int atMost(int[] nums, int k) {
        int start = 0;
        int odd = 0;
        int count = 0;

        for (int end = 0; end < nums.length; end++) {

            if (nums[end] % 2 != 0)
                odd++;

            while (odd > k) {
                if (nums[start] % 2 != 0)
                    odd--;

                start++;
            }

            count += end - start + 1;
        }

        return count;
    }
}