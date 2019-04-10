import java.util.Map;

public class LambdaShadow {

    public static void main(String[] args) {
        var someMap = Map.of("4", 4);

        var key = "5";

        System.out.println(someMap.computeIfAbsent("6", key -> Integer.valueOf(key)));
        //variable key is already defined in method main(String[])
    }
}
