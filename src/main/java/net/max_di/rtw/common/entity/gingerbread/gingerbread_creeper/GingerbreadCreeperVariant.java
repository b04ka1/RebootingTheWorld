package net.max_di.rtw.common.entity.gingerbread.gingerbread_creeper;

import java.util.Arrays;
import java.util.Comparator;

public enum GingerbreadCreeperVariant {
    ANGRY(0),
    BOBIK(1), //WHATS THIS
    SAD(2),
    SILLY(3);

    private static final GingerbreadCreeperVariant[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(GingerbreadCreeperVariant::getId)).toArray(GingerbreadCreeperVariant[]::new);

    private final int id;

    GingerbreadCreeperVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static GingerbreadCreeperVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
