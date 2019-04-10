## About
Java 12+ features

## Prerequisites
* JDK 12 Early-Access Build, JDK 12

### [JEP 330: Launch Single-File Source-Code Programs](https://openjdk.java.net/jeps/330)

[since Java 11] 

Enhance the java launcher to run a program supplied as a single file of Java source code, including usage from within a script by means of "shebang" files and related techniques.
```
chmod +x src/java-shebang-example
./src/java-shebang-example
```

### [JEP 325: Switch Expressions (Preview)](https://openjdk.java.net/jeps/325)

Extend the switch statement so that it can be used as either a statement or an expression, and that both forms can use either a "traditional" or "simplified" scoping and control flow behavior. 

_javac command is optional due to JEP-330_
```
javac --source 12 --enable-preview src/SwitchPreview.java

java --source 12 --enable-preview src/SwitchPreview.java
```

### Teeing Collector
collector which merges results of two other collectors [JDK-8209685](https://bugs.openjdk.java.net/browse/JDK-8209685)
```
java src/TeeingCollectorProblem.java 

Stream.of('5', 't', 'o', '9', 'p', '1', 'h')
        .collect(Collectors.teeing(
                Collectors.filtering(Character::isLetter, Collectors.toList()),
                Collectors.filtering(not(Character::isLetter), Collectors.toList()),
                List::of
        ));
```

### [JEP 326: Raw String Literals (Preview)](https://openjdk.java.net/jeps/305)

[[why it was drpped]](https://mail.openjdk.java.net/pipermail/jdk-dev/2018-December/002402.html), [[restarting the discussion]](https://mail.openjdk.java.net/pipermail/amber-spec-experts/2019-January/000931.html)

change java to 12 EA (as JEP 326 was removed in final version)
```
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-12.jdk/Contents/Home
```
run
```
java --source 12 --enable-preview src/RawStringLiteralsPreview.java
```

### [JEP 305: Pattern Matching for instanceof (Preview)](https://openjdk.java.net/jeps/305)

[[detailed doc on pattern matching]](http://cr.openjdk.java.net/~briangoetz/amber/pattern-match.html)

Enhance the Java programming language with pattern matching for the instanceof operator.

```
if (obj instanceof String str) {
    str.trim();
} else {
    // can't use str here
}

@Override 
public boolean equals(Object o) { 
    return (o instanceof CaseInsensitiveString cis)
        && cis.equalsIgnoreCase(s); 
}
```
Future work: enhance the Java programming language with pattern matching for other language constructs, such as
```
String formatted =
    switch (obj) {
        case Integer i -> String.format("int %d", i); 
        case Byte b    -> String.format("byte %d", b); 
        case Long l    -> String.format("long %d", l); 
        case Double d  -> String.format("double %f", d); 
        case String s  -> String.format("String %s, s);
        default        -> String.format("Object %s", obj);
    };

```

### [JEP 302: Lambda Leftovers](http://openjdk.java.net/jeps/302)

* [introduce '_' for unnamed parameters](https://bugs.openjdk.java.net/browse/JDK-8150775)

```
BiFunction<Integer, String, String> biss = (i, _) -> String.valueOf(i);
```

* Shadowing of lambda parameters

```
Map<String, Integer> msi = new HashMap<>();

String key = computeSomeKey();
msi.computeIfAbsent(key, key -> key.length()) //error
```

* Better disambiguation for functional expression

```
class Foo {
   static boolean g(String s) { return false }
   static boolean g(Integer i) { return false }
}

m(Foo::g) //ambiguous
```

### [JEP draft: Add detailed message to NullPointerException describing what is null](https://openjdk.java.net/jeps/8220715)

[JDK-8220715](https://bugs.openjdk.java.net/browse/JDK-8220715)

This JEP proposes to enhance the exception text to tell what was null and which action failed.
```
source code: a.to_b.to_c.to_d.num = 99 // a is null
  thrown msg: 'a' is null. Can not read field 'to_b'

source code: nullInstanceField.testNullMessages()
  thrown msg: 'this.nullInstanceField' is null. Can not invoke method 'NullPointerExceptionTest.testNullMessages()V'.
  
source code: a.getB().getBfromB().getC().getD().num = 99 // a.getB().getBfromB().getC().getD() is null
  thrown msg: The return value of 'NullPointerExceptionTest$C.getD()LNullPointerExceptionTest$D;' is null. Can not write field 'num'.
```

### Others
* [Project Loom](https://cr.openjdk.java.net/~rpressler/loom/Loom-Proposal.html)
* [Project Valhalla](https://openjdk.java.net/projects/valhalla/)
    * [JEP 169: Value Objects](https://openjdk.java.net/jeps/169)
        "Codes like a class, works like an int"
    * [JEP 218: Generics over Primitive Types](https://openjdk.java.net/jeps/218)