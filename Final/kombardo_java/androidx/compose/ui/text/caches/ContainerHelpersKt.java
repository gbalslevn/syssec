package androidx.compose.ui.text.caches;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u001c\u0010\u0006\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00038\u0000X\u0081\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\n"}, d2 = {"EMPTY_INTS", BuildConfig.FLAVOR, "EMPTY_OBJECTS", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "[Ljava/lang/Object;", "binarySearchInternal", BuildConfig.FLAVOR, "size", "value", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ContainerHelpersKt {
    public static final int[] EMPTY_INTS = new int[0];
    public static final Object[] EMPTY_OBJECTS = new Object[0];

    public static final int binarySearchInternal(int[] iArr, int i5, int i6) {
        int i7 = i5 - 1;
        int i8 = 0;
        while (i8 <= i7) {
            int i9 = (i8 + i7) >>> 1;
            int i10 = iArr[i9];
            if (i10 < i6) {
                i8 = i9 + 1;
            } else {
                if (i10 <= i6) {
                    return i9;
                }
                i7 = i9 - 1;
            }
        }
        return ~i8;
    }
}
