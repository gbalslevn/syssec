package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\"\u0015\u0010\u0007\u001a\u00020\u0004*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0015\u0010\t\u001a\u00020\u0004*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006*\f\b\u0000\u0010\u000b\"\u00020\n2\u00020\n*\f\b\u0000\u0010\f\"\u00020\n2\u00020\n¨\u0006\r"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "EmptyPointerKeyboardModifiers", "()I", "Landroidx/compose/ui/input/pointer/PointerButtons;", BuildConfig.FLAVOR, "isPrimaryPressed-aHzCx-E", "(I)Z", "isPrimaryPressed", "isSecondaryPressed-aHzCx-E", "isSecondaryPressed", BuildConfig.FLAVOR, "NativePointerButtons", "NativePointerKeyboardModifiers", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PointerEvent_androidKt {
    public static final int EmptyPointerKeyboardModifiers() {
        return PointerKeyboardModifiers.m1898constructorimpl(0);
    }

    /* renamed from: isPrimaryPressed-aHzCx-E, reason: not valid java name */
    public static final boolean m1867isPrimaryPressedaHzCxE(int i5) {
        return (i5 & 33) != 0;
    }

    /* renamed from: isSecondaryPressed-aHzCx-E, reason: not valid java name */
    public static final boolean m1868isSecondaryPressedaHzCxE(int i5) {
        return (i5 & 66) != 0;
    }
}
