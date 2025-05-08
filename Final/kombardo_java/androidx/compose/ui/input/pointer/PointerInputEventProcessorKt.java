package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"ProcessResult", "Landroidx/compose/ui/input/pointer/ProcessResult;", "dispatchedToAPointerInputModifier", BuildConfig.FLAVOR, "anyMovementConsumed", "(ZZ)I", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PointerInputEventProcessorKt {
    public static final int ProcessResult(boolean z5, boolean z6) {
        return ProcessResult.m1915constructorimpl((z5 ? 1 : 0) | (z6 ? 2 : 0));
    }
}
