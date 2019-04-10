public class SwitchPreviewAlphabet {

    public static void main(String[] args) {
        System.out.println(getValue("R"));
        System.out.println(getValue("B"));
        System.out.println(getValue("E"));
    }

    private static String getValue(String letter) {
        return switch(letter) {
            case "A", "B", "C" -> "ABC";
            case "D", "E"      -> "DE";
            default            -> "others";
        };
    }
}
