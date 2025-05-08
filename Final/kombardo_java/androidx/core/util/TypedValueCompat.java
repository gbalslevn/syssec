package androidx.core.util;

import android.annotation.SuppressLint;

/* loaded from: classes.dex */
public abstract class TypedValueCompat {
    private static final float INCHES_PER_MM = 0.03937008f;
    private static final float INCHES_PER_PT = 0.013888889f;

    @SuppressLint({"WrongConstant"})
    public static int getUnitFromComplexDimension(int i5) {
        return i5 & 15;
    }
}
