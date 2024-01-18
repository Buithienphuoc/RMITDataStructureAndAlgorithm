import problem2pack.DoraemonCake;
import problem2pack.IDoraemonCake;
import problem2pack.Topic;

public class Problem2 {
    public static void main(String[] args) {
        Topic[] topics = {new Topic(8,7), new Topic(10,8), new Topic(5,3)};
        DoraemonCake cake = new DoraemonCake(topics, 10);
        System.out.println("Unlimited cake:" + cake.unlimitedCake());
        System.out.println("Weight by number X:" + cake.weightByNumber(1));
        System.out.println("Largest weight can reach:" + cake.largestWeight());
    }
}
