import problem1pack.SecretSearch;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Problem1 {
    public static void main(String[] args) {
        double[] input = {-1, 1, 1, 1, -1, 0.5};
        SecretSearch secretSearch = new SecretSearch(input);
        System.out.println(secretSearch);
        System.out.println(secretSearch.minTimeA());
        System.out.println(secretSearch.timeFromA(0));
        System.out.println(secretSearch.pointC());
    }
}