import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public class TeeingCollector {

    public static void main(String[] args) {
        var lettersAndNumbers = Stream.of('5', 't', 'o', '9', 'p', '1', 'h')
                .collect(Collectors.teeing(
                        Collectors.filtering(Character::isLetter, Collectors.toList()),
                        Collectors.filtering(not(Character::isLetter), Collectors.toList()),
                        List::of
                ));
        System.out.println(lettersAndNumbers);

        double average = Stream.of(1, 4, 2, 7, 4, 6, 5)
                .collect(Collectors.teeing(
                        Collectors.summingDouble(i -> i),
                        Collectors.counting(),
                        (sum, n) -> sum / n));
        System.out.println("average: " + average);

        var maxMin = Stream.of(4, 6, 8, 9, 10, 34, 55)
                .collect(Collectors.teeing(
                        Collectors.maxBy(Integer::compareTo),
                        Collectors.minBy(Integer::compareTo),
                        (maxOp, minOp) -> new MaxMin(maxOp.get(), minOp.get())
                ));
        System.out.println(maxMin);
    }

    private static class MaxMin {
        int max;
        int min;

        MaxMin(int max, int min) {
            this.max = max;
            this.min = min;
        }

        @Override
        public String toString() {
            return "MaxMin{" +
                    "max=" + max +
                    ", min=" + min +
                    '}';
        }
    }
}
