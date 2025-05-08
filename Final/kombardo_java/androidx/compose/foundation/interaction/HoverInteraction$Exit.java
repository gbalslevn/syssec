package androidx.compose.foundation.interaction;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"androidx/compose/foundation/interaction/HoverInteraction$Exit", BuildConfig.FLAVOR, "Landroidx/compose/foundation/interaction/HoverInteraction$Enter;", "enter", "<init>", "(Landroidx/compose/foundation/interaction/HoverInteraction$Enter;)V", "Landroidx/compose/foundation/interaction/HoverInteraction$Enter;", "getEnter", "()Landroidx/compose/foundation/interaction/HoverInteraction$Enter;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HoverInteraction$Exit implements Interaction {
    private final HoverInteraction$Enter enter;

    public HoverInteraction$Exit(HoverInteraction$Enter hoverInteraction$Enter) {
        this.enter = hoverInteraction$Enter;
    }

    public final HoverInteraction$Enter getEnter() {
        return this.enter;
    }
}
