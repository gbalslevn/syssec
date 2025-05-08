package androidx.core.math;

/* loaded from: classes.dex */
public abstract class MathUtils {
    public static int clamp(int i5, int i6, int i7) {
        return i5 < i6 ? i6 : i5 > i7 ? i7 : i5;
    }
}
