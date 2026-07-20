class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int n = nums.length;

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            long required = prefix[i] + target;

            int left = i + 1;
            int right = n;
            int idx = -1;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (prefix[mid] >= required) {
                    idx = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (idx != -1) {
                ans = Math.min(ans, idx - i);
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}