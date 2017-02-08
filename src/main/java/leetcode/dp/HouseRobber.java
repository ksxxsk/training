package leetcode.dp;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
 * stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of
 * money you can rob tonight without alerting the police.
 */
public class HouseRobber {

    /**
     * For a given house i-th we need to pick max value when 1) we rob this house 2) we don't rob this house
     * 1) we take value from this house plus optimal value from previous houses without adjacent num[i] + fun(i-2)
     * 2) we take optimal value from other houses (including adjacent) fun(i-1)
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] value = new int[nums.length];
        value[0] = nums[0];
        if(nums.length > 1)
            value[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            value[i] = Math.max(nums[i] + value[i - 2], value[i-1]);
        }

        return value[nums.length - 1];
    }

    public int robWithoutExtraSpace(int[] nums) {
        if(nums == null | nums.length == 0)
            return 0;

        int ifRobbedPrevious = 0; 	// max monney can get if rob current house
        int ifDidntRobPrevious = 0; // max money can get if not rob current house
        for(int n: nums) {
            // If we rob current cell, previous cell shouldn't be robbed. So, add the current value to previous one.
            int currRobbed = ifDidntRobPrevious + n;

            // If we don't rob current cell, then the count should be max of the previous cell robbed and not robbed
            int currNotRobbed = Math.max(ifDidntRobPrevious, ifRobbedPrevious);

            // Update values for the next round
            ifDidntRobPrevious  = currNotRobbed;
            ifRobbedPrevious = currRobbed;
        }

        return Math.max(ifRobbedPrevious, ifDidntRobPrevious);
    }

    public static void main(String[] args) {
        new HouseRobber().rob(new int[]{2,1,1,1});
    }
}
