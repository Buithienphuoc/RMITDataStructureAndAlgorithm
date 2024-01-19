package problem3pack;

public interface IEasyLearning {
    /**
     *
     * @return the total switching cost of the learning sequence that
     * consists of exactly two courses: cost 0 and course N-1.
     */
    int directSequence();

    /**
     * seq1 and seq2 contain two learning sequences.
     * Each element of seq1 and seq2 stores the index of a course
     * @param seq1 int[]
     * @param seq2 int[]
     * @return 1 if the total switching cost of seq1 is larger than the total switching cost of seq2,
     * return -1 if the opposite is true, and
     * return 0 if the two total switching costs are equal
     */
    int compare(int[] seq1, int[] seq2);

    /**
     *
     * @return the total switching cost of the best learning sequence.
     * In addition, display the best learning sequence too
     * (use a space to separate two consecutive course indices).
     * Due to the number of courses, any solution that has a complexity of exponential time or factorial time will not work
     */
    int bestSequence();
}
