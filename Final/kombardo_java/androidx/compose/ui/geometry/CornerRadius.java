package androidx.compose.ui.geometry;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\b\u0087@\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0013\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0016\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0014\u0010\u0010\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/geometry/CornerRadius;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "packedValue", "constructor-impl", "(J)J", BuildConfig.FLAVOR, "toString-impl", "(J)Ljava/lang/String;", "toString", BuildConfig.FLAVOR, "hashCode-impl", "(J)I", "hashCode", BuildConfig.FLAVOR, "getX-impl", "(J)F", "getX$annotations", "()V", "x", "getY-impl", "getY$annotations", "y", "Companion", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class CornerRadius {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = CornerRadiusKt.CornerRadius$default(0.0f, 0.0f, 2, null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, d2 = {"Landroidx/compose/ui/geometry/CornerRadius$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/geometry/CornerRadius;", "Zero", "J", "getZero-kKHJgLs", "()J", "getZero-kKHJgLs$annotations", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getZero-kKHJgLs, reason: not valid java name */
        public final long m1327getZerokKHJgLs() {
            return CornerRadius.Zero;
        }

        private Companion() {
        }
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m1321constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1322equalsimpl0(long j5, long j6) {
        return j5 == j6;
    }

    /* renamed from: getX-impl, reason: not valid java name */
    public static final float m1323getXimpl(long j5) {
        return Float.intBitsToFloat((int) (j5 >> 32));
    }

    /* renamed from: getY-impl, reason: not valid java name */
    public static final float m1324getYimpl(long j5) {
        return Float.intBitsToFloat((int) (j5 & 4294967295L));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1325hashCodeimpl(long j5) {
        return Long.hashCode(j5);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1326toStringimpl(long j5) {
        if (m1323getXimpl(j5) == m1324getYimpl(j5)) {
            return "CornerRadius.circular(" + GeometryUtilsKt.toStringAsFixed(m1323getXimpl(j5), 1) + ')';
        }
        return "CornerRadius.elliptical(" + GeometryUtilsKt.toStringAsFixed(m1323getXimpl(j5), 1) + ", " + GeometryUtilsKt.toStringAsFixed(m1324getYimpl(j5), 1) + ')';
    }
}
