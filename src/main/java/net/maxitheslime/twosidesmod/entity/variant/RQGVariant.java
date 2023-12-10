package net.maxitheslime.twosidesmod.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum RQGVariant {
    DEFAULT(0),
    GOLD(1);

    private static final RQGVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(RQGVariant::getId)).toArray(RQGVariant[]::new);
    private final int id;

    RQGVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static RQGVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
