public class SwitchPreviewVarScope {

    public static void main(String[] args) {
        System.out.println(getValue(Answer.NO));
        System.out.println(getValueSwitchStatement(Answer.NO));
    }

    private static String getValue(Answer answer) {
        return switch(answer) {
            case YES -> {                   //statement block
              int i = 0;
              break answer.toString() + i;  // return not allowed; break is mandatory
            }
            case NO -> {
              int i = 4;                    // no conflict with i from YES
              break answer.toString() + i;
            }
        };
    }

    private static String getValueSwitchStatement(Answer answer) {
        switch(answer) {
            case YES:
                int h = 0;
                return answer.toString() + h;
            case NO:
                int h = 4;
                return answer.toString() + h;   // variable j is already defined in method getValueSwitchStatement(Answer)
            default:
                throw new IllegalStateException();
        }
    }

    enum Answer {
        YES, NO
    }
}
