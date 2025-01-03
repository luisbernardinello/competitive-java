package amazon.solution02;
import java.util.Arrays;
import java.util.List;

public class Result {
    public static long calculateMaxQualityScore(int impactFactor, List<Integer> ratings) {
        int n = ratings.size();
        int[] arr = ratings.stream().mapToInt(i -> i).toArray();

        // Modified Kadane's Algorithm
        long maxScore = Long.MIN_VALUE;

        // First Strategy, multiply
        long currentSum1 = 0;
        long maxSum1 = Long.MIN_VALUE;

        // Second Strategy, divide
        long currentSum2 = 0;
        long maxSum2 = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            // Strategy 1
            long multiplied = (long) arr[i] * impactFactor;
            currentSum1 = Math.max(multiplied, currentSum1 + multiplied);
            maxSum1 = Math.max(maxSum1, currentSum1);

            // Strategy 2
            long divided;
            if (arr[i] >= 0) {
                divided = arr[i] / impactFactor;
            } else {
                divided = (long) Math.ceil((double) arr[i] / impactFactor);
            }
            currentSum2 = Math.max(divided, currentSum2 + divided);
            maxSum2 = Math.max(maxSum2, currentSum2);
        }

        // Return the greater value between the two strategies
        return Math.max(maxSum1, maxSum2);
    }

    public static void main(String[] args) {
        System.out.println(calculateMaxQualityScore(1, Arrays.asList(-2, 3, -3, -1)));
        System.out.println(calculateMaxQualityScore(3, Arrays.asList(5, -3, -3, 2, 4)));
        System.out.println(calculateMaxQualityScore(2, Arrays.asList(4, -5, 5, -7, 1)));
    }

}
