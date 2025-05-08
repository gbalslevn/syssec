package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import java.util.List;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputEvent;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "uptime", BuildConfig.FLAVOR, "Landroidx/compose/ui/input/pointer/PointerInputEventData;", "pointers", "Landroid/view/MotionEvent;", "motionEvent", "<init>", "(JLjava/util/List;Landroid/view/MotionEvent;)V", "J", "getUptime", "()J", "Ljava/util/List;", "getPointers", "()Ljava/util/List;", "Landroid/view/MotionEvent;", "getMotionEvent", "()Landroid/view/MotionEvent;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PointerInputEvent {
    private final MotionEvent motionEvent;
    private final List<PointerInputEventData> pointers;
    private final long uptime;

    public PointerInputEvent(long j5, List<PointerInputEventData> list, MotionEvent motionEvent) {
        this.uptime = j5;
        this.pointers = list;
        this.motionEvent = motionEvent;
    }

    public final MotionEvent getMotionEvent() {
        return this.motionEvent;
    }

    public final List<PointerInputEventData> getPointers() {
        return this.pointers;
    }
}
