package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0081@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\t\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u000b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\n\u0010\b\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\f"}, d2 = {"Landroidx/compose/ui/input/pointer/ProcessResult;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "constructor-impl", "(I)I", BuildConfig.FLAVOR, "getDispatchedToAPointerInputModifier-impl", "(I)Z", "dispatchedToAPointerInputModifier", "getAnyMovementConsumed-impl", "anyMovementConsumed", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ProcessResult {
    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1915constructorimpl(int i5) {
        return i5;
    }

    /* renamed from: getAnyMovementConsumed-impl, reason: not valid java name */
    public static final boolean m1916getAnyMovementConsumedimpl(int i5) {
        return (i5 & 2) != 0;
    }

    /* renamed from: getDispatchedToAPointerInputModifier-impl, reason: not valid java name */
    public static final boolean m1917getDispatchedToAPointerInputModifierimpl(int i5) {
        return (i5 & 1) != 0;
    }
}
