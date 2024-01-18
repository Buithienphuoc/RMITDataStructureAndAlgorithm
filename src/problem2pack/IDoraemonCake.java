package problem2pack;

public interface IDoraemonCake {
    /**
     *
     * @return the largest weight you can achieve
     * if the surface area A of the cake is unlimited.
     * Ensure this method produces no side effects.
     * For the example above, this method returns 23.0.
     */
    double unlimitedCake();

    /**
     * assume that you can print at most X topics regardless of
     * the cake surface area A (X is the argument provided and X <= N)
     *
     * @param X int
     * @return the largest weight you can achieve by eating the cake.
     * Ensure this method produces no side effects.
     * For the example above, if X = 2,
     * this method returns 18.0 (this is the total weight of W1 and W2);
     * if X = 1, this method returns 10.0 (it is W2).
     */
    double weightByNumber(int X);

    /**
     *
     * @return the largest weight possible
     * (note: total printed area of all selected topics must not exceed the cake surface area A).
     * In addition, display the topics' indices that have been printed to achieve this largest weight
     * (use a space to separate two consecutive values).
     * Because the number of topics is at most 20, even an exponential time algorithm still works well in this case.
     * Ensure this method produces no side effects.
     * For the example above, you can print the first and third topics on the cake surface,
     * and this method returns 13.0 and outputs "0 2" (without quote) to the screen
     * ("2 0" is also correct. In other words, the order of numbers does not matter)
     */
    double largestWeight();
}
