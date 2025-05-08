package androidx.compose.ui.input.key;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\b\u001a\u00020\u0005*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0015\u0010\u000b\u001a\u00020\t*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007\"\u0015\u0010\u000f\u001a\u00020\f*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u0015\u0010\u0011\u001a\u00020\f*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e\"\u0015\u0010\u0013\u001a\u00020\f*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000e*\n\u0010\u0015\"\u00020\u00142\u00020\u0014¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/input/key/KeyEvent;", "Landroidx/compose/ui/input/key/Key;", "getKey-ZmokQxo", "(Landroid/view/KeyEvent;)J", "key", BuildConfig.FLAVOR, "getUtf16CodePoint-ZmokQxo", "(Landroid/view/KeyEvent;)I", "utf16CodePoint", "Landroidx/compose/ui/input/key/KeyEventType;", "getType-ZmokQxo", "type", BuildConfig.FLAVOR, "isAltPressed-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "isAltPressed", "isCtrlPressed-ZmokQxo", "isCtrlPressed", "isShiftPressed-ZmokQxo", "isShiftPressed", "Landroid/view/KeyEvent;", "NativeKeyEvent", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class KeyEvent_androidKt {
    /* renamed from: getKey-ZmokQxo, reason: not valid java name */
    public static final long m1826getKeyZmokQxo(android.view.KeyEvent keyEvent) {
        return Key_androidKt.Key(keyEvent.getKeyCode());
    }

    /* renamed from: getType-ZmokQxo, reason: not valid java name */
    public static final int m1827getTypeZmokQxo(android.view.KeyEvent keyEvent) {
        int action = keyEvent.getAction();
        return action != 0 ? action != 1 ? KeyEventType.INSTANCE.m1825getUnknownCS__XNY() : KeyEventType.INSTANCE.m1824getKeyUpCS__XNY() : KeyEventType.INSTANCE.m1823getKeyDownCS__XNY();
    }

    /* renamed from: getUtf16CodePoint-ZmokQxo, reason: not valid java name */
    public static final int m1828getUtf16CodePointZmokQxo(android.view.KeyEvent keyEvent) {
        return keyEvent.getUnicodeChar();
    }

    /* renamed from: isAltPressed-ZmokQxo, reason: not valid java name */
    public static final boolean m1829isAltPressedZmokQxo(android.view.KeyEvent keyEvent) {
        return keyEvent.isAltPressed();
    }

    /* renamed from: isCtrlPressed-ZmokQxo, reason: not valid java name */
    public static final boolean m1830isCtrlPressedZmokQxo(android.view.KeyEvent keyEvent) {
        return keyEvent.isCtrlPressed();
    }

    /* renamed from: isShiftPressed-ZmokQxo, reason: not valid java name */
    public static final boolean m1831isShiftPressedZmokQxo(android.view.KeyEvent keyEvent) {
        return keyEvent.isShiftPressed();
    }
}
