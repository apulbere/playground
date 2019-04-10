import java.util.function.BiFunction;

public class LambdaUnderscore {

    public static void main(String[] args) {

        BiFunction<Integer, String, String> intToStringFunction = (i, _) -> String.valueOf(i);
        //use of '_' as an identifier is forbidden for lambda parameters

        System.out.println(intToStringFunction.apply(6, "six"));
    }
}
