public class RawStringLiteralsPreview {

    public static void main(String[] args) {
        var bigStr = `
            <html>
                <body>
                    <p style="text-color: red">Hello World</p>
                </body>
            </html>
        `;

        var bigStr2 = ```````````This is also valid```````````;

        //remove leading indentation
        //JDK-8200435
        System.out.println(bigStr.align());

        System.out.println(bigStr.align(100));

        System.out.println(bigStr.indent(4));
        System.out.println(bigStr.align(4));    //4 is the indentation applied to the string after alignment

        System.out.println(```A String```.equals("A String"));

        //available in JDK 12 General-Availability Release

        var newStr = " Lorem ipsum dolor sit ".transform(String::trim)
                .transform(s -> s.substring(0, 10))
                .transform(s -> s + "...");
        System.out.println(newStr);

        //since Java 11

        System.out.println("hello !".repeat(12));

        "jdk \n  java  \n lambda \n streams".lines()    //lazily provide lines from the source string
                .map(String::trim)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
