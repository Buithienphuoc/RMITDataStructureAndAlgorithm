package problem2pack;

import myalgorithm.DynamicProgramming;

import java.sql.Array;
import java.util.Arrays;

public class DoraemonCake implements IDoraemonCake{
    private Topic[] topicArray;
    private final double area;

    public DoraemonCake(Topic[] topicArray, double area) {
        this.topicArray = topicArray;
        this.area = area;
    }

    /**
     * Complexity: O(n) for loop through the array
     * @return largest weight can achieve => sum of all weight
     */
    @Override
    public double unlimitedCake() {
        double totalWeight = 0;
        for (Topic topic:topicArray) {
            totalWeight += topic.weight; // O(n)
        }
        return totalWeight;
    }

    @Override
    public double weightByNumber(int X) {
        // Merge sort:
        bubbleSortTopicByWeight(topicArray);
        // calculate total X largest weight
        double totalX = 0;
        for (int i = 0; i < X; ++i) {
            totalX += topicArray[i].weight;
        }
        return totalX;
    }

    /**
     * Knapsack problem
     *
     * @return double
     */
    @Override
    public double largestWeight() {
        int[] weightCanLearn = new int[topicArray.length];
        int[] surface = new int[topicArray.length];
        for (int i = 0; i < topicArray.length ; i++) {
            weightCanLearn[i] = (int) topicArray[i].weight;
            surface[i] = (int) topicArray[i].surface;
        }
        return DynamicProgramming.findMaxTotalValueWithLimitedWeightKnapsack((int) area, surface, weightCanLearn, topicArray.length);
    }

    private void bubbleSortTopicByWeight(Topic[] topicArray){
        Topic temp;
        for (int i = 0; i < topicArray.length-1; i++) {
            if (topicArray[i].weight <= topicArray[i+1].weight){
                temp = topicArray[i];
                topicArray[i] = topicArray[i+1];
                topicArray[i+1] = temp;
            }
        }
        System.out.println("Sorted array+" + Arrays.toString(topicArray));
    }
}
