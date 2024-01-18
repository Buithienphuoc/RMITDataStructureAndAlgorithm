package myalgorithm;

public class DynamicProgramming {
    /**
     * Knapsack problem
     * @param maxWeight limited weight
     * @param weightArray insert in order
     * @param profitArray insert in order
     * @param numberOfItems all items consider to get
     * @return the value can get with limited weight
     */
    public static int findMaxTotalValueWithLimitedWeightKnapsack(int maxWeight, int[] weightArray, int[] profitArray, int numberOfItems){
        // Base Case
        if (numberOfItems == 0 || maxWeight == 0)
            return 0;

        // If weight of the nth item is
        // more than Knapsack capacity maxWeight,
        // then this item cannot be included
        // in the optimal solution
        if (weightArray[numberOfItems - 1] > maxWeight)
            return findMaxTotalValueWithLimitedWeightKnapsack(maxWeight, weightArray, profitArray, numberOfItems - 1);

            // Return the maximum of two cases:
            // (1) nth item included
            // (2) not included
        else
            return Math.max(profitArray[numberOfItems - 1]
                            + findMaxTotalValueWithLimitedWeightKnapsack(maxWeight - weightArray[numberOfItems - 1], weightArray,
                            profitArray, numberOfItems - 1),
                    findMaxTotalValueWithLimitedWeightKnapsack(maxWeight, weightArray, profitArray, numberOfItems - 1));
    }
}
