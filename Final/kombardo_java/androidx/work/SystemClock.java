package androidx.work;

/* loaded from: classes.dex */
public class SystemClock implements Clock {
    @Override // androidx.work.Clock
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
