package problem2pack;

public class Topic {
    double weight;
    double surface;

    public Topic(double weight, double surface) {
        this.weight = weight;
        this.surface = surface;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "weight=" + weight +
                ", surface=" + surface +
                '}';
    }
}
