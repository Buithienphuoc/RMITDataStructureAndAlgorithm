package myalgorithm;

import mylib.MyArrayList;

public class DynamicProgrammingExecutor {
    private static final MyArrayList<Integer> KNAPSACK_RESULT_INDEX_LIST = new MyArrayList<>();
    /**
     * Knapsack problem
     * @param maxCons limited weight
     * @param consArray insert in order
     * @param prosArray insert in order
     * @param numberOfItems all items consider to get
     * @return the value can get with limited weight
     */
    public static int findMaxTotalValueWithLimitedWeightKnapsack(int maxCons, int[] consArray, int[] prosArray, int numberOfItems) {
        // Base Case
        if (numberOfItems == 0 || maxCons == 0)
            return 0;

        // If weight of the nth item is
        // more than Knapsack capacity maxCons,
        // then this item cannot be included
        // in the optimal solution
        int itemIndex = numberOfItems - 1;
        if (consArray[itemIndex] > maxCons) {
            return findMaxTotalValueWithLimitedWeightKnapsack(maxCons, consArray, prosArray, numberOfItems - 1);
        }

        // Return the maximum of two cases:
        // (1) nth item included
        // (2) not included
        else {
            int firstCase = prosArray[numberOfItems - 1]
                    + findMaxTotalValueWithLimitedWeightKnapsack(maxCons - consArray[numberOfItems - 1], consArray,
                    prosArray, numberOfItems - 1);
            int secondCase = findMaxTotalValueWithLimitedWeightKnapsack(maxCons, consArray, prosArray, numberOfItems - 1);
            int result = Math.max(firstCase, secondCase);
            if (result == firstCase) {
                KNAPSACK_RESULT_INDEX_LIST.add(numberOfItems - 1);
            } else {
                KNAPSACK_RESULT_INDEX_LIST.remove(numberOfItems - 1);
            }
            return result;
        }
    }

    public static MyArrayList<Integer> getKnapsackResultIndexList(){
        if (KNAPSACK_RESULT_INDEX_LIST.isEmpty()){
            System.out.println("There is not any result in the list");
            System.out.println("Please execute findMaxTotalValueWithLimitedWeightKnapsack before get the result:");
        }
        return KNAPSACK_RESULT_INDEX_LIST;
    }
}
