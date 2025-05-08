package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\r\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00060\u0003j\u0002`\u0004¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", BuildConfig.FLAVOR, "packedValue", BuildConfig.FLAVOR, "Landroidx/compose/ui/input/pointer/NativePointerKeyboardModifiers;", "constructor-impl", "(I)I", "equals", BuildConfig.FLAVOR, "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", BuildConfig.FLAVOR, "toString-impl", "(I)Ljava/lang/String;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PointerKeyboardModifiers {
    private final int packedValue;

    private /* synthetic */ PointerKeyboardModifiers(int i5) {
        this.packedValue = i5;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PointerKeyboardModifiers m1897boximpl(int i5) {
        return new PointerKeyboardModifiers(i5);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1898constructorimpl(int i5) {
        return i5;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1899equalsimpl(int i5, Object obj) {
        return (obj instanceof PointerKeyboardModifiers) && i5 == ((PointerKeyboardModifiers) obj).getPackedValue();
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1900hashCodeimpl(int i5) {
        return Integer.hashCode(i5);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1901toStringimpl(int i5) {
        return "PointerKeyboardModifiers(packedValue=" + i5 + ')';
    }

    public boolean equals(Object obj) {
        return m1899equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m1900hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m1901toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getPackedValue() {
        return this.packedValue;
    }
}
