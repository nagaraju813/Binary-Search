
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int left = 0, right = nums[n - 1] - nums[0];

        while (left < right) {
            int mid = (left + right) / 2;
            int count = countPairs(nums, mid);

            if (count >= k) {
                right = mid; // Try a smaller distance
            } else {
                left = mid + 1; // Need a bigger distance
            }
        }

        return left;
    }

    // Count of pairs with distance <= guess
    private int countPairs(int[] nums, int guess) {
        int count = 0;
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && nums[j] - nums[i] <= guess) {
                j++;
            }
            count += j - i - 1; // (j - i - 1) pairs with i as the left index
        }

        return count;
    }
}
