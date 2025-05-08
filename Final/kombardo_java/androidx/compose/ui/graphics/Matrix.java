package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087@\u0018\u0000 82\u00020\u0001:\u00018B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u001a\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010!\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b \u0010\u001eJ\u0015\u0010#\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\"\u0010\u001eJ+\u0010)\u001a\u00020\r2\b\b\u0002\u0010$\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020\u001b2\b\b\u0002\u0010&\u001a\u00020\u001b¢\u0006\u0004\b'\u0010(J+\u0010+\u001a\u00020\r2\b\b\u0002\u0010$\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020\u001b2\b\b\u0002\u0010&\u001a\u00020\u001b¢\u0006\u0004\b*\u0010(J\u0010\u0010/\u001a\u00020,HÖ\u0001¢\u0006\u0004\b-\u0010.J\u001a\u00104\u001a\u0002012\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b2\u00103R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00105\u001a\u0004\b6\u00107\u0088\u0001\u0003\u0092\u0001\u00020\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00069"}, d2 = {"Landroidx/compose/ui/graphics/Matrix;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "values", "constructor-impl", "([F)[F", "Landroidx/compose/ui/geometry/Offset;", "point", "map-MK-Hz9U", "([FJ)J", "map", "Landroidx/compose/ui/geometry/MutableRect;", "rect", BuildConfig.FLAVOR, "map-impl", "([FLandroidx/compose/ui/geometry/MutableRect;)V", "m", "timesAssign-58bKbWc", "([F[F)V", "timesAssign", BuildConfig.FLAVOR, "toString-impl", "([F)Ljava/lang/String;", "toString", "reset-impl", "([F)V", "reset", BuildConfig.FLAVOR, "degrees", "rotateX-impl", "([FF)V", "rotateX", "rotateY-impl", "rotateY", "rotateZ-impl", "rotateZ", "x", "y", "z", "scale-impl", "([FFFF)V", "scale", "translate-impl", "translate", BuildConfig.FLAVOR, "hashCode-impl", "([F)I", "hashCode", "other", BuildConfig.FLAVOR, "equals-impl", "([FLjava/lang/Object;)Z", "equals", "[F", "getValues", "()[F", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Matrix {
    private final float[] values;

    private /* synthetic */ Matrix(float[] fArr) {
        this.values = fArr;
    }

    /* renamed from: box-impl */
    public static final /* synthetic */ Matrix m1545boximpl(float[] fArr) {
        return new Matrix(fArr);
    }

    /* renamed from: constructor-impl */
    public static float[] m1546constructorimpl(float[] fArr) {
        return fArr;
    }

    /* renamed from: constructor-impl$default */
    public static /* synthetic */ float[] m1547constructorimpl$default(float[] fArr, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i5 & 1) != 0) {
            fArr = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        }
        return m1546constructorimpl(fArr);
    }

    /* renamed from: equals-impl */
    public static boolean m1548equalsimpl(float[] fArr, Object obj) {
        return (obj instanceof Matrix) && Intrinsics.areEqual(fArr, ((Matrix) obj).getValues());
    }

    /* renamed from: hashCode-impl */
    public static int m1549hashCodeimpl(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    /* renamed from: map-MK-Hz9U */
    public static final long m1550mapMKHz9U(float[] fArr, long j5) {
        float m1337getXimpl = Offset.m1337getXimpl(j5);
        float m1338getYimpl = Offset.m1338getYimpl(j5);
        float f5 = 1 / (((fArr[3] * m1337getXimpl) + (fArr[7] * m1338getYimpl)) + fArr[15]);
        if (Float.isInfinite(f5) || Float.isNaN(f5)) {
            f5 = 0.0f;
        }
        return OffsetKt.Offset(((fArr[0] * m1337getXimpl) + (fArr[4] * m1338getYimpl) + fArr[12]) * f5, f5 * ((fArr[1] * m1337getXimpl) + (fArr[5] * m1338getYimpl) + fArr[13]));
    }

    /* renamed from: map-impl */
    public static final void m1551mapimpl(float[] fArr, MutableRect mutableRect) {
        long m1550mapMKHz9U = m1550mapMKHz9U(fArr, OffsetKt.Offset(mutableRect.getLeft(), mutableRect.getTop()));
        long m1550mapMKHz9U2 = m1550mapMKHz9U(fArr, OffsetKt.Offset(mutableRect.getLeft(), mutableRect.getBottom()));
        long m1550mapMKHz9U3 = m1550mapMKHz9U(fArr, OffsetKt.Offset(mutableRect.getRight(), mutableRect.getTop()));
        long m1550mapMKHz9U4 = m1550mapMKHz9U(fArr, OffsetKt.Offset(mutableRect.getRight(), mutableRect.getBottom()));
        mutableRect.setLeft(Math.min(Math.min(Offset.m1337getXimpl(m1550mapMKHz9U), Offset.m1337getXimpl(m1550mapMKHz9U2)), Math.min(Offset.m1337getXimpl(m1550mapMKHz9U3), Offset.m1337getXimpl(m1550mapMKHz9U4))));
        mutableRect.setTop(Math.min(Math.min(Offset.m1338getYimpl(m1550mapMKHz9U), Offset.m1338getYimpl(m1550mapMKHz9U2)), Math.min(Offset.m1338getYimpl(m1550mapMKHz9U3), Offset.m1338getYimpl(m1550mapMKHz9U4))));
        mutableRect.setRight(Math.max(Math.max(Offset.m1337getXimpl(m1550mapMKHz9U), Offset.m1337getXimpl(m1550mapMKHz9U2)), Math.max(Offset.m1337getXimpl(m1550mapMKHz9U3), Offset.m1337getXimpl(m1550mapMKHz9U4))));
        mutableRect.setBottom(Math.max(Math.max(Offset.m1338getYimpl(m1550mapMKHz9U), Offset.m1338getYimpl(m1550mapMKHz9U2)), Math.max(Offset.m1338getYimpl(m1550mapMKHz9U3), Offset.m1338getYimpl(m1550mapMKHz9U4))));
    }

    /* renamed from: reset-impl */
    public static final void m1552resetimpl(float[] fArr) {
        int i5 = 0;
        while (i5 < 4) {
            int i6 = 0;
            while (i6 < 4) {
                fArr[(i6 * 4) + i5] = i5 == i6 ? 1.0f : 0.0f;
                i6++;
            }
            i5++;
        }
    }

    /* renamed from: rotateX-impl */
    public static final void m1553rotateXimpl(float[] fArr, float f5) {
        double d5 = (f5 * 3.141592653589793d) / 180.0d;
        float cos = (float) Math.cos(d5);
        float sin = (float) Math.sin(d5);
        float f6 = fArr[1];
        float f7 = fArr[2];
        float f8 = fArr[5];
        float f9 = fArr[6];
        float f10 = fArr[9];
        float f11 = fArr[10];
        float f12 = fArr[13];
        float f13 = fArr[14];
        fArr[1] = (f6 * cos) - (f7 * sin);
        fArr[2] = (f6 * sin) + (f7 * cos);
        fArr[5] = (f8 * cos) - (f9 * sin);
        fArr[6] = (f8 * sin) + (f9 * cos);
        fArr[9] = (f10 * cos) - (f11 * sin);
        fArr[10] = (f10 * sin) + (f11 * cos);
        fArr[13] = (f12 * cos) - (f13 * sin);
        fArr[14] = (f12 * sin) + (f13 * cos);
    }

    /* renamed from: rotateY-impl */
    public static final void m1554rotateYimpl(float[] fArr, float f5) {
        double d5 = (f5 * 3.141592653589793d) / 180.0d;
        float cos = (float) Math.cos(d5);
        float sin = (float) Math.sin(d5);
        float f6 = fArr[0];
        float f7 = fArr[2];
        float f8 = fArr[4];
        float f9 = fArr[6];
        float f10 = fArr[8];
        float f11 = fArr[10];
        float f12 = fArr[12];
        float f13 = fArr[14];
        fArr[0] = (f6 * cos) + (f7 * sin);
        fArr[2] = ((-f6) * sin) + (f7 * cos);
        fArr[4] = (f8 * cos) + (f9 * sin);
        fArr[6] = ((-f8) * sin) + (f9 * cos);
        fArr[8] = (f10 * cos) + (f11 * sin);
        fArr[10] = ((-f10) * sin) + (f11 * cos);
        fArr[12] = (f12 * cos) + (f13 * sin);
        fArr[14] = ((-f12) * sin) + (f13 * cos);
    }

    /* renamed from: rotateZ-impl */
    public static final void m1555rotateZimpl(float[] fArr, float f5) {
        double d5 = (f5 * 3.141592653589793d) / 180.0d;
        float cos = (float) Math.cos(d5);
        float sin = (float) Math.sin(d5);
        float f6 = fArr[0];
        float f7 = fArr[4];
        float f8 = -sin;
        float f9 = fArr[1];
        float f10 = fArr[5];
        float f11 = fArr[2];
        float f12 = fArr[6];
        float f13 = fArr[3];
        float f14 = fArr[7];
        fArr[0] = (cos * f6) + (sin * f7);
        fArr[1] = (cos * f9) + (sin * f10);
        fArr[2] = (cos * f11) + (sin * f12);
        fArr[3] = (cos * f13) + (sin * f14);
        fArr[4] = (f6 * f8) + (f7 * cos);
        fArr[5] = (f9 * f8) + (f10 * cos);
        fArr[6] = (f11 * f8) + (f12 * cos);
        fArr[7] = (f8 * f13) + (cos * f14);
    }

    /* renamed from: scale-impl */
    public static final void m1556scaleimpl(float[] fArr, float f5, float f6, float f7) {
        fArr[0] = fArr[0] * f5;
        fArr[1] = fArr[1] * f5;
        fArr[2] = fArr[2] * f5;
        fArr[3] = fArr[3] * f5;
        fArr[4] = fArr[4] * f6;
        fArr[5] = fArr[5] * f6;
        fArr[6] = fArr[6] * f6;
        fArr[7] = fArr[7] * f6;
        fArr[8] = fArr[8] * f7;
        fArr[9] = fArr[9] * f7;
        fArr[10] = fArr[10] * f7;
        fArr[11] = fArr[11] * f7;
    }

    /* renamed from: scale-impl$default */
    public static /* synthetic */ void m1557scaleimpl$default(float[] fArr, float f5, float f6, float f7, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = 1.0f;
        }
        if ((i5 & 2) != 0) {
            f6 = 1.0f;
        }
        if ((i5 & 4) != 0) {
            f7 = 1.0f;
        }
        m1556scaleimpl(fArr, f5, f6, f7);
    }

    /* renamed from: timesAssign-58bKbWc */
    public static final void m1558timesAssign58bKbWc(float[] fArr, float[] fArr2) {
        float m1564dotp89u6pk;
        float m1564dotp89u6pk2;
        float m1564dotp89u6pk3;
        float m1564dotp89u6pk4;
        float m1564dotp89u6pk5;
        float m1564dotp89u6pk6;
        float m1564dotp89u6pk7;
        float m1564dotp89u6pk8;
        float m1564dotp89u6pk9;
        float m1564dotp89u6pk10;
        float m1564dotp89u6pk11;
        float m1564dotp89u6pk12;
        float m1564dotp89u6pk13;
        float m1564dotp89u6pk14;
        float m1564dotp89u6pk15;
        float m1564dotp89u6pk16;
        m1564dotp89u6pk = MatrixKt.m1564dotp89u6pk(fArr, 0, fArr2, 0);
        m1564dotp89u6pk2 = MatrixKt.m1564dotp89u6pk(fArr, 0, fArr2, 1);
        m1564dotp89u6pk3 = MatrixKt.m1564dotp89u6pk(fArr, 0, fArr2, 2);
        m1564dotp89u6pk4 = MatrixKt.m1564dotp89u6pk(fArr, 0, fArr2, 3);
        m1564dotp89u6pk5 = MatrixKt.m1564dotp89u6pk(fArr, 1, fArr2, 0);
        m1564dotp89u6pk6 = MatrixKt.m1564dotp89u6pk(fArr, 1, fArr2, 1);
        m1564dotp89u6pk7 = MatrixKt.m1564dotp89u6pk(fArr, 1, fArr2, 2);
        m1564dotp89u6pk8 = MatrixKt.m1564dotp89u6pk(fArr, 1, fArr2, 3);
        m1564dotp89u6pk9 = MatrixKt.m1564dotp89u6pk(fArr, 2, fArr2, 0);
        m1564dotp89u6pk10 = MatrixKt.m1564dotp89u6pk(fArr, 2, fArr2, 1);
        m1564dotp89u6pk11 = MatrixKt.m1564dotp89u6pk(fArr, 2, fArr2, 2);
        m1564dotp89u6pk12 = MatrixKt.m1564dotp89u6pk(fArr, 2, fArr2, 3);
        m1564dotp89u6pk13 = MatrixKt.m1564dotp89u6pk(fArr, 3, fArr2, 0);
        m1564dotp89u6pk14 = MatrixKt.m1564dotp89u6pk(fArr, 3, fArr2, 1);
        m1564dotp89u6pk15 = MatrixKt.m1564dotp89u6pk(fArr, 3, fArr2, 2);
        m1564dotp89u6pk16 = MatrixKt.m1564dotp89u6pk(fArr, 3, fArr2, 3);
        fArr[0] = m1564dotp89u6pk;
        fArr[1] = m1564dotp89u6pk2;
        fArr[2] = m1564dotp89u6pk3;
        fArr[3] = m1564dotp89u6pk4;
        fArr[4] = m1564dotp89u6pk5;
        fArr[5] = m1564dotp89u6pk6;
        fArr[6] = m1564dotp89u6pk7;
        fArr[7] = m1564dotp89u6pk8;
        fArr[8] = m1564dotp89u6pk9;
        fArr[9] = m1564dotp89u6pk10;
        fArr[10] = m1564dotp89u6pk11;
        fArr[11] = m1564dotp89u6pk12;
        fArr[12] = m1564dotp89u6pk13;
        fArr[13] = m1564dotp89u6pk14;
        fArr[14] = m1564dotp89u6pk15;
        fArr[15] = m1564dotp89u6pk16;
    }

    /* renamed from: toString-impl */
    public static String m1559toStringimpl(float[] fArr) {
        return StringsKt.trimIndent("\n            |" + fArr[0] + ' ' + fArr[1] + ' ' + fArr[2] + ' ' + fArr[3] + "|\n            |" + fArr[4] + ' ' + fArr[5] + ' ' + fArr[6] + ' ' + fArr[7] + "|\n            |" + fArr[8] + ' ' + fArr[9] + ' ' + fArr[10] + ' ' + fArr[11] + "|\n            |" + fArr[12] + ' ' + fArr[13] + ' ' + fArr[14] + ' ' + fArr[15] + "|\n        ");
    }

    /* renamed from: translate-impl */
    public static final void m1560translateimpl(float[] fArr, float f5, float f6, float f7) {
        float f8 = (fArr[0] * f5) + (fArr[4] * f6) + (fArr[8] * f7) + fArr[12];
        float f9 = (fArr[1] * f5) + (fArr[5] * f6) + (fArr[9] * f7) + fArr[13];
        float f10 = (fArr[2] * f5) + (fArr[6] * f6) + (fArr[10] * f7) + fArr[14];
        float f11 = (fArr[3] * f5) + (fArr[7] * f6) + (fArr[11] * f7) + fArr[15];
        fArr[12] = f8;
        fArr[13] = f9;
        fArr[14] = f10;
        fArr[15] = f11;
    }

    /* renamed from: translate-impl$default */
    public static /* synthetic */ void m1561translateimpl$default(float[] fArr, float f5, float f6, float f7, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = 0.0f;
        }
        if ((i5 & 2) != 0) {
            f6 = 0.0f;
        }
        if ((i5 & 4) != 0) {
            f7 = 0.0f;
        }
        m1560translateimpl(fArr, f5, f6, f7);
    }

    public boolean equals(Object obj) {
        return m1548equalsimpl(this.values, obj);
    }

    public int hashCode() {
        return m1549hashCodeimpl(this.values);
    }

    public String toString() {
        return m1559toStringimpl(this.values);
    }

    /* renamed from: unbox-impl, reason: from getter */
    public final /* synthetic */ float[] getValues() {
        return this.values;
    }
}
