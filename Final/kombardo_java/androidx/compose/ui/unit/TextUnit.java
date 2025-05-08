package androidx.compose.ui.unit;

import androidx.compose.ui.unit.TextUnitType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0087@\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0012\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u00028@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0014\u0010\u0005R\u0017\u0010\u001a\u001a\u00020\u00188Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0005R\u0011\u0010\u001e\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\u0088\u0001\u0003\u0092\u0001\u00020\u0002\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/compose/ui/unit/TextUnit;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "packedValue", "constructor-impl", "(J)J", BuildConfig.FLAVOR, "toString-impl", "(J)Ljava/lang/String;", "toString", BuildConfig.FLAVOR, "hashCode-impl", "(J)I", "hashCode", "other", BuildConfig.FLAVOR, "equals-impl", "(JLjava/lang/Object;)Z", "equals", "J", "getRawType-impl", "getRawType$annotations", "()V", "rawType", "Landroidx/compose/ui/unit/TextUnitType;", "getType-UIouoOA", "type", BuildConfig.FLAVOR, "getValue-impl", "(J)F", "value", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextUnit {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TextUnitType[] TextUnitTypes;
    private static final long Unspecified;
    private final long packedValue;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, d2 = {"Landroidx/compose/ui/unit/TextUnit$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/unit/TextUnit;", "Unspecified", "J", "getUnspecified-XSAIIZE", "()J", "getUnspecified-XSAIIZE$annotations", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getUnspecified-XSAIIZE, reason: not valid java name */
        public final long m2679getUnspecifiedXSAIIZE() {
            return TextUnit.Unspecified;
        }

        private Companion() {
        }
    }

    static {
        TextUnitType.Companion companion = TextUnitType.INSTANCE;
        TextUnitTypes = new TextUnitType[]{TextUnitType.m2685boximpl(companion.m2694getUnspecifiedUIouoOA()), TextUnitType.m2685boximpl(companion.m2693getSpUIouoOA()), TextUnitType.m2685boximpl(companion.m2692getEmUIouoOA())};
        Unspecified = TextUnitKt.pack(0L, Float.NaN);
    }

    private /* synthetic */ TextUnit(long j5) {
        this.packedValue = j5;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextUnit m2669boximpl(long j5) {
        return new TextUnit(j5);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m2670constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2671equalsimpl(long j5, Object obj) {
        return (obj instanceof TextUnit) && j5 == ((TextUnit) obj).getPackedValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2672equalsimpl0(long j5, long j6) {
        return j5 == j6;
    }

    /* renamed from: getRawType-impl, reason: not valid java name */
    public static final long m2673getRawTypeimpl(long j5) {
        return j5 & 1095216660480L;
    }

    /* renamed from: getType-UIouoOA, reason: not valid java name */
    public static final long m2674getTypeUIouoOA(long j5) {
        return TextUnitTypes[(int) (m2673getRawTypeimpl(j5) >>> 32)].getType();
    }

    /* renamed from: getValue-impl, reason: not valid java name */
    public static final float m2675getValueimpl(long j5) {
        return Float.intBitsToFloat((int) (j5 & 4294967295L));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2676hashCodeimpl(long j5) {
        return Long.hashCode(j5);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2677toStringimpl(long j5) {
        long m2674getTypeUIouoOA = m2674getTypeUIouoOA(j5);
        TextUnitType.Companion companion = TextUnitType.INSTANCE;
        if (TextUnitType.m2688equalsimpl0(m2674getTypeUIouoOA, companion.m2694getUnspecifiedUIouoOA())) {
            return "Unspecified";
        }
        if (TextUnitType.m2688equalsimpl0(m2674getTypeUIouoOA, companion.m2693getSpUIouoOA())) {
            return m2675getValueimpl(j5) + ".sp";
        }
        if (!TextUnitType.m2688equalsimpl0(m2674getTypeUIouoOA, companion.m2692getEmUIouoOA())) {
            return "Invalid";
        }
        return m2675getValueimpl(j5) + ".em";
    }

    public boolean equals(Object obj) {
        return m2671equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2676hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m2677toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }
}
