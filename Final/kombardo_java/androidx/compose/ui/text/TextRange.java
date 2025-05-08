package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 *2\u00020\u0001:\u0001*B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u000bH\u0086\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u001f\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b#\u0010\rJ\u0018\u0010$\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0000ø\u0001\u0000¢\u0006\u0004\b%\u0010\u001bJ\u000f\u0010&\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0012\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\tR\u0011\u0010\u0016\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\r\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006+"}, d2 = {"Landroidx/compose/ui/text/TextRange;", BuildConfig.FLAVOR, "packedValue", BuildConfig.FLAVOR, "constructor-impl", "(J)J", "collapsed", BuildConfig.FLAVOR, "getCollapsed-impl", "(J)Z", "end", BuildConfig.FLAVOR, "getEnd-impl", "(J)I", "length", "getLength-impl", "max", "getMax-impl", "min", "getMin-impl", "reversed", "getReversed-impl", "start", "getStart-impl", "contains", "other", "contains-5zc-tL8", "(JJ)Z", "offset", "contains-impl", "(JI)Z", "equals", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "intersects", "intersects-5zc-tL8", "toString", BuildConfig.FLAVOR, "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextRange {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = TextRangeKt.TextRange(0);
    private final long packedValue;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\b"}, d2 = {"Landroidx/compose/ui/text/TextRange$Companion;", BuildConfig.FLAVOR, "()V", "Zero", "Landroidx/compose/ui/text/TextRange;", "getZero-d9O1mEE", "()J", "J", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getZero-d9O1mEE, reason: not valid java name */
        public final long m2290getZerod9O1mEE() {
            return TextRange.Zero;
        }

        private Companion() {
        }
    }

    private /* synthetic */ TextRange(long j5) {
        this.packedValue = j5;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextRange m2273boximpl(long j5) {
        return new TextRange(j5);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m2274constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: contains-5zc-tL8, reason: not valid java name */
    public static final boolean m2275contains5zctL8(long j5, long j6) {
        return m2283getMinimpl(j5) <= m2283getMinimpl(j6) && m2282getMaximpl(j6) <= m2282getMaximpl(j5);
    }

    /* renamed from: contains-impl, reason: not valid java name */
    public static final boolean m2276containsimpl(long j5, int i5) {
        return i5 < m2282getMaximpl(j5) && m2283getMinimpl(j5) <= i5;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2277equalsimpl(long j5, Object obj) {
        return (obj instanceof TextRange) && j5 == ((TextRange) obj).getPackedValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2278equalsimpl0(long j5, long j6) {
        return j5 == j6;
    }

    /* renamed from: getCollapsed-impl, reason: not valid java name */
    public static final boolean m2279getCollapsedimpl(long j5) {
        return m2285getStartimpl(j5) == m2280getEndimpl(j5);
    }

    /* renamed from: getEnd-impl, reason: not valid java name */
    public static final int m2280getEndimpl(long j5) {
        return (int) (j5 & 4294967295L);
    }

    /* renamed from: getLength-impl, reason: not valid java name */
    public static final int m2281getLengthimpl(long j5) {
        return m2282getMaximpl(j5) - m2283getMinimpl(j5);
    }

    /* renamed from: getMax-impl, reason: not valid java name */
    public static final int m2282getMaximpl(long j5) {
        return m2285getStartimpl(j5) > m2280getEndimpl(j5) ? m2285getStartimpl(j5) : m2280getEndimpl(j5);
    }

    /* renamed from: getMin-impl, reason: not valid java name */
    public static final int m2283getMinimpl(long j5) {
        return m2285getStartimpl(j5) > m2280getEndimpl(j5) ? m2280getEndimpl(j5) : m2285getStartimpl(j5);
    }

    /* renamed from: getReversed-impl, reason: not valid java name */
    public static final boolean m2284getReversedimpl(long j5) {
        return m2285getStartimpl(j5) > m2280getEndimpl(j5);
    }

    /* renamed from: getStart-impl, reason: not valid java name */
    public static final int m2285getStartimpl(long j5) {
        return (int) (j5 >> 32);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2286hashCodeimpl(long j5) {
        return Long.hashCode(j5);
    }

    /* renamed from: intersects-5zc-tL8, reason: not valid java name */
    public static final boolean m2287intersects5zctL8(long j5, long j6) {
        return m2283getMinimpl(j5) < m2282getMaximpl(j6) && m2283getMinimpl(j6) < m2282getMaximpl(j5);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2288toStringimpl(long j5) {
        return "TextRange(" + m2285getStartimpl(j5) + ", " + m2280getEndimpl(j5) + ')';
    }

    public boolean equals(Object obj) {
        return m2277equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2286hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m2288toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }
}
