package net.max_di.rtw.common.entity.dynamite_stick;

import java.util.Arrays;
import java.util.Comparator;

public enum ThrownDynamiteStickVariant {
    SINGLE(0),
    SINGLE_SPIKY(1),
    QUADRUPLE(2),
    QUADRUPLE_SPIKY(3),
    NINE_BY_NINE(4),
    NINE_BY_NINE_SPIKY(5);

    private static final ThrownDynamiteStickVariant[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(ThrownDynamiteStickVariant::getId)).toArray(ThrownDynamiteStickVariant[]::new);

    private final int id;

    ThrownDynamiteStickVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static ThrownDynamiteStickVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
