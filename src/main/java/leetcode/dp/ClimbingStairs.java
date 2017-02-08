package leetcode.dp;

import java.util.Arrays;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(4));
    }

    private int climbStairs(int n) {
        int[] mem = new int[n + 1];
        Arrays.fill(mem, -1);

        return climbStairs(n, mem);
    }

    public int climbStairs(int n, int[] mem) {
        if (n < 0)
            return 0;
        else if (n == 0)
            return 1;
        else if (mem[n] > -1)
            return mem[n];
        else {
            mem[n] = climbStairs(n - 1, mem) + climbStairs(n - 2, mem);
            return mem[n];
        }
    }

    /**
     * To get to step n we can do 2 steps from n-2 or 1 step from n-1:
     * there is distinct number of ways to get to n-1 and there is a number of distinct ways to get to n-2 step
     * q(n) - number of of distinct ways to get to step n
     * q(n) = q(n-2) + q(n-1)
     */
    public int climbStairsIterative(int n) {
        if( n == 0 )
            return 0;
        if( n == 1 )
            return 1;
        if(n == 2)
            return 2;

        int oneStepBefore = 2;
        int twoStepsBefore = 1;
        int sum = 0;

        for(int i=2; i<n; i++) {
            sum = oneStepBefore + twoStepsBefore;
            twoStepsBefore = oneStepBefore;
            oneStepBefore = sum;
        }

        return sum;
    }

}
