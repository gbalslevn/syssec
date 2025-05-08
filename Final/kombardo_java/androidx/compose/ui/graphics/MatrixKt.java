package androidx.compose.ui.graphics;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a2\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, d2 = {"dot", BuildConfig.FLAVOR, "m1", "Landroidx/compose/ui/graphics/Matrix;", "row", BuildConfig.FLAVOR, "m2", "column", "dot-p89u6pk", "([FI[FI)F", "isIdentity", BuildConfig.FLAVOR, "isIdentity-58bKbWc", "([F)Z", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class MatrixKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: dot-p89u6pk, reason: not valid java name */
    public static final float m1564dotp89u6pk(float[] fArr, int i5, float[] fArr2, int i6) {
        int i7 = i5 * 4;
        return (fArr[i7] * fArr2[i6]) + (fArr[i7 + 1] * fArr2[4 + i6]) + (fArr[i7 + 2] * fArr2[8 + i6]) + (fArr[i7 + 3] * fArr2[12 + i6]);
    }

    /* renamed from: isIdentity-58bKbWc, reason: not valid java name */
    public static final boolean m1565isIdentity58bKbWc(float[] fArr) {
        int i5 = 0;
        while (i5 < 4) {
            int i6 = 0;
            while (i6 < 4) {
                if (fArr[(i5 * 4) + i6] != (i5 == i6 ? 1.0f : 0.0f)) {
                    return false;
                }
                i6++;
            }
            i5++;
        }
        return true;
    }
}
