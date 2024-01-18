package util;

import java.util.Set;

public class FlightVariants {
    private static Set<String>variants = Set.of("MSK","LDN","BSL","MNK");

    public static Set<String> get() {
        return variants;
    }
}
