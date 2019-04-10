import java.util.function.Function;
import java.util.function.Predicate;

public class AmbiguousMethodReference {

    public static void main(String[] args) {
        doSomething(s -> false);            // reference to dpSomething is ambiguous

        doSomething((Predicate<String>) s -> false);



        doSomething(s -> "empty");          // reference to dpSomething is ambiguous

        doSomething((Function<String, String>) fun -> "blank");
    }

    public static void doSomething(Predicate<String> ps) {
        System.out.println("doSomething with Predicate");
    }

    public static void doSomething(Function<String, String> fss) {
        System.out.println("doSomething with Function");
    }
}
