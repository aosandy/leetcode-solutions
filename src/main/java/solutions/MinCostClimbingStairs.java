package solutions;

/**
 * 746. Min Cost Climbing Stairs
 */

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {10,15,20};
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int step2 = cost[0];
        int step1 = cost[1];
        int currentStep = Math.min(step1, step2);
        for (int i = 2; i < cost.length; i++) {
            currentStep = Math.min(step1, step2) + cost[i];
            step2 = step1;
            step1 = currentStep;
        }
        return Math.min(currentStep, step2);
    }
}
