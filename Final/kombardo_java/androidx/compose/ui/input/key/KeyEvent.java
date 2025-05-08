package androidx.compose.ui.input.key;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087@\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0013\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u0088\u0001\u0004\u0092\u0001\u00060\u0002j\u0002`\u0003¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/input/key/KeyEvent;", BuildConfig.FLAVOR, "Landroid/view/KeyEvent;", "Landroidx/compose/ui/input/key/NativeKeyEvent;", "nativeKeyEvent", "constructor-impl", "(Landroid/view/KeyEvent;)Landroid/view/KeyEvent;", BuildConfig.FLAVOR, "toString-impl", "(Landroid/view/KeyEvent;)Ljava/lang/String;", "toString", BuildConfig.FLAVOR, "hashCode-impl", "(Landroid/view/KeyEvent;)I", "hashCode", "other", BuildConfig.FLAVOR, "equals-impl", "(Landroid/view/KeyEvent;Ljava/lang/Object;)Z", "equals", "Landroid/view/KeyEvent;", "getNativeKeyEvent", "()Landroid/view/KeyEvent;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class KeyEvent {
    private final android.view.KeyEvent nativeKeyEvent;

    private /* synthetic */ KeyEvent(android.view.KeyEvent keyEvent) {
        this.nativeKeyEvent = keyEvent;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ KeyEvent m1815boximpl(android.view.KeyEvent keyEvent) {
        return new KeyEvent(keyEvent);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static android.view.KeyEvent m1816constructorimpl(android.view.KeyEvent keyEvent) {
        return keyEvent;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1817equalsimpl(android.view.KeyEvent keyEvent, Object obj) {
        return (obj instanceof KeyEvent) && Intrinsics.areEqual(keyEvent, ((KeyEvent) obj).getNativeKeyEvent());
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1818hashCodeimpl(android.view.KeyEvent keyEvent) {
        return keyEvent.hashCode();
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1819toStringimpl(android.view.KeyEvent keyEvent) {
        return "KeyEvent(nativeKeyEvent=" + keyEvent + ')';
    }

    public boolean equals(Object obj) {
        return m1817equalsimpl(this.nativeKeyEvent, obj);
    }

    public int hashCode() {
        return m1818hashCodeimpl(this.nativeKeyEvent);
    }

    public String toString() {
        return m1819toStringimpl(this.nativeKeyEvent);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ android.view.KeyEvent getNativeKeyEvent() {
        return this.nativeKeyEvent;
    }
}
