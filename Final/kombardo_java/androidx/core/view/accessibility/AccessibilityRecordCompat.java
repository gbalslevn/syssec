package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityRecord;

/* loaded from: classes.dex */
public abstract class AccessibilityRecordCompat {
    @Deprecated
    public static void setMaxScrollX(AccessibilityRecord accessibilityRecord, int i5) {
        accessibilityRecord.setMaxScrollX(i5);
    }

    @Deprecated
    public static void setMaxScrollY(AccessibilityRecord accessibilityRecord, int i5) {
        accessibilityRecord.setMaxScrollY(i5);
    }
}
