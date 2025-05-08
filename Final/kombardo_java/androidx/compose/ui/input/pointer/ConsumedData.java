package androidx.compose.ui.input.pointer;

import kotlin.Deprecated;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Deprecated
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R(\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0003\u0010\u0007\u0012\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0004\u0010\u0007\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/input/pointer/ConsumedData;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "positionChange", "downChange", "<init>", "(ZZ)V", "Z", "getPositionChange", "()Z", "setPositionChange", "(Z)V", "getPositionChange$annotations", "()V", "getDownChange", "setDownChange", "getDownChange$annotations", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ConsumedData {
    private boolean downChange;
    private boolean positionChange;

    public ConsumedData(boolean z5, boolean z6) {
        this.positionChange = z5;
        this.downChange = z6;
    }

    public final boolean getDownChange() {
        return this.downChange;
    }

    public final boolean getPositionChange() {
        return this.positionChange;
    }

    public final void setDownChange(boolean z5) {
        this.downChange = z5;
    }

    public final void setPositionChange(boolean z5) {
        this.positionChange = z5;
    }
}
