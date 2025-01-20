package net.max_di.rtw.common.entity.gingerbread.gingerbread_man;

import java.util.Arrays;
import java.util.Comparator;

public enum GingerbreadManVariant {
    HAPPY(0),
    SIGMA(1),
    MOSKA(2),
    LYBA(3),
    SAD(4),
    DUMB(5),
    LEMON(6);

    private static final GingerbreadManVariant[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(GingerbreadManVariant::getId)).toArray(GingerbreadManVariant[]::new);

    private final int id;

    GingerbreadManVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static GingerbreadManVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
