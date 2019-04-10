import java.io.Serializable;

public class SwitchPreviewPolyExpression {

    /**
     * Poly expressions are expressions that may have different types in different contexts.
     * Poly expressions are in contrast to standalone expressions whose type is known at compile time and fixed.
     *
     *
     * That means they don’t have a definitive type of their own, but can be one of several types
     */

    public static void main(String[] args) {

        //we don't have a target type, the expression is not checked to match any given type
        var result2 = switch (3) {
            case 0 -> '0';
            case 1 -> 0.0F;
            case 2 -> 2L;
            case 3 -> true;
            default -> 4;
        };

        System.out.print(result2);
        System.out.print("\t");
        System.out.println(((Object) result2).getClass().getName());

        //compiler infers super type of String and exception
        Serializable result = switch (2) {
            case 1  -> "one";
            case 2  -> "two";
            default -> throw new IllegalStateException();
        };

        System.out.print(result);
        System.out.print("\t");
        System.out.println(result.getClass());
    }
}
