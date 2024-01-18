package problem1pack;

public interface ISecretSearch {
    /**
     * @return the minimum time agent A can reach line L. Ensure this method produces no side effects.
     */
    double minTimeA();
    /**
     * @return the time agent A goes from its original location (XA, YA) to a point Z whose coordinate is (XZ, 0) (XZ is the argument provided). Ensure this method produces no side effects.
     */
    double timeFromA(double xZ);

    /**
     * @return the X coordinate of point C in line L where agent A and agent B arrive there at the same time. Ensure this method produces no side effects.
     */
    double pointC();
}
