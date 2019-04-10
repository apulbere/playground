import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public class TeeingCollectorProblem {

    public static void main(String[] args) {
        //var strs = List.of("abc");
        var dividedStrings = Stream.of("foo", "hello", "bar", "world")
                .collect(Collectors.teeing(
                        Collectors.filtering((String s) -> s.length() <= 3, Collectors.toList()),
                        Collectors.filtering((String s) -> s.length() > 3, Collectors.toList()),
                        List::of
                ));
        System.out.println(dividedStrings);
    }

    private static class Employee {
        boolean isActive;

        public Employee(boolean isActive) {
            this.isActive = isActive;
        }

        public boolean isActive() {
            return isActive;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "isActive=" + isActive +
                    '}';
        }
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

    /*

    openjdk 12 2019-03-19
    OpenJDK Runtime Environment (build 12+33)
    OpenJDK 64-Bit Server VM (build 12+33, mixed mode, sharing)


    src/TeeingCollectorProblem.java:13: error: incompatible types: inferred type does not conform to equality constraint(s)
                .collect(Collectors.teeing(
                        ^
    inferred: List<String>
    equality constraints(s): List<Object>,R
    where R,T,A are type-variables:
    R extends Object declared in method <T,A,R>filtering(Predicate<? super T>,Collector<? super T,A,R>)
    T extends Object declared in method <T,A,R>filtering(Predicate<? super T>,Collector<? super T,A,R>)
    A extends Object declared in method <T,A,R>filtering(Predicate<? super T>,Collector<? super T,A,R>)
    1 error
    error: compilation failed

    */
}
