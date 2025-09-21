package dao;

import java.util.concurrent.atomic.AtomicInteger;

public final class Ids {
    private static final AtomicInteger GEN = new AtomicInteger(1);
    private Ids() {}
    public static int next() { return GEN.getAndIncrement(); }
}
