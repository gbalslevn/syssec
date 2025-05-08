package androidx.compose.ui.input.rotary;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B)\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u0010¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "verticalScrollPixels", "horizontalScrollPixels", BuildConfig.FLAVOR, "uptimeMillis", BuildConfig.FLAVOR, "inputDeviceId", "<init>", "(FFJI)V", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "F", "getVerticalScrollPixels", "()F", "getHorizontalScrollPixels", "J", "getUptimeMillis", "()J", "I", "getInputDeviceId", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RotaryScrollEvent {
    private final float horizontalScrollPixels;
    private final int inputDeviceId;
    private final long uptimeMillis;
    private final float verticalScrollPixels;

    public RotaryScrollEvent(float f5, float f6, long j5, int i5) {
        this.verticalScrollPixels = f5;
        this.horizontalScrollPixels = f6;
        this.uptimeMillis = j5;
        this.inputDeviceId = i5;
    }

    public boolean equals(Object other) {
        if (other instanceof RotaryScrollEvent) {
            RotaryScrollEvent rotaryScrollEvent = (RotaryScrollEvent) other;
            if (rotaryScrollEvent.verticalScrollPixels == this.verticalScrollPixels && rotaryScrollEvent.horizontalScrollPixels == this.horizontalScrollPixels && rotaryScrollEvent.uptimeMillis == this.uptimeMillis && rotaryScrollEvent.inputDeviceId == this.inputDeviceId) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.verticalScrollPixels) * 31) + Float.hashCode(this.horizontalScrollPixels)) * 31) + Long.hashCode(this.uptimeMillis)) * 31) + Integer.hashCode(this.inputDeviceId);
    }

    public String toString() {
        return "RotaryScrollEvent(verticalScrollPixels=" + this.verticalScrollPixels + ",horizontalScrollPixels=" + this.horizontalScrollPixels + ",uptimeMillis=" + this.uptimeMillis + ",deviceId=" + this.inputDeviceId + ')';
    }
}
