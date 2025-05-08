package androidx.compose.ui.platform;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR0\u0010\u0013\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\r8W@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\u0012\u0004\b\u0012\u0010\u0003\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/platform/WindowInfoImpl;", "Landroidx/compose/ui/platform/WindowInfo;", "<init>", "()V", "Landroidx/compose/runtime/MutableState;", BuildConfig.FLAVOR, "_isWindowFocused", "Landroidx/compose/runtime/MutableState;", "value", "isWindowFocused", "()Z", "setWindowFocused", "(Z)V", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "getKeyboardModifiers-k7X9c1A", "()I", "setKeyboardModifiers-5xRPYO0", "(I)V", "getKeyboardModifiers-k7X9c1A$annotations", "keyboardModifiers", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class WindowInfoImpl implements WindowInfo {
    private static final MutableState<PointerKeyboardModifiers> GlobalKeyboardModifiers;
    private final MutableState<Boolean> _isWindowFocused;

    static {
        MutableState<PointerKeyboardModifiers> mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PointerKeyboardModifiers.m1897boximpl(PointerEvent_androidKt.EmptyPointerKeyboardModifiers()), null, 2, null);
        GlobalKeyboardModifiers = mutableStateOf$default;
    }

    public WindowInfoImpl() {
        MutableState<Boolean> mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this._isWindowFocused = mutableStateOf$default;
    }

    @Override // androidx.compose.ui.platform.WindowInfo
    public boolean isWindowFocused() {
        return this._isWindowFocused.getValue().booleanValue();
    }

    /* renamed from: setKeyboardModifiers-5xRPYO0, reason: not valid java name */
    public void m2153setKeyboardModifiers5xRPYO0(int i5) {
        GlobalKeyboardModifiers.setValue(PointerKeyboardModifiers.m1897boximpl(i5));
    }

    public void setWindowFocused(boolean z5) {
        this._isWindowFocused.setValue(Boolean.valueOf(z5));
    }
}
