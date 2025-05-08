package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import java.util.List;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B!\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0017\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0007\u0010\tJ\u0015\u0010\r\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u00020\u00148\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\fR\u001d\u0010\u0019\u001a\u00020\u00188\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\fR0\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n8\u0006@@X\u0086\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\u0012\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u0004\u0018\u00010 8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerEvent;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Landroidx/compose/ui/input/pointer/PointerInputChange;", "changes", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "internalPointerEvent", "<init>", "(Ljava/util/List;Landroidx/compose/ui/input/pointer/InternalPointerEvent;)V", "(Ljava/util/List;)V", "Landroidx/compose/ui/input/pointer/PointerEventType;", "calculatePointerEventType-7fucELk", "()I", "calculatePointerEventType", "Ljava/util/List;", "getChanges", "()Ljava/util/List;", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "getInternalPointerEvent$ui_release", "()Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "Landroidx/compose/ui/input/pointer/PointerButtons;", "buttons", "I", "getButtons-ry648PA", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "keyboardModifiers", "getKeyboardModifiers-k7X9c1A", "<set-?>", "type", "getType-7fucELk", "setType-EhbLWgg$ui_release", "(I)V", "Landroid/view/MotionEvent;", "getMotionEvent$ui_release", "()Landroid/view/MotionEvent;", "motionEvent", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PointerEvent {
    private final int buttons;
    private final List<PointerInputChange> changes;
    private final InternalPointerEvent internalPointerEvent;
    private final int keyboardModifiers;
    private int type;

    public PointerEvent(List<PointerInputChange> list, InternalPointerEvent internalPointerEvent) {
        this.changes = list;
        this.internalPointerEvent = internalPointerEvent;
        MotionEvent motionEvent$ui_release = getMotionEvent$ui_release();
        this.buttons = PointerButtons.m1851constructorimpl(motionEvent$ui_release != null ? motionEvent$ui_release.getButtonState() : 0);
        MotionEvent motionEvent$ui_release2 = getMotionEvent$ui_release();
        this.keyboardModifiers = PointerKeyboardModifiers.m1898constructorimpl(motionEvent$ui_release2 != null ? motionEvent$ui_release2.getMetaState() : 0);
        this.type = m1852calculatePointerEventType7fucELk();
    }

    /* renamed from: calculatePointerEventType-7fucELk, reason: not valid java name */
    private final int m1852calculatePointerEventType7fucELk() {
        MotionEvent motionEvent$ui_release = getMotionEvent$ui_release();
        if (motionEvent$ui_release == null) {
            List<PointerInputChange> list = this.changes;
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                PointerInputChange pointerInputChange = list.get(i5);
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                    return PointerEventType.INSTANCE.m1864getRelease7fucELk();
                }
                if (PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange)) {
                    return PointerEventType.INSTANCE.m1863getPress7fucELk();
                }
            }
            return PointerEventType.INSTANCE.m1862getMove7fucELk();
        }
        int actionMasked = motionEvent$ui_release.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    switch (actionMasked) {
                        case 5:
                            break;
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            return PointerEventType.INSTANCE.m1865getScroll7fucELk();
                        case 9:
                            return PointerEventType.INSTANCE.m1860getEnter7fucELk();
                        case 10:
                            return PointerEventType.INSTANCE.m1861getExit7fucELk();
                        default:
                            return PointerEventType.INSTANCE.m1866getUnknown7fucELk();
                    }
                }
                return PointerEventType.INSTANCE.m1862getMove7fucELk();
            }
            return PointerEventType.INSTANCE.m1864getRelease7fucELk();
        }
        return PointerEventType.INSTANCE.m1863getPress7fucELk();
    }

    /* renamed from: getButtons-ry648PA, reason: not valid java name and from getter */
    public final int getButtons() {
        return this.buttons;
    }

    public final List<PointerInputChange> getChanges() {
        return this.changes;
    }

    /* renamed from: getInternalPointerEvent$ui_release, reason: from getter */
    public final InternalPointerEvent getInternalPointerEvent() {
        return this.internalPointerEvent;
    }

    public final MotionEvent getMotionEvent$ui_release() {
        InternalPointerEvent internalPointerEvent = this.internalPointerEvent;
        if (internalPointerEvent != null) {
            return internalPointerEvent.getMotionEvent();
        }
        return null;
    }

    /* renamed from: getType-7fucELk, reason: not valid java name and from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: setType-EhbLWgg$ui_release, reason: not valid java name */
    public final void m1855setTypeEhbLWgg$ui_release(int i5) {
        this.type = i5;
    }

    public PointerEvent(List<PointerInputChange> list) {
        this(list, null);
    }
}
