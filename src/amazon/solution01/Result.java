package amazon.solution01;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Result {
    public static String encrypt(List<Integer> numbers) {
        if (numbers.size() == 2) {
            return String.format("%d%d", numbers.get(0), numbers.get(1));
        }

        List<Integer> reduced = new ArrayList<>();
        for (int i = 0; i < numbers.size() - 1; i++) {
            reduced.add((numbers.get(i) + numbers.get(i + 1)) % 10);
        }

        return encrypt(reduced);
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 5, 6, 7);
        System.out.println(encrypt(numbers));

        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4);
        System.out.println(encrypt(numbers2));

    }
}
