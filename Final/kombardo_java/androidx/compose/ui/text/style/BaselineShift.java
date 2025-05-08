package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087@\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0012\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/text/style/BaselineShift;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "multiplier", "constructor-impl", "(F)F", BuildConfig.FLAVOR, "toString-impl", "(F)Ljava/lang/String;", "toString", BuildConfig.FLAVOR, "hashCode-impl", "(F)I", "hashCode", "other", BuildConfig.FLAVOR, "equals-impl", "(FLjava/lang/Object;)Z", "equals", "F", "getMultiplier", "()F", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BaselineShift {
    private final float multiplier;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float Superscript = m2456constructorimpl(0.5f);
    private static final float Subscript = m2456constructorimpl(-0.5f);
    private static final float None = m2456constructorimpl(0.0f);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, d2 = {"Landroidx/compose/ui/text/style/BaselineShift$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/text/style/BaselineShift;", "None", "F", "getNone-y9eOQZs", "()F", "getNone-y9eOQZs$annotations", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getNone-y9eOQZs, reason: not valid java name */
        public final float m2462getNoney9eOQZs() {
            return BaselineShift.None;
        }

        private Companion() {
        }
    }

    private /* synthetic */ BaselineShift(float f5) {
        this.multiplier = f5;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ BaselineShift m2455boximpl(float f5) {
        return new BaselineShift(f5);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static float m2456constructorimpl(float f5) {
        return f5;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2457equalsimpl(float f5, Object obj) {
        return (obj instanceof BaselineShift) && Float.compare(f5, ((BaselineShift) obj).getMultiplier()) == 0;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2458equalsimpl0(float f5, float f6) {
        return Float.compare(f5, f6) == 0;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2459hashCodeimpl(float f5) {
        return Float.hashCode(f5);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2460toStringimpl(float f5) {
        return "BaselineShift(multiplier=" + f5 + ')';
    }

    public boolean equals(Object obj) {
        return m2457equalsimpl(this.multiplier, obj);
    }

    public int hashCode() {
        return m2459hashCodeimpl(this.multiplier);
    }

    public String toString() {
        return m2460toStringimpl(this.multiplier);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ float getMultiplier() {
        return this.multiplier;
    }
}
