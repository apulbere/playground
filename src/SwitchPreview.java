public class SwitchPreview {

    public static void main(String[] args) {
        System.out.println(getAnswer(Answer.NO));
        System.out.println(getWeekDay(WeekDay.FRIDAY));

        howMany(2);
        howMany(99);

        System.out.println(getWeekDayWithFallThrough(WeekDay.MONDAY));
    }

    private static String getAnswer(Answer answer) {
        return switch(answer) {         //the compiler is able to detect whether all enum values are covered
            case YES -> "Yes !!!";
            case NO -> "No ???";
        };
    }

    enum Answer {
        YES, NO
    }

    private static String getWeekDay(WeekDay weekDay) {
        var result = switch(weekDay) {
            case FRIDAY -> "it's friday";
            case MONDAY -> "it's monday";
            default -> "other";
            // the switch expression does not cover all possible input values
        };
        return result;
    }

    enum WeekDay {
        MONDAY, FRIDAY, SUNDAY
    }

    private static void howMany(int k) {
        switch (k) {
            case 1 -> System.out.println("one");
            case 2 -> System.out.println("two");
            case 3 -> System.out.println("many");
        }
    }

    private static String getWeekDayWithFallThrough(WeekDay weekDay) {
        return switch (weekDay) {
            case MONDAY:
            case FRIDAY:
            default:
                break "default week day";
        };
    }
}
