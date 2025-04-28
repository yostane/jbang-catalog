///usr/bin/env jbang "$0" "$@" ; exit $?

import static java.lang.System.*;
import java.nio.file.Paths;
import java.nio.file.Files;

public class test {

    public static void main(String... args) throws Exception {
        Files.list(Paths.get("work")).filter(f -> f.endsWith("java"))
                .forEach(f -> System.out.println(f.endsWith("java")));
    }
}
