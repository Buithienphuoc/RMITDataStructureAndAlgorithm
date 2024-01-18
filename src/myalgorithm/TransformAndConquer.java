package myalgorithm;

public class TransformAndConquer {
    public static void heapSort(int[] array){
        int numberOfElements = array.length;

        // Build heap (rearrange array)
        for (int subset = numberOfElements / 2 - 1; subset >= 0; subset--)
            heapify(array, numberOfElements, subset);

        // One by one extract an element from heap
        for (int element = numberOfElements - 1; element > 0; element--) {
            // Move current root to end
            int temp = array[0];
            array[0] = array[element];
            array[element] = temp;

            // call max heapify on the reduced heap
            heapify(array, element, 0);
        }
    }

    /**
     * Complexity O(2^N)
     * @param firstInt first number
     * @param secondInt second number
     * @return LCM
     */
    public static Integer findLeastCommonMultiple(Integer firstInt, Integer secondInt){
        if (firstInt == 0 || secondInt == 0)
            return 0;
        else {
            int gcd = findGreatestCommonDivisor(firstInt, secondInt); // O(2^N)
            return Math.abs(firstInt * secondInt) / gcd;
        }
    }

    /**
     * Complexity O(2^N)
     * @param firstInt first number
     * @param secondInt second number
     * @return GCD()
     */
    public static Integer findGreatestCommonDivisor(Integer firstInt, Integer secondInt){
        if (secondInt == 0) {
            return firstInt;
        }
        return findGreatestCommonDivisor(secondInt, firstInt % secondInt);
    }

    private static void heapify(int[] array, int N, int i)
    {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < N && array[left] > array[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < N && array[right] > array[largest])
            largest = right;

        // If largest is not root
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(array, N, largest);
        }
    }

    /* A utility function to print array of size n */
    private static void printArray(int[] arr)
    {
        int N = arr.length;

        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }
}
