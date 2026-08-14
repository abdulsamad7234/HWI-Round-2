class Solution {
    public boolean predictTheWinner(int[] nums) {
        int[] result = helper(nums, 0, nums.length - 1);

        int player1 = result[0];
        int player2 = result[1];

        return player1 >= player2;
    }

    // returns {current player's score, other player's score}
    public int[] helper(int[] nums, int i, int j) {

        // Only one element
        if (i == j) {
            return new int[]{nums[i], 0};
        }

        // ---------------- LEFT PICK ----------------
        int[] left = helper(nums, i + 1, j);

        int leftScore = nums[i] + left[1];
        int leftOtherScore = left[0];


        // ---------------- RIGHT PICK ----------------
        int[] right = helper(nums, i, j - 1);

        int rightScore = nums[j] + right[1];
        int rightOtherScore = right[0];


        // Choose the option where current player gets more
        if (leftScore >= rightScore) {
            return new int[]{leftScore, leftOtherScore};
        } else {
            return new int[]{rightScore, rightOtherScore};
        }
    }
}